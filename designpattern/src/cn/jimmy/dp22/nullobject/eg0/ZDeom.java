package cn.jimmy.dp22.nullobject.eg0;

public class ZDeom {
  public static void main(String[] args) {  
    AbstractCustomer customer1 = CustomerFactory.getCustomer("Ted");
    System.out.println("isNill=" + customer1.isNill() + ", name=" + customer1.getName());
    
    AbstractCustomer customer2 = CustomerFactory.getCustomer("Ted2");
    System.out.println("isNill=" + customer2.isNill() + ", name=" + customer2.getName());
  }
}
