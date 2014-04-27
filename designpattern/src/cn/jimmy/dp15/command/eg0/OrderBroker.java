package cn.jimmy.dp15.command.eg0;

import java.util.ArrayList;
import java.util.List;

public class OrderBroker {
  private List<Order> orders = new ArrayList<Order>();
  
  public void acceptOrder(Order order) {
    this.orders.add(order);
  }

  public void runOrders() {
    for (Order order : this.orders) {
      order.execute();
    }
    this.orders.clear();
  }
}
