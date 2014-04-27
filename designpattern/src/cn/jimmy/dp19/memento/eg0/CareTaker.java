package cn.jimmy.dp19.memento.eg0;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
  private List<Memento> menentos = new ArrayList<Memento>();
  
  public void add(Memento m) {
    this.menentos.add(m);
  }

  public Memento getIndex(int index) {
    return this.menentos.get(index);
  }
}
