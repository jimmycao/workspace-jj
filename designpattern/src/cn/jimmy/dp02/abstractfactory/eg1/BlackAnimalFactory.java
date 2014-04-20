package cn.jimmy.dp02.abstractfactory.eg1;

public class BlackAnimalFactory implements IAnimalFactory {

  @Override
  public ICat createCat() {
    return new BlackCat();
  }

  @Override
  public IDog createDog() {
    return new BlackDog();
  }

}
