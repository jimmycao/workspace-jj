package cn.jimmy.dp22.nullobject.eg0;

public class CustomerFactory {
  public static final String[] customers = new String[] {"Bob", "Ted", "Rose"};
  
  public static AbstractCustomer getCustomer(String name) {
    for (String customerName : customers) {
      if (name.equalsIgnoreCase(customerName)) {
        return new RealCustomer(name);
      }
    }
    return new NullCustomer();
  }
}
