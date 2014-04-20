package cn.jimmy.dp02.abstractfactory.eg1;

public class WhiteAnimalFactory implements IAnimalFactory {

  @Override
  public ICat createCat() {
    return new WhiteCat();
  }

  @Override
  public IDog createDog() {
    // TODO Auto-generated method stub
    return new WhiteDog();
  }

}
