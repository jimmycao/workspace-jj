package cn.jimmy.dp19.memento.eg0;

public class Memento {
  private String state;
  
  public Memento(String state) {
    this.state = state;
  }
  
  public String getState() {
    return this.state;
  }
}
