package cn.jimmy.sandbox.coll.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CountDuplicateList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("aaa");
		list.add("bbb");
		
		//1. Collections.frequency
		Set<String> strSet = new HashSet<String>(list);  //list to set, remove duplicated 
		System.out.println("strSet.size() : "+strSet.size());
		for (String str : strSet) {
			System.out.println(str + ":" + Collections.frequency(list, str));
		}
		
		System.out.println("--------------------");
		
		//2. HashMap Note: here 'Integer count, count == null' !!!!
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : list) {
			Integer count = map.get(str);
			map.put(str, count == null ? 1 : count+1);
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet)
			System.out.println(entry.getKey() + ":" + entry.getValue());
		
		System.out.println("--------------------");
		
		//3. TreeMap
		Map<String, Integer> map2 = new TreeMap<String, Integer>(map);
		Set<Entry<String, Integer>> s = map2.entrySet();
	 	for (Entry<String, Integer> entry : s)
	 		System.out.println(entry.getKey() + ":" + entry.getValue());
	 	
	 	//to sort a list
	 	System.out.println("--------------------");
	 	Collections.sort(list);
	 	for (String str : list)
	 		System.out.println(str);
	}
}
