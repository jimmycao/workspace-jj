package cn.jimmy.network.threadpool.eg1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;




public class Orted implements Runnable {
  private long start;
  public Orted(long start) {
    this.start = start;
  }

  public void run() {
    try {
      Socket socket = new Socket(Constants.Server, Constants.Port);
      DataInputStream is = new DataInputStream(socket.getInputStream());
      DataOutputStream os = new DataOutputStream(socket.getOutputStream());
      
      os.writeLong(start);
      Thread.sleep(1000);
      long rt = is.readLong();
      
      System.out.println("start = " + start + ", rt = " + rt);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
