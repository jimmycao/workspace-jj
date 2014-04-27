package cn.jimmy.dp16.interpreter.eg0;

public class SimpleExpression implements Expression {
  private String expr;
  
  public SimpleExpression(String expr) {
    this.expr = expr;
  }
  
  @Override
  public boolean interpret(String ctx) { 
    return expr.contains(ctx);
  }

}
