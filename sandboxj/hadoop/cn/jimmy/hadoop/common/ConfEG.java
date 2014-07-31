package cn.jimmy.hadoop.common;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

public class ConfEG {

  public static void main(String[] args) throws IOException {
    String confFile = "/Users/jcao/program/hadoop-2.2.0/etc/hadoop/yarn-site.xml";
    DataInputStream dis = new DataInputStream(new FileInputStream(confFile));
    
    Configuration conf = new Configuration();
    conf.readFields(dis);
    
    dis.close();
    
    System.out.println("yarn.scheduler.fair.assignmultiple:" + conf.get("yarn.scheduler.fair.assignmultiple"));
  }
}
