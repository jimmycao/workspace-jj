package cn.jimmy.dp06.adapter.eg0;

public class MP4Player implements AdvancedMediaPlayer {

  @Override
  public void playVLC(String fileName) {
  }

  @Override
  public void playMP4(String fileName) {
    System.out.println("play MP4 fileName = " + fileName);
  }
}
