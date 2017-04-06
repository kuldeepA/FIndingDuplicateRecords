package com.fujitsu.core;

public class ReadUtils {

	public static boolean isNumeric(String str) {  
	  try {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe) {  
	    return false;  
	  }  
	  return true;  
	}
}
