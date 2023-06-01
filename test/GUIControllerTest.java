package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import commands.Brighten;
import commands.ImageCommand;
import commands.Load;
import commands.Save;
import controller.Features;
import controller.GUIController;
import model.ImageModel;
import model.ImageProcessModel;
import view.ImageProcessGUIView;
import view.SwingFrame;

import static org.junit.Assert.assertEquals;

/**
 * Test the GUIController.
 */
public class GUIControllerTest {
  ImageProcessModel model;
  ImageProcessGUIView guiView;
  Features gui;
  ImageCommand load;
  ImageCommand brighten;
  ImageCommand save;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    guiView = new SwingFrame();
    gui = new GUIController(model, guiView);
    load = new Load("currentImage", "./res/zed.jpeg");
    brighten = new Brighten("currentImage", 10);
    save = new Save("currentIamge", "./res/savedZed.jpeg");
  }

  @Test
  public void testConstructorNullParameter() {
    try {
      gui = new GUIController(null, null);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
    try {
      gui = new GUIController(null, guiView);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
    try {
      gui = new GUIController(model, null);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
  }

  @Test
  public void testInput() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    mockModel.apply("currentImage", load);
    mockModel.apply("currentImage", brighten);
    mockModel.apply("currentImage", save);
    assertEquals(log.toString(), "load" + System.lineSeparator() +
            "brighten" + System.lineSeparator() + "save");
  }

  @Test
  public void testControllerInput() {
    StringBuilder log = new StringBuilder();
    Features mockGUI = new MockFeatures(log);
    mockGUI.completeCommand(load);
    assertEquals(log.toString(), "load" + System.lineSeparator());
    mockGUI.completeCommand(brighten);
    assertEquals(log.toString(), "brighten" + System.lineSeparator());
    mockGUI.completeCommand(save);
    assertEquals(log.toString(), "save" + System.lineSeparator());
  }

  @Test
  public void testParsing() {
    StringBuilder log = new StringBuilder();
    MockMain main = new MockMain(log);
    String[] strArray = {"-file", "./script.txt"};
    main.main(strArray);
    assertEquals(log.toString(), "-file" + System.lineSeparator() +
            "./script.txt" + System.lineSeparator());
  }

  @Test
  public void testParsing2() {
    StringBuilder log = new StringBuilder();
    MockMain main = new MockMain(log);
    String[] strArray = {"-txt"};
    main.main(strArray);
    assertEquals(log.toString(), "-txt" + System.lineSeparator());
  }

  @Test
  public void testParsing3() {
    StringBuilder log = new StringBuilder();
    MockMain main = new MockMain(log);
    String[] strArray = {""};
    main.main(strArray);
    assertEquals(log.toString(), "" + System.lineSeparator());
  }
}
