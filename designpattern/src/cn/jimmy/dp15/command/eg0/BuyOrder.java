package cn.jimmy.dp15.command.eg0;

public class BuyOrder implements Order {
  private Stock stock;
  private int quality;
  
  public BuyOrder(Stock stock, int quality) {
    this.stock = stock;
    this.quality = quality;
  }

  @Override
  public void execute() {
    this.stock.buy(this.quality);
  }
}
