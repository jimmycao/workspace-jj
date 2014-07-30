package cn.jimmy.sandbox.generic.simple;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class TimeCalender {
	
	//1. private class
	//2. generic class, <....> follows class name, but precedes {
	private class Pair<T extends Comparable>{
		private T min;
		private T max;
		
		public Pair(T min, T max){
			this.min = min;
			this.max = max;
		}
		
		public T getMin(){
			return this.min;
		}
		
		public T getMax(){
			return this.max;
		}
	}
	//3. generic function, Firstly, announce the <T extends Comparable>
	public <T extends Comparable> Pair<T> getMinMaxPair(List<T> list){
		T min = list.get(0);
		T max = list.get(0);
		for(int i = 1; i < list.size(); i++){
			T unkown = list.get(i);
			if(unkown.compareTo(max) > 0) max = unkown;
			if(unkown.compareTo(min) < 0) min = unkown;
		}
		return new Pair<T>(min, max);
	}
	
	public static void main(String[] args) {
		//4. get current time in MilliSeconds
		long time = System.currentTimeMillis();
		//5. public abstract class Calendar extends Object implements Serializable, Cloneable, Comparable<Calendar>
		//6. public class GregorianCalendar extends Calendar
		//7. both LinkedList and ArrayList are ok, their parent interface is List 
		List<GregorianCalendar> birthdayList = new LinkedList<GregorianCalendar>(); 
		birthdayList.add(new GregorianCalendar(1981, Calendar.APRIL, 4));
		birthdayList.add(new GregorianCalendar(1980, Calendar.NOVEMBER, 18));
		birthdayList.add(new GregorianCalendar(1953, Calendar.MAY, 4));
		birthdayList.add(new GregorianCalendar(1954, Calendar.OCTOBER, 1));
		
		TimeCalender timeCalender = new TimeCalender();
		Pair<GregorianCalendar> minMaxPair = timeCalender.getMinMaxPair(birthdayList);
		//8. getTime is function member in Calendar
		System.out.println(minMaxPair.getMin().getTime() + ":" + minMaxPair.getMax().getTime() );
		
		System.out.println(System.currentTimeMillis() - time);
	}
}
