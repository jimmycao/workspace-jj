package cn.jimmy.dp13.proxy.eg0;

public class RealImage implements Image {
  private String fileName;
  
  private void loadImage(String fileName) {
    System.out.println("Loading " + fileName + "from disk");
  }
  
  public RealImage(String fileName) {
    this.fileName = fileName;
    loadImage(fileName);
  } 

  @Override
  public void display() {
    System.out.println("display the image: " + this.fileName);
  }

}
