package cn.jimmy.dp23.strategy.eg0;

public class Substract implements Strategy {

  @Override
  public int doOperation(int num1, int num2) {
    return num1 - num2;
  }

}
