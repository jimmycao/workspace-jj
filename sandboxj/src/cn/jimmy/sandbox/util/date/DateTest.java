package cn.jimmy.sandbox.util.date;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		Date deadline;  //deadline is not a object yet
		deadline = (new GregorianCalendar()).getTime();
		System.out.println(deadline);
		System.out.println(deadline.toString());
	}
}
