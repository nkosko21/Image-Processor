package test;

import commands.ImageCommand;
import controller.Features;

/**
 * Represents the Mock class for the ImageController class to test if the inputs are
 * being properly parsed.
 */
public class MockFeatures implements Features {
  private final StringBuilder log;

  /**
   * Public constructor for MockController.
   * @param log StringBuilder which logs user inputs
   */
  public MockFeatures(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void completeCommand(ImageCommand command) {
    this.log.append(command.commandType() + System.lineSeparator());
  }
}
