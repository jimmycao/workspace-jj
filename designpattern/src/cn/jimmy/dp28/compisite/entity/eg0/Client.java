package cn.jimmy.dp28.compisite.entity.eg0;

public class Client {
  private CompositeEntity ce = new CompositeEntity();
  
  public void setData(int data1, int data2) {
    ce.setData(data1, data2);
  }
  
  public void printData() {
    for (int i=0; i<ce.getData().length; i++) {
      System.out.println(i + " : " + ce.getData()[i]);
    }
  }

}
