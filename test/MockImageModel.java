package test;

import java.awt.Color;
import java.awt.image.BufferedImage;

import commands.ImageCommand;
import model.ImageProcessModel;

/**
 * The Mock class for ImageModel to test if the inputs are properly sent to the reader.
 */
public class MockImageModel implements ImageProcessModel {
  private final StringBuilder log;

  /**
   * Public constructor for this mock class.
   * @param log StringBuilder to log user inputs
   */
  public MockImageModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void apply(String name, ImageCommand command) {
    if (name.length() <= 1) {
      throw new IllegalArgumentException("No such file found.");
    }
    log.append(String.format("name: %s, command: %s", name, command.commandType()));
  }

  @Override
  public void addImage(String name, Color[][] image) {
    log.append(String.format("name: %s", name));
  }

  @Override
  public void addExtension(String name, String extension) {
    log.append(String.format("name: %s, extension: %s", name, extension));
  }

  @Override
  public boolean checkEmpty() {
    return false;
  }

  @Override
  public StringBuilder convertNameToStringBuilder(String name) {
    return null;
  }

  @Override
  public Color[][] arrayOfName(String name) {
    return null;
  }

  @Override
  public String extensionOfName(String name) {
    return null;
  }

  @Override
  public BufferedImage imageContents() {
    return null;
  }
}
