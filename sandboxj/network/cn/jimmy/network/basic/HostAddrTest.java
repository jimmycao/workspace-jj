package cn.jimmy.network.basic;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HostAddrTest {
  
  public void getIPHostname(String host) {
    try {
      //1. get ip from hostname
      InetAddress addr = InetAddress.getByName(host);
      System.out.println(addr.getHostAddress());
      
      //2. get local hostname
      System.out.println("host:" + InetAddress.getLocalHost().getHostName()); 
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
  
  public boolean isLocalHost(String host)  {
    InetAddress addr;
    try {
      addr = InetAddress.getByName(host);
      if (addr.isAnyLocalAddress() || addr.isLoopbackAddress()) {
        return true;
      }
    } catch (UnknownHostException e1) {
      return false;
    }
    
    try {
      return NetworkInterface.getByInetAddress(addr) != null;
    } catch (SocketException e) {
      return false;
    }
  }
  
  InetSocketAddress createSockAddr(String address) {
    String[] tokens = address.split(":");
    return new InetSocketAddress(tokens[0], Integer.parseInt(tokens[1]));
  }
  
  public static void main(String[] args) {
    HostAddrTest test = new HostAddrTest();
    String hostname = "jimmy.local";
    test.getIPHostname(hostname);
    System.out.println("isLocal:" + test.isLocalHost(hostname));
    
    InetSocketAddress sockAddr = test.createSockAddr("localhost:9000");
    System.out.println("hostname:" + sockAddr.getHostName() + ", hoststr:"
        + sockAddr.getHostString() + ", port:" + sockAddr.getPort());
  }
}
