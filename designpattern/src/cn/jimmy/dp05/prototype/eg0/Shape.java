package cn.jimmy.dp05.prototype.eg0;

public abstract class Shape implements Cloneable {
  private String id;
  protected String type;
  
  abstract void draw();
  
  public String getType() {
    return type;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getId() {
    return id;
  }
  
  public Object clone() {
    Object object = null;
    try {
      object = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return object;
  }
}
