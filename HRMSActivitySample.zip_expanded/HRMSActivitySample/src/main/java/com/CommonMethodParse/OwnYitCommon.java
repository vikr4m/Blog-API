package com.CommonMethodParse;

public class OwnYitCommon {

public boolean isValidColumn(String name){
		
		boolean bFlag = true;
		
		try {
			if(name == null){
				return false;
			}
			int len = name.length();
			
			for(int i = 0; i < len; i++){
				
				char ch = name.charAt(i);
				
				if(OwnyitConstants.VALID_COLUMN_NAMES.indexOf(ch) == -1){
					bFlag = false;
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			bFlag = false;
		}
		return bFlag;
	}
}
