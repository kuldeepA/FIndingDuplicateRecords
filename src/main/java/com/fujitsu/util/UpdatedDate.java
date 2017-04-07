package com.fujitsu.util;
//package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class UpdatedDate {

	public static void read(){
		
	
	//List<Integer> list = new LinkedList<Integer>();
		Map<Integer,String> map = new TreeMap<Integer,String>();
	BufferedReader br =null;
	try {
		//System.out.println("1");
		br = new BufferedReader(new FileReader("C:"+File.separator+"RecordsCheckDate.txt"));
		String line = br.readLine();
		String fLine = line;
		//while ((line = br.readLine()) != null) {	
		String[] appName = null;
		String[] values =new String[500];
		String[] time = new String[500];
		while (line != null) {				
			
			if (line.trim().length() > 0 && (line.trim().endsWith(".xlsx") || (line.contains("No presence")))){
				
				//String[] values = line.split("__");
				if (line.trim().endsWith(".xlsx"))
					values = line.split("__");
				if (line.contains("No presence"))
					time = line.split("No presence");
				
				/*if (isNumeric(values[1]))// && !map.containsKey(Integer.parseInt(values[1])))
					map.put(Integer.parseInt(values[1]), time[0]);
				else if (isNumeric(values[1]))// && !map.containsKey(Integer.parseInt(values[1])))
						map.put(Integer.parseInt(values[2]), time[0]);
				*/
				
				 if (isNumeric(values[1]) && !map.containsKey(Integer.parseInt(values[1])))
					map.put(Integer.parseInt(values[1]), time[0]);
				else if (isNumeric(values[1]) && !map.containsKey(Integer.parseInt(values[1])))
						map.put(Integer.parseInt(values[2]), time[0]);
				 
			} /*else if (line.trim().length() > 0 && (line.contains("No presence"))) {
			
				String[] time = line.split("No presence");
				map.put(Integer.parseInt(values[1]), "");

			}*/
			
			line = br.readLine();
		}
		//System.out.println("2");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	//System.out.println("3");
	readList(map);	
	}
	
	public static void  readList(Map<Integer,String> map) {
		
		List<Integer> list = new LinkedList<Integer>();
		BufferedReader br =null;
		Map<Integer,String> map1 = new TreeMap<Integer,String>();
		try {
			br = new BufferedReader(new FileReader("C:"+File.separator+"ListOfApp.txt"));
			String line = br.readLine();
			//System.out.println("4");
			while (line != null) {
				list.add(Integer.parseInt(line));
				line = br.readLine();
			}
						
			//to check list
			Iterator<Integer> it =list.iterator();
			while (it.hasNext()) {
				Integer i = it.next();
				if (map.containsKey(i))
					map1.put(i, map.get(i));
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("5");
		for(Map.Entry<Integer, String> entry : map1.entrySet()){
			System.out.println(entry.getKey() + "-" +entry.getValue());
		}
	}
	
	public static void main(String[]s ) {
		
		new UpdatedDate().read();
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
