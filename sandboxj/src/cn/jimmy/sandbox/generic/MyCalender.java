package cn.jimmy.sandbox.generic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class MyCalender {
  // 1. private class
  // 2. generic class, <....> follows class name, but precedes {
  private class Pair<T extends Comparable> {
     private T min;
     private T max;
     
     public Pair(T min, T max) {
       this.min = min;
       this.max = max;
     }
     
     public T getMin() {
       return this.min;
     }
     
     public T getMax() {
       return this.max;
     }
  }

  // 3. generic function, Firstly, announce the <T extends Comparable>
  public <T extends Comparable> Pair<T> getMinMaxPair(List<T> list) {
    T min = list.get(0);
    T max = list.get(0);
    
    for (int i = 0; i < list.size(); i++) {
      T unknown = list.get(i);
      if (unknown.compareTo(max) > 0) max = unknown;
      if (unknown.compareTo(min) < 0) min = unknown;
    }
    return new Pair<T>(min, max);
  }

  public static void main(String[] args) {
    // 4. get current time in MilliSeconds
    long start = System.currentTimeMillis();
    
    // 5. public abstract class Calendar extends Object implements Serializable,
    // Cloneable, Comparable<Calendar>
    // 6. public class GregorianCalendar extends Calendar
    // 7. both LinkedList and ArrayList are ok, their parent interface is List
    List<GregorianCalendar> birthdays = new LinkedList<GregorianCalendar>();
    birthdays.add(new GregorianCalendar(1981, Calendar.APRIL, 4));
    birthdays.add(new GregorianCalendar(1980, Calendar.NOVEMBER, 18));
    birthdays.add(new GregorianCalendar(1953, Calendar.MAY, 4));
    birthdays.add(new GregorianCalendar(1954, Calendar.OCTOBER, 1));
    
    MyCalender myCalender = new MyCalender();
    Pair<GregorianCalendar> minMaxPair = myCalender.getMinMaxPair(birthdays);
    
    // 8. getTime is function member in Calendar
    System.out.println(minMaxPair.getMin().getTime() + ":" + minMaxPair.getMax().getTime());
    
    System.out.println(System.currentTimeMillis() - start);
  }
}
