package cn.jimmy.sandbox.oop.object;

import cn.jimmy.sandbox.oop.classs.basic.Employee;
import cn.jimmy.sandbox.oop.classs.basic.Manager;


public class GetClassInstanceOf {
	public static void main(String[] args) {
		Employee eManager = new Manager("amao", 12000, 2010, 3, 31, "CEO", 800);
		Employee e = new Employee("amao", 12000, 2010, 3, 31);
		System.out.println("eManager.equals(e):"+eManager.equals(e));
		System.out.println("eManager.getClass():"+eManager.getClass());
		System.out.println("e.getClass():"+e.getClass());
		if(eManager instanceof Employee) System.out.println("eManager instanceof Employee:" + true);
		if(eManager instanceof Manager) System.out.println("eManager instanceof Manager:" + true);
		if(e instanceof Employee) System.out.println("e instanceof Employee:" + true);
		if(e instanceof Manager) System.out.println("e instanceof Manager:" + true);
		else System.out.println("e instanceof Manager:" + false);
	}
}
