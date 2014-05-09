package cn.jimmy.exception.eg0;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumber {
  private static final int SIZE = 10;
  private List<Integer> intList = new ArrayList<Integer>();

  private String fileName;

  public ListOfNumber(String fileName) {
    this.fileName = fileName;

    for (int i = 0; i < SIZE; i++) {
      intList.add(i);
    }
  }

  public void writeList1() {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new FileWriter(fileName));
      for (int i = 0; i < SIZE; i++) {
        writer.println("Value at " + i + " = " + intList.get(i));
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Caught ArrayIndexOutOfBoundsException: "
          + e.getMessage());
    } catch (FileNotFoundException e) {
      /*
       * FileNotFoundException extends IOException
       */
      System.err.println("Caught FileNotFoundException: " + e.getMessage());
      throw new RuntimeException(e);
    } catch (IOException e) {
      /*
       * here, is Checked Exception IOException extends Exception Exception
       * extends Throwable
       */
      e.printStackTrace();
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }
  
  public void writeList3() throws IOException, ArrayIndexOutOfBoundsException {
    PrintWriter writer = new PrintWriter(new FileWriter(fileName));
    for (int i = 0; i < SIZE; i++) {
      writer.println("Value at " + i + " = " + intList.get(i));
    }
    writer.close();
  }

  public void writeList2() {
    PrintWriter writer = null;
    /*
     * this will result in a NullPointerException
     * 
     * NullPointerException extends RuntimeException
     * 
     * Runtime exceptions are not subject to the Catch or Specify Requirement.
     */
    writer.close();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    String fileName = "list-of-number.txt";
    ListOfNumber listOfNumber = new ListOfNumber(fileName);
//    listOfNumber.writeList1();

    // listOfNumber.writeList2();
    
    try {
      listOfNumber.writeList3();
    } catch (ArrayIndexOutOfBoundsException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
