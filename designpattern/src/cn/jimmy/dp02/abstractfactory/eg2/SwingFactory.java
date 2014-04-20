package cn.jimmy.dp02.abstractfactory.eg2;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextField;

public class SwingFactory extends GUIFactory {

  @Override
  public Component getButton() {
    return new Button("Swing Button");
  }

  @Override
  public Component getTextField() {
    return new TextField("Swing TextField", 20);
  }

  @Override
  public Frame getFrame() {
    return new Frame("AWT Frame");
  }
}
