package cn.jimmy.dp04.builder.eg2;

public class PersonDirector {
  public Person constructPerson(PersonBuilder pb) {
    pb.buildHead();
    pb.buildBody();
    pb.buildFoot();
    return pb.buildPerson();
  }

}
