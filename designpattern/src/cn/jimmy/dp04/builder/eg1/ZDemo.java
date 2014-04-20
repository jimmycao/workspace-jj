package cn.jimmy.dp04.builder.eg1;

public class ZDemo {


  public static void main(String[] args) {
    MapBuilder cloudyMapBuilder = new CloudyMapBuilder();
    HighQualityMap hqMap = new HighQualityMap(cloudyMapBuilder);
    hqMap.createMap();
    
    
    System.out.println("-----------------------");
    
    MapBuilder sunnyMapBuilder = new SunnyMapBuilder();
    LowQualityMap lqMap = new LowQualityMap(sunnyMapBuilder);
    lqMap.createMap();
  }
}
