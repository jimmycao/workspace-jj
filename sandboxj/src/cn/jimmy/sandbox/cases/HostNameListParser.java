package cn.jimmy.sandbox.cases;


public class HostNameListParser {
  
  public static String parseRange(String hostNameRangeExpr) {
    StringBuilder sb = new StringBuilder();
    if (hostNameRangeExpr.contains("[") && hostNameRangeExpr.contains("]")) {
      String former = hostNameRangeExpr.substring(0, hostNameRangeExpr.indexOf('['));
      String latter = hostNameRangeExpr.substring(hostNameRangeExpr.indexOf(']')+1);
      String range = hostNameRangeExpr.substring(hostNameRangeExpr.indexOf('[')+1, hostNameRangeExpr.indexOf(']'));
      int min = Integer.parseInt(range.substring(0, range.indexOf('-')));
      int max = Integer.parseInt(range.substring(range.indexOf('-')+1));
      System.out.println("former :" + former);
      System.out.println("latter :" + latter);
      System.out.println("range :" + range);
      for (int i = min; i <= max; i++) {
        sb.append(former).append(i).append(latter);
        if (i != max) {
          sb.append(',');
        }
      }
      return sb.toString();
    } else {
      return hostNameRangeExpr;
    }
  }
  
  public static String parse(String expr) {
    String[] rangeArray = expr.split(",");
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < rangeArray.length; i++) {
      String range = rangeArray[i].trim();
      str.append(parseRange(range));
      if (i != (rangeArray.length -1 )) {
        str.append(',');
      }
    }
    return str.toString();
  }
  
  
  public static void main(String[] args) {
    String hostNameExpr = "node1, gphd-vm[1-20].pivotal.com, host[10-30]";
    System.out.println(HostNameListParser.parse(hostNameExpr));
  }

}
