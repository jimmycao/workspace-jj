package cn.jimmy.dp02.abstractfactory.eg2;

import java.awt.Component;
import java.awt.Frame;

public abstract class GUIFactory {
  public abstract Component getButton();
  public abstract Component getTextField();
  public abstract Frame getFrame();
}