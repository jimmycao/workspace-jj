package cn.jimmy.network.test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Test {

  /**
   * @param args
   * @throws UnknownHostException 
   */
  public static void main(String[] args) throws UnknownHostException {
    InetSocketAddress sockAddr = new InetSocketAddress("0.0.0.0", 0);
    System.out.println(sockAddr.getHostName());
    System.out.println(sockAddr.getHostString());
    System.out.println(sockAddr.getPort());
    System.out.println(sockAddr.getAddress().getHostAddress());
    
    
    System.out.println(InetAddress.getLocalHost().getHostAddress());
    System.out.println(InetAddress.getLocalHost().getHostName());
    
    System.out.println();

  }

}
