package cn.jimmy.dp04.builder.eg2;

public class ManBuilder implements PersonBuilder {
  
  private Man man;
  
  public ManBuilder() {
    this.man = new Man();
  }

  @Override
  public void buildHead() {
    this.man.setHead("man's head");
  }

  @Override
  public void buildBody() {
    this.man.setBody("man's body");
  }

  @Override
  public void buildFoot() {
    this.man.setFoot("man's foot");
  }
  

  @Override
  public Person buildPerson() {
    return this.man;
  }

}
