package cn.jimmy.network.threadpool.eg1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class OrtedService {
  private ServerSocket server;
  private ExecutorService executor = Executors.newCachedThreadPool();
  
  private long total = 0;
  
  public OrtedService() {
     try {
      this.server = new ServerSocket(Constants.Port);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void startServer() {
    while(true) {
      Socket clientSocket = null;
      try {
        clientSocket = server.accept();
      } catch (IOException e) {
        e.printStackTrace();
      }
//      this.executor.submit(new MyRunnable(clientSocket));
//      this.executor.submit(new MyRunnable());
      
      Thread t = new Thread(new MyRunnable(clientSocket));
      t.start();
    }
    
  }
  
  
  class MyRunnable implements Runnable {
    public Socket clientSocket;
    
    public MyRunnable(Socket clientSocket) {
      this.clientSocket = clientSocket;
    }

    public void run() {
      try {
//        Socket clientSocket = server.accept();
        DataInputStream is = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
        
        while (true) {
          long value = is.readLong();
          Thread.sleep(1000);
//          synchronized(this) {
//            System.out.println("total = " + (total++));
//          }
          os.writeLong(value+1);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    OrtedService ortedService = new OrtedService();
    ortedService.startServer();
  }

  
  
  
}
