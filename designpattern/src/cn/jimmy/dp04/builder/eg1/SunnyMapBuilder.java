package cn.jimmy.dp04.builder.eg1;

public class SunnyMapBuilder implements MapBuilder {

  @Override
  public void createWeather() {
    System.out.println("Sun is shining");
  }

  @Override
  public void createTree() {
    System.out.println("Tree with green and bright leaves");
  }

  @Override
  public void createHouse() {
    System.out.println("House with bright and shining glasses");
  }

  @Override
  public void createRoad() {
    System.out.println("Dry road");
    
  }

}
