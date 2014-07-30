package cn.jimmy.sandbox.hadoop;

import java.io.File;

import org.apache.hadoop.yarn.api.ApplicationConstants.Environment;


public class EnvEG {
  public static void main(String[] args) {
    StringBuilder classPathEnv = new StringBuilder(Environment.CLASSPATH.$())
    .append(File.pathSeparatorChar).append("./*");
    
    
    System.out.println(classPathEnv.toString());
    System.out.println(Environment.JAVA_HOME.$());
    
    

  }

}
