package test;

import java.util.Scanner;

import controller.ImageProcessController;
import model.ImageProcessModel;

/**
 * Represents the Mock class for the ImageController class to test if the inputs are
 * being properly parsed.
 */
public class MockController implements ImageProcessController {
  private final StringBuilder log;
  private final StringBuilder userInput;
  private final ImageProcessModel model;

  /**
   * Public constructor for MockController.
   * @param log StringBuilder which logs user inputs
   * @param userInput StringBuilder which reads user inputs
   */
  public MockController(StringBuilder log, StringBuilder userInput, ImageProcessModel model) {
    this.log = log;
    this.userInput = userInput;
    this.model = model;
  }

  @Override
  public void runProgram(ImageProcessModel model) {
    Scanner sc = new Scanner(userInput.toString());
    while (sc.hasNext()) {
      log.append(sc.next() + System.lineSeparator());
    }
    this.model.checkEmpty();
  }
}
