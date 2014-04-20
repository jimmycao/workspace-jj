package cn.jimmy.dp02.abstractfactory.eg2;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextField;

public class AWTFactory extends GUIFactory {

  @Override
  public Component getButton() {
    return new Button("AWT Button");
  }

  @Override
  public Component getTextField() {
    return new TextField("AWT TextField", 20);
  }

  @Override
  public Frame getFrame() {
    return new Frame("AWT Frame");
  }

}
