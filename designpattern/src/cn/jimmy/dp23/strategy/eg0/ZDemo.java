package cn.jimmy.dp23.strategy.eg0;

public class ZDemo {

  public static void main(String[] args) {
    int num1 = 5;
    int num2 = 10;
    
    Context ctx = new Context(new Add());
    System.out.println(num1 + " + " + num2 + " = "+ ctx.exeStrategy(num1, num2));
    
    ctx = new Context(new Substract());
    System.out.println(num1 + " - " + num2 + " = "+ ctx.exeStrategy(num1, num2));
    
    ctx = new Context(new Multiply());
    System.out.println(num1 + " * " + num2 + " = "+ ctx.exeStrategy(num1, num2));
  }

}
