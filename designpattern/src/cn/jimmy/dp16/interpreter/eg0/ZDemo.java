package cn.jimmy.dp16.interpreter.eg0;

public class ZDemo {
  public static Expression getMaleExpression() {
    Expression johnson =  new SimpleExpression("johnson");
    Expression standley = new SimpleExpression("standley");
    return new OrExpression(johnson, standley);
  }
  
  public static Expression getMarriedWomanExpression() {
    Expression married = new SimpleExpression("married woman");
    Expression woman = new SimpleExpression("divorced woman");
    return new AndExpression(married, woman);
  }
  
  public static void main(String[] args) {
    Expression isMale = getMaleExpression();
    Expression isMarriedWoman = getMarriedWomanExpression();
    
    System.out.println(isMale.interpret("johnson"));
    System.out.println(isMarriedWoman.interpret("woman"));
  }
}
