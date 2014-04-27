package cn.jimmy.dp18.mediator.eg0;

import java.util.Date;

public class ChatRoom {
  public static void showMSG(User user, String msg) {
    System.out.println((new Date()).toString() + ": " + user.getName() + " : " + msg);
  }
}
