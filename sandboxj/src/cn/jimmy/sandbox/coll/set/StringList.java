package cn.jimmy.sandbox.coll.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringList {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("xian");
		strList.add("beijing");
		strList.add("wuhan");
		strList.add("shanghai");
		
		Iterator<String> it = strList.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		for (String str : strList)
			System.out.println(str);
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
	}
}