package cn.jimmy.dp16.interpreter.eg0;

public class OrExpression implements Expression {
  private Expression expr1;
  private Expression expr2;
  
  public OrExpression(Expression expr1, Expression expr2) {
    this.expr1 = expr1;
    this.expr2 = expr2;
  }

  @Override
  public boolean interpret(String ctx) {
    return this.expr1.interpret(ctx) || this.expr2.interpret(ctx);
  }

}
