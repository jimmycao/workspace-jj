package cn.jimmy.dp04.builder.eg2;

public class ZDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    PersonDirector pd = new PersonDirector();
    Person man = pd.constructPerson(new ManBuilder());
    
    System.out.println(man.getHead());
    System.out.println(man.getBody());
    System.out.println(man.getFoot());
    
    Person woman = pd.constructPerson(new WomanBuilder());
    System.out.println(woman.getHead());
    System.out.println(woman.getBody());
    System.out.println(woman.getFoot());

  }

}
