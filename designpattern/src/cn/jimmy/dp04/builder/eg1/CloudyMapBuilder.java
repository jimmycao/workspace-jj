package cn.jimmy.dp04.builder.eg1;

public class CloudyMapBuilder implements MapBuilder {

  @Override
  public void createWeather() {
    System.out.println("No Sun, cloudy");
  }

  @Override
  public void createTree() {
    System.out.println("Tree with black and wet leaves");
  }

  @Override
  public void createHouse() {
    System.out.println("House with dark glasses");
  }

  @Override
  public void createRoad() {
    System.out.println("wet road");
    
  }

}
