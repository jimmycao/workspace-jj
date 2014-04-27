package cn.jimmy.dp18.mediator.eg0;

public class User {
  private String name;
  
  public User(String name) {
    this.name = name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void sendMSG(String msg) {
    ChatRoom.showMSG(this, msg);
  }
}
