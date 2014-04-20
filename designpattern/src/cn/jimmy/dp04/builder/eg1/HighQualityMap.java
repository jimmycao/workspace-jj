package cn.jimmy.dp04.builder.eg1;

public class HighQualityMap {
  private MapBuilder builder;
  
  public HighQualityMap(MapBuilder builder) {
    this.builder = builder;
  }
  
  public void createMap() {
    System.out.println("this is a high quality map");
    this.builder.createWeather();
    this.builder.createHouse();
    this.builder.createRoad();
    this.builder.createTree();
  }

}
