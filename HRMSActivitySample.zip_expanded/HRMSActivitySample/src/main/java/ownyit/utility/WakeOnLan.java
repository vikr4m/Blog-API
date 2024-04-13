package ownyit.utility;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class WakeOnLan {
    
    private static final int PORT = 9;    
    
    private String ip_address = null;
    
    private String mac_address = null;
        
    public WakeOnLan(){}
    
    public WakeOnLan(String ip_address, String mac_address){
    	setAdress(ip_address);
    	setMACAdress(mac_address);
    }
    
    public void setAdress(String ip_address){
    	this.ip_address = ip_address;
    }
    
    public void setMACAdress(String mac_address){
    	this.mac_address = mac_address;
    }
        
    public int send(){
    	
    	int status  = 0;
    	
    	InetAddress address = null;
    	
    	DatagramPacket packet = null;
    	
    	DatagramSocket socket = null;
    	
    	try {
           byte[] macBytes = getMacBytes(this.mac_address);
           byte[] bytes = new byte[6 + 16 * macBytes.length];
           
           for (int i = 0; i < 6; i++) {
               bytes[i] = (byte) 0xff;
           }
           
           for (int i = 6; i < bytes.length; i += macBytes.length) {
               System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
           }
            
           address = InetAddress.getByName(this.ip_address);
            
           packet = new DatagramPacket(bytes, bytes.length, address, PORT);
            
           socket = new DatagramSocket();
            
           socket.send(packet);
           
           status = 1;
        }catch (Exception e) {
            status = -1;
        }finally{
        	
        	if(socket != null){
        		try {
					socket.close();
				} catch (Exception e2) {}
        		socket = null;
        	}
        	
        	packet = null;
        	address = null;
        }
    	return status;
    }
    
    public int send(String ip_address, String mac_address){
    	
    	setAdress(ip_address);
    	setMACAdress(mac_address);
    	
    	return send();
    }
    
    private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
    	
        byte[] bytes = new byte[6];
        
        String[] hex = macStr.split("(\\:|\\-)");
        
        if (hex.length != 6) {
        	
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }
    
    public static void main(String[] args) {
        
    	String ipStr = null;
        String macStr = null;
          
        if (args.length != 2) {
            PrintLog.write("Usage: java WakeOnLan <broadcast-ip> <mac-address>");
            PrintLog.write("Example: java WakeOnLan 192.168.0.255 00:0D:61:08:22:4A");
            PrintLog.write("Example: java WakeOnLan 192.168.0.255 00-0D-61-08-22-4A");
            //System.exit(1);
            
            ipStr = "192.168.100.255";
            macStr = "00-27-0E-22-67-66";
            
        }else{
        	
        	ipStr = args[0];
            macStr = args[1];
        }
        
        try {
        	WakeOnLan wakonlan = new WakeOnLan();
            
            wakonlan.setAdress(ipStr);
            wakonlan.setMACAdress(macStr);
            
            int status  = wakonlan.send();
            
            PrintLog.write("Wake-on-LAN packet status = " + status);
        }
        catch (Exception e) {
            PrintLog.write("Failed to send Wake-on-LAN packet: + e");
            e.printStackTrace();
            System.exit(1);
        }
    }
   
}