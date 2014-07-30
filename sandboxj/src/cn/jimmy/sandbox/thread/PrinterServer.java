package cn.jimmy.sandbox.thread;

import java.awt.PrintJob;

class PrinterServer {  
  private Queue requests = new Queue();  
  
  public PrinterServer() {  
     Runnable service = new Runnable() {  
        public void run() {  
           for ( ;; )   
              try {  
                 realPrint((PrintJob)requests.take());  
              } catch (InterruptedException e) {}  
        }  
     };  
     new Thread(service).start();  
  }  
  
  public void print(PrintJob job) {  
     requests.add(job);  
  }  
  
  private void realPrint(PrintJob job) {  
     // do the real work of printing  
     // or in our case, writing to a file  
  }  
}  
  
class Queue {  
  private Cell head, tail;  
  
  public synchronized void add(Object o) {  
     Cell p = new Cell(o);  
     if (tail == null)  
        head = p;  
     else  
        tail.next = p;  
     p.next = null;  
     notifyAll();  
  }  
  
  public synchronized Object take() throws InterruptedException {  
     while (head == null)  
        wait();  
  
     Cell p = head;  
     head = head.next;  
     if (head == null)  
        tail = null;  
     return p.item;  
  }  
}  
  
class Cell {  
  Cell next;  
  Object item;  
  Cell(Object o) { item = o; }  
}  
