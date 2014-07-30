package cn.jimmy.sandbox.coll.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> strArrayList = new ArrayList<String>();
		strArrayList.add("xian");
		strArrayList.add("beijing");
		strArrayList.add("wuhan");
		
		for(String str : strArrayList)
			System.out.println(str);
		System.out.println("=================");
		
		Iterator<String> itr = strArrayList.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("=================");
		
		for(int i = 0; i < strArrayList.size(); i++)
			System.out.println(strArrayList.get(i));
		System.out.println("=================");

		Object[]  strArray =  strArrayList.toArray();
		for(Object str : strArray)
			System.out.println((String)str);
		System.out.println("=================");
		
		System.out.println(strArrayList.contains("xian"));
		strArrayList.remove("wuhan");
		System.out.println(strArrayList);
		strArrayList.remove(1);
		System.out.println(strArrayList);
	}
}
