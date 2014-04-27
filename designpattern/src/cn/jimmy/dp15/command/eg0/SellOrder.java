package cn.jimmy.dp15.command.eg0;

public class SellOrder implements Order {
  private Stock stock;
  private int quality;
  
  public SellOrder(Stock stock, int quality) {
    this.stock = stock;
    this.quality = quality;
  }

  @Override
  public void execute() {
    this.stock.sell(this.quality);
  }
}
