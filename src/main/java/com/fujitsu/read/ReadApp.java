package com.fujitsu.read;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReadApp {

	public static List<Integer> read(){
		
		List<Integer> list = new LinkedList<Integer>();
		BufferedReader br =null;
		FileReader fr = null;
		try {
			fr = new FileReader("C:"+File.separator+"application.txt");
			br = new BufferedReader(fr);
			String line = br.readLine();
			String fLine = line;
			String[] appName = null;
			while (line != null) {				
				
				if (line.trim().length() > 0 && line.trim().endsWith(".xlsx")) {					
					String[] values = line.split("__");
					appName = line.split(".xlsx");
					list.add(Integer.parseInt(values[1]));
				} else if (line.trim().length() > 0 && (line.contains("No presence"))) {
					String[] time = line.split("No presence");
					if((fLine.trim().equalsIgnoreCase(appName[0].trim()+"-"+time[0].trim()) || (fLine.trim().equalsIgnoreCase(appName[0].trim()+"New"+"-"+time[0].trim())))) {
						list.remove(list.size()-1);
						break;
					}
				}
				line = br.readLine();
			}
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null)
					br.close();
				//if (fr != null)
					//fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;		
	}
	
	public static void writeRecords(Map<String, Map<Integer, String>> map) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("C:"+File.separator+"output.txt");
			bw = new BufferedWriter(fw);
			if(map.isEmpty())
				bw.write("No Application Found for Wave !...");
			else{
				
				for (Entry<String, Map<Integer, String>> entry : map.entrySet()) {
				    
				    bw.write("\n\n#####\t"+entry.getKey()+" Application List\t#####\n");
				    
				    for (Map.Entry<Integer, String> nameEntry : entry.getValue().entrySet()) {
				    	Integer key = nameEntry.getKey();
				        String value = nameEntry.getValue();
				        writeToFile(bw,key,value); 
				    }
				}				
				
			
				/*bw.write("****\tWave1 Application List\t****\n\n");
				if (map.containsKey("wave1")) {

					 Map<Integer, String> wave1Map = map.get("wave1");
					 for (Entry<Integer, String> pair : wave1Map.entrySet()) {
							bw.write("\n");
							bw.write(pair.getKey() +" "+ pair.getValue());
					}
				}
				bw.write("\n\n\n****\tWave2 Application List\t****\n\n");
				if (map.containsKey("wave2")) {

					 Map<Integer, String> wave2Map = map.get("wave2");
					 for (Entry<Integer, String> pair : wave2Map.entrySet()) {
							bw.write("\n");
							bw.write(pair.getKey() +" "+ pair.getValue());
					}
				}
				bw.write("\n\n\n****\tWave3 Application List\t****\n\n");
				if (map.containsKey("wave3")) {

					 Map<Integer, String> wave3Map = map.get("wave3");
					 for (Entry<Integer, String> pair : wave3Map.entrySet()) {
							bw.write("\n");
							bw.write(pair.getKey() +" "+ pair.getValue());
					}
				}*/
			}				
			bw.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeToFile(BufferedWriter bw, Integer key, String value) throws IOException {
		
		bw.write("\n");
		bw.write(key.toString()+" "+value);
	}
}
