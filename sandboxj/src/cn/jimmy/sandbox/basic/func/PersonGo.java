package cn.jimmy.sandbox.basic.func;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonGo {
	
	public void changePerson(Person p) {
		p.setName("Jack_changed");
	}
	
	public Person getAPerson() {
		Person p = new Person("David", 30);
		return p;
	}
	
	public List<String> getNameList() {
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		return list;
	}
	
	public static void main(String[] args) {
		PersonGo go = new PersonGo();
		Person p = new Person("Jack", 1);
		go.changePerson(p);
		System.out.println(p.getName());
		
		//+++++++++++++++++++++++++++++
		Person p2 = go.getAPerson();
		System.out.println(p2.getName());
		
	//+++++++++++++++++++++++++++++
		List list = go.getNameList();
		list.remove(1);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
	//+++++++++++++++++++++++++++++
		System.out.println("=======================");
		Person me = new Person("Jimmy", 30);
		Person me_ref = me;
		me.setName("amao");
		System.out.println(me.getName() + ":" + me.getAge());
	}

}
