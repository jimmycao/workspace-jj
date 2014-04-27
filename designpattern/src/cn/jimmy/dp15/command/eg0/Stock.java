package cn.jimmy.dp15.command.eg0;

public class Stock {
  private String name;
  private int quality;
  
  public Stock(String name, int quality) {
    this.name = name;
    this.quality = quality;
  }
  
  public void buy(int quality) {
    this.quality += quality;
    System.out.println("Stock name=" + name + ", bought quality=" + quality
        + ", after buy, total quality=" + this.quality);
  }
  
  public void sell(int quality) {
    this.quality -= quality;
    System.out.println("Stock name=" + name + ", sell quality=" + quality
        + ", after sell, total quality=" + this.quality);
  }
}
