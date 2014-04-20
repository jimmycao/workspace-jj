package cn.jimmy.dp04.builder.eg2;

public class WomanBuilder implements PersonBuilder {
  
  private Woman woman;
  
  public WomanBuilder() {
    this.woman = new Woman();
  }

  @Override
  public void buildHead() {
    this.woman.setHead("woman's head");
  }

  @Override
  public void buildBody() {
    this.woman.setBody("woman's body");
  }

  @Override
  public void buildFoot() {
    this.woman.setFoot("woman's foot");
  }
  

  @Override
  public Person buildPerson() {
    return this.woman;
  }

}
