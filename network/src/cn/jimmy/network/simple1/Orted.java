package cn.jimmy.network.simple1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Orted implements Runnable {
  public long start;
  private Socket socket;
  
  public Orted(long start) {
    this.start = start;
    System.out.println("============my start = "+ start);
    try {
      socket = new Socket(Constants.Server, Constants.Port);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void run() {

    try {
      DataInputStream is = new DataInputStream(this.socket.getInputStream());
      DataOutputStream os = new DataOutputStream(this.socket.getOutputStream());

      while (true) {
        os.writeLong(start);
        Thread.sleep(1000);
        long result = is.readLong();
        System.out.println("start=" + this.start + ", result=" + result);
        start++;
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
