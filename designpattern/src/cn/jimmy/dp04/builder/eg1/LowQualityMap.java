package cn.jimmy.dp04.builder.eg1;

public class LowQualityMap {
  private MapBuilder builder;
  
  public LowQualityMap(MapBuilder builder) {
    this.builder = builder;
  }
  
  public void createMap() {
    System.out.println("this is a low quality map");
    this.builder.createWeather();
    this.builder.createHouse();
    this.builder.createRoad();
    this.builder.createTree();
  }
  

}
