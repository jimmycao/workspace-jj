package cn.jimmy.dp17.iterator.eg0;

public class ZDemo {
  public static void main(String[] args) {
    NameRepo nameRepo = new NameRepo();
    Iterator iter = nameRepo.getIterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}
