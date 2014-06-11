package cn.jimmy.network.simple1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OrtedService implements Runnable {
  private ServerSocket server;
  private long total = 0;
  
  public OrtedService() {
    try {
      this.server = new ServerSocket(Constants.Port);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  
  public void run() {
    try {
      Socket clientSocket = this.server.accept();
      DataInputStream is = new DataInputStream(clientSocket.getInputStream());
      DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
      
      while (true) {
        long value = is.readLong();
        Thread.sleep(10000);
        total++;
        os.writeLong(value+1);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void shutdown() throws IOException {
    this.server.close();
  }
  
  public long getTotal() {
    return this.total;
  }
}
