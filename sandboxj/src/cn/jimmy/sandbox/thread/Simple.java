package cn.jimmy.sandbox.thread;

import java.io.IOException;
import java.io.RandomAccessFile;

class R implements Runnable {  
  RandomAccessFile out;  
  byte[] data;  
  
  R(RandomAccessFile out, byte[] data) {  
     this.out = out; this.data = data;  
  }  
  
  public void run() {  
       try {  
          for (int i = 0; i < 1000; ++i) {  
            synchronized (this.out) {
             out.write(data);  
            }
          }
       } catch (IOException e) { System.out.println(e); }
  }  
}  
  
class Simple {  
  public static void main(String[] args) throws IOException {  
     String fname = "test.data";  
     RandomAccessFile raf = new RandomAccessFile(fname, "rwd");  
  
     Runnable r1 = new R(raf, "ABCDEFGH".getBytes());  
     Runnable r2 = new R(raf, "abcdefgh".getBytes());  
  
     Thread t1 = new Thread(r1);  
     Thread t2 = new Thread(r2);  
  
     t1.start();  
     t2.start();  
  
  }  
}  