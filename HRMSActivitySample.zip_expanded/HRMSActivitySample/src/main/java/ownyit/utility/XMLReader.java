package ownyit.utility;

import java.io.File;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	private String strFileName = null;

	private Hashtable<String, String> table = null;

	public XMLReader(String file_name) {
		
		this.strFileName = file_name;
		
		this.table = new Hashtable<String, String>();
	}
	
	/**
	 * Load XML File
	 */
	public int load(){
		
		int value = 0;
		
		DocumentBuilderFactory dbf = null;
		
		DocumentBuilder db = null;
		
		try {
			dbf = DocumentBuilderFactory.newInstance();
			
			dbf.setIgnoringElementContentWhitespace(true);

			db = dbf.newDocumentBuilder();

			File file = new File(this.strFileName);

			if(file.exists()){
			
				Document doc = db.parse(file);
				
				parse(doc);
				
				doc = null;
				
				value = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			value = -1;
		}
		db = null;
		dbf = null;
		
		return value;
	}
	
	private void parse(Document doc){
	
		if(doc == null){
			return;
		}
		
		/**
		 * Get Root Element Node
		 */
		Node root = doc.getDocumentElement();
		
		if(root != null){
			
			/**
			 * Parser Root Node/Get all child Nodes
			 */
			parseNode(root);
			
			root = null;
		}
	}
	
	private void parseNode(Node node){
		
		if(node == null){
			return;
		}
		
		/**
		 * Get Node/Tag Name
		 */
		String name = node.getNodeName();
		
		/**
		 * Get Node/Tag Value
		 */
		String value =  getNodeValue(node);
		
		if(value != null){
			this.table.put(name, value);
			
			value = null;
		}
		name = null;
		
		/**
		 * Handle Child Elements
		 */
		parseChildrenNodes(node);
	}
	
	private void parseChildrenNodes(Node node){
		
		if(node == null){
			return;
		}
		
		NodeList child_list = node.getChildNodes();
		
		int total_child_nodes = (child_list != null)? child_list.getLength() : 0;
		
		if(total_child_nodes > 0){
		
			for(int i = 0; i < total_child_nodes; i++){
				
				Node child = child_list.item(i);
				
				parseChildNode(child);
				
				child = null;
			}
		}
		child_list = null;
	}

	private void parseChildNode(Node child){
		
		if(child == null){
			return;
		}
		
		if(child.getNodeType() == Node.ELEMENT_NODE){
			/**
			 * Parse Child Node
			 */
			parseNode(child);
		}
	}

	private String getNodeValue(Node node){
		
		if(node == null){
			return null;
		}
		
		String value = null;
		
		if(node.hasChildNodes()){
			
			for(Node child = node.getFirstChild(); child != null; child.getNextSibling()){
				
				if (child.getNodeType() == Node.TEXT_NODE) {
					value = child.getNodeValue();
					break;
				}
			}
		}
		return value;
	}
	
	public String getValue(String key){		
		return getValue(key, null);
	}

	public String getValue(String key, String default_value){
		
		if(key == null || this.table.isEmpty()){
			return default_value;
		}
		
		String value = this.table.get(key);
		
		if(value == null){
			value = default_value;
		}
		return value;
	}
	
	public void clear(){
		
		if(this.table != null){
			this.table.clear();
			this.table = null;
		}
	}
	
	
//	private String getElementValue(Node node) {
//
//		String strValue = null;
//
//		if (node != null && node.hasChildNodes()) {
//
//			for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
//
//				if (child.getNodeType() == Node.TEXT_NODE) {
//					strValue = child.getNodeValue();
//					break;
//				}
//			}
//		}
//
//		if (strValue != null && strValue.length() > 0) {
//			if (strValue.charAt(0) == '\r' || strValue.charAt(0) == '\n') {
//				strValue = null;
//			}
//
//		} else {
//			strValue = "";
//		}
//		return strValue;
//	}

}
