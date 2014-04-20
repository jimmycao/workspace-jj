package cn.jimmy.dp04.builder.eg0;

public abstract class Burger implements Item {

  @Override
  public abstract String getName();

  @Override
  public Packing getPackingInstance() {
    return new Wrapper();
  }

  @Override
  public abstract float getPrice();

}
