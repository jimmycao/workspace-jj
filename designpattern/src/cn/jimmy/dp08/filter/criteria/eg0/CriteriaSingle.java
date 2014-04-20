package cn.jimmy.dp08.filter.criteria.eg0;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

  @Override
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> singles = new ArrayList<Person>();
    for (Person person : persons) {
      if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
        singles.add(person);
      }
    }
    return singles;
  }
}
