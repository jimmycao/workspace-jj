package cn.jimmy.dp20.observer.eg0;

import java.util.ArrayList;
import java.util.List;

public class Subject {
  private List<Observer> observers = new ArrayList<Observer>();
  private int state;
  
  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }
  
  public int getState() {
    return this.state;
  }
  
  private void notifyAllObservers() {
    for (Observer observer : observers) {
        observer.update();
    }
  }
  
  public void attach(Observer ob) {
    this.observers.add(ob);
  }

}
