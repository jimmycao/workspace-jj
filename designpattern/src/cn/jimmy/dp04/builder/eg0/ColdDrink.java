package cn.jimmy.dp04.builder.eg0;

public abstract class ColdDrink implements Item {

  @Override
  public abstract String getName();
  
  @Override
  public Packing getPackingInstance() {
    return new Bottle();
  }

  @Override
  public abstract float getPrice();

}
