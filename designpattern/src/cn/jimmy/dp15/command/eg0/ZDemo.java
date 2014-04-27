package cn.jimmy.dp15.command.eg0;

public class ZDemo {
  
  public static void main(String[] args) {
    Stock baiduStock = new Stock("Baidu", 0);
    
    BuyOrder buyOrder1 = new BuyOrder(baiduStock, 100);
    BuyOrder buyOrder2 = new BuyOrder(baiduStock, 80);
    SellOrder sellOrder = new SellOrder(baiduStock,90);
    
    OrderBroker broker = new OrderBroker();
    broker.acceptOrder(buyOrder1);
    broker.acceptOrder(buyOrder2);
    broker.acceptOrder(sellOrder);
    
    broker.runOrders();
  }
}
