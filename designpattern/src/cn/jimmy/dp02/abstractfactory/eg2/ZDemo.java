package cn.jimmy.dp02.abstractfactory.eg2;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ZDemo {
 
  public static void main(String[] args) {
    GUIFactory swingFactory = new SwingFactory();
    Frame f = swingFactory.getFrame();
    Component b = swingFactory.getButton();
    Component t = swingFactory.getTextField();
    
    f.setSize(500, 300);
    f.setLayout(new FlowLayout());
    f.add(b);
    f.add(t);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}