package cn.jimmy.sandbox.coll.impl;

import java.util.Map.Entry;

public class EntryImpl {
  
  Entry<String, String> getEntry() {
    return new Entry<String, String>() {
      String key = "key";
      String value = "value";
      
      @Override
      public String getKey() {
        return key;
      }

      @Override
      public String getValue() {
        return value;
      }

      @Override
      public String setValue(String value) {
        this.value = value;
        return value;
      }
    };
  }

  public static void main(String[] args) {
    EntryImpl t = new EntryImpl();
    Entry<String, String> e = t.getEntry();
    System.out.println(e.getKey());
    System.out.println(e.getValue());
  }
}
