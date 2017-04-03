package com.fujitsu.excel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindApplication {
	
	public static Map<String, Map<Integer, String>> checkExists(Map<Integer, String> appMap, List<Integer> list) {
		
		Map<String,Map<Integer,String>> waveMap = new HashMap<String,Map<Integer,String>>();
		Map<Integer,String> wave1Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave2Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave3Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave4Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave5Map = new TreeMap<Integer,String>();
		Map<Integer,String> ewaveMap = new TreeMap<Integer,String>();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			
			Integer i = it.next();	
			if (appMap.containsKey(i)) {
				
				String[] value = appMap.get(i).split("-");				
				if (value[0].equals("1.0"))
					wave1Map.put(i, value[1]);
				else if (value[0].equals("2.0"))
					wave2Map.put(i, value[1]);
				else if (value[0].equals("3.0"))
					wave3Map.put(i, value[1]);
				else if (value[0].equals("4.0"))
					wave4Map.put(i, value[1]);
				else if (value[0].equals("5.0"))
					wave5Map.put(i, value[1]);
			}
			else
				ewaveMap.put(i, "");				
		}
		waveMap.put("wave1", wave1Map);
		waveMap.put("wave2", wave2Map);
		waveMap.put("wave3", wave3Map);
		waveMap.put("wave4", wave4Map);
		waveMap.put("wave5", wave5Map);
		waveMap.put("wave", ewaveMap);
		
		return waveMap;
	}
}
