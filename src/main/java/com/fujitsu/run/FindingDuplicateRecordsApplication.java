package com.fujitsu.run;

import java.util.List;
import java.util.Map;

import com.fujitsu.read.FindApplication;
import com.fujitsu.read.ReadApp;
import com.fujitsu.read.ReadWave2Application;

public class FindingDuplicateRecordsApplication {

	public static void main(String[] args) {
		
		Map<Integer,String> appMap = new ReadWave2Application().readAllApplication();
		List<Integer> list = ReadApp.read();		
		Map<String, Map<Integer, String>> map = new FindApplication().checkExists(appMap,list);
		new ReadApp().writeRecords(map);
	}
}
 