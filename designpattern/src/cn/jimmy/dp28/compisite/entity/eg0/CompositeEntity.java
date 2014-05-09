package cn.jimmy.dp28.compisite.entity.eg0;

public class CompositeEntity {
  private CoarseGrainedItem cgi = new CoarseGrainedItem();
  
  public void setData(int data1, int data2) {
    this.cgi.setData(data1, data2);
  }
  
  public int[] getData() {
    return this.cgi.getData();
  }

}
