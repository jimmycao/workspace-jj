package cn.jimmy.dp21.state.eg0;

public class StopState implements State {

  @Override
  public void doAction(Context ctx) {
    System.out.println("set: stop state");
    ctx.setState(this);
  }

  public String toString() {
    return "Stop State";
  }
}
