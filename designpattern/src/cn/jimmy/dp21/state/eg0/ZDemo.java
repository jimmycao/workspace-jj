package cn.jimmy.dp21.state.eg0;

public class ZDemo {
  public static void main(String[] args) {
    Context ctx = new Context();
    
    State startState = new StartState();
    startState.doAction(ctx);
    System.out.println(ctx.getState().toString());
    
    State stopState = new StopState();
    stopState.doAction(ctx);
    System.out.println(ctx.getState().toString());
  }
}
