package com.fujitsu.excel;

import java.util.List;
import java.util.Map;

public class FindingDuplicateRecordsApplication {

	public static void main(String[] args) {
		
		Map<Integer,String> appMap = new ReadWave2Application().readAllApplication();
		List<Integer> list = ReadApp.read();		
		Map<String, Map<Integer, String>> map = new FindApplication().checkExists(appMap,list);
		new ReadApp().writeRecords(map);
	}
}
 