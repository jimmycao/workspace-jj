package cn.ggs.debug;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MyMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("beijing", "Tsinghua");
		map.put("xian", "XJTU");
		map.put("shanghai", "SJTU");
		map.put("wuhan", "HUST");

		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
 	}

}
