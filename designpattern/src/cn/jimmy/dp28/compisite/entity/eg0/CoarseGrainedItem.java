package cn.jimmy.dp28.compisite.entity.eg0;

public class CoarseGrainedItem {
  private DependentItem1 item1 = new DependentItem1();
  private DependentItem2 item2 = new DependentItem2();
  
  public void setData(int data1, int data2) {
    item1.setData(data1);
    item2.setData(data2);
  }
  
  public int[] getData() {
    return new int[] {item1.getData(), item2.getData()};
  }

}
