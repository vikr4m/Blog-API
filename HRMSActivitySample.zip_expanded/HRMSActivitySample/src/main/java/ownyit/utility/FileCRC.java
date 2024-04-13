package ownyit.utility;

import java.io.File;
import java.io.FileInputStream;

public class FileCRC {

	private String strFilename = null;
	
	public FileCRC(String strFilename){
		this.strFilename = strFilename;
	}
	
	public String getFileCRC() {

		String value = null;
		
		FileInputStream in = null;

		try {
			File file = new File(this.strFilename);
			
			int size = file != null ? (int) file.length() : 0;

			in = new FileInputStream(file);
			
			byte[] bytes = new byte[size];
			
			in.read(bytes, 0, size);

			int crc = 0xFFFFFFFF; // initial contents of LFBSR
			
			final int poly = 0xEDB88320; // reverse polynomial

			for (final byte b : bytes) {
				
				int temp = (crc ^ b) & 0xff;

				// read 8 bits one at a time
				for (int i = 0; i < 8; i++) {
					if ((temp & 1) == 1) {
						temp = temp >>> 1 ^ poly;
					} else {
						temp = temp >>> 1;
					}
				}
				crc = crc >>> 8 ^ temp;
			}

			crc = ~crc;

			value = Integer.toHexString(crc).trim();

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (in != null) {
				try {
					in.close();
				} catch(Exception e1){}
			}
		}
		return value;
	}
}
