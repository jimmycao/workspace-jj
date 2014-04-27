package cn.jimmy.dp19.memento.eg0;

public class Originator {
  private String state;
  
  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }
  
  public Memento saveStateToMemento() {
    return new Memento(state);
  }
  
  public void getStateFromMemento(Memento memento) {
    state = memento.getState();
  }
}
