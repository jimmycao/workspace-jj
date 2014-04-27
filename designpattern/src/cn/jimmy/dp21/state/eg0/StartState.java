package cn.jimmy.dp21.state.eg0;

public class StartState implements State {

  @Override
  public void doAction(Context ctx) {
    System.out.println("set : start state");
    ctx.setState(this);
  }

  public String toString() {
    return "start state";
  }
}
