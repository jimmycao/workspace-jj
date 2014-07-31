package cn.jimmy.sandbox.coll.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListArray {
	
	public static void listToArray() {
		List<String> list = new ArrayList<String>();
		list.add("xian");
		list.add("shanghai");
		list.add("beijing");
		//1. list.toArray(
		String[] strArray = list.toArray(new String[0]); //list.toArray
		for (String str : strArray)
			System.out.println(str);
	}
	
	public static void arrayToList() {
		String[] strArray = new String[] {"hust", "tsinghua", "xjtu"};
		//2. Arrays.asList(
		List<String> list = Arrays.asList(strArray); //Arrays.asList
		Iterator<String> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
	
	
	public static void main(String[] args) {
		ListArray.listToArray();
		ListArray.arrayToList();
	}

}
