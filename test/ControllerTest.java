package test;

import test.MockImageModel;
import test.MockController;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

import controller.ImageController;
import controller.ImageProcessController;
import commands.Brighten;
import commands.Component;
import commands.HorizontalFlip;
import commands.ImageCommand;
import model.ImageModel;
import model.ImageProcessModel;
import commands.Load;
import commands.Save;
import commands.VerticalFlip;
import view.ImageProcessView;
import view.ImageView;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for ImageController class.
 */
public class ControllerTest {
  ImageProcessModel model;

  ImageProcessView view;

  ImageProcessController controller;

  ImageCommand loadCommand;
  ImageCommand saveCommand;
  ImageCommand brightenCommand;
  ImageCommand component;
  ImageCommand verticalFlip;
  ImageCommand horizontalFlip;

  @Before
  public void init() {
    model = new ImageModel();
    view = new ImageView(System.out);
  }

  @Test
  public void testConstructorNullParameter() {
    try {
      controller = new ImageController(null, null, null, null);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
    try {
      controller = new ImageController(null, view, new InputStreamReader(System.in),
              System.out);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
    try {
      controller = new ImageController(model, null, new InputStreamReader(System.in),
              System.out);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
    try {
      controller = new ImageController(model, view, null, System.out);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
    try {
      controller = new ImageController(model, view, new InputStreamReader(System.in),
              null);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model, view, readable, or appendable cannot be null");
    }
  }

  // there need not be a string for a model, the name parameter in the imagecommand
  // will suffice

  @Test
  public void testLoadInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    assertEquals(log.toString(), "name: image1, command: load");
  }

  @Test
  public void testLoadInput2() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    try {
      mockModel.apply("a", loadCommand);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "No such file found.");
    }
  }

  @Test
  public void testSaveInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    saveCommand = new Save("image1", "folder/file2.ppm");
    mockModel.apply("image1", saveCommand);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: save");
  }

  @Test
  public void testBrightenInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    brightenCommand = new Brighten("image1", 30);
    mockModel.apply("image1", brightenCommand);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: brighten");
  }

  @Test
  public void testVFlipInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    verticalFlip = new VerticalFlip("image1");
    mockModel.apply("image1", verticalFlip);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: vertical-flip");
  }

  @Test
  public void testHFlipInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    horizontalFlip = new HorizontalFlip("image1");
    mockModel.apply("image1", horizontalFlip);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: horizontal-flip");
  }

  @Test
  public void testBlueComponent() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    component = new Component("image1", "image2", "blue");
    mockModel.apply("image1", component);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: blue-component");
  }

  @Test
  public void testGreenComponent() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    component = new Component("image1", "image2", "green");
    mockModel.apply("image1", component);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: green-component");
  }

  @Test
  public void testRedComponent() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    component = new Component("image1", "image2", "red");
    mockModel.apply("image1", component);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: red-component");
  }

  @Test
  public void testValueComponent() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    component = new Component("image1", "image2", "value");
    mockModel.apply("image1", component);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: value-component");
  }

  @Test
  public void testIntensityComponent() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    component = new Component("image1", "image2", "intensity");
    mockModel.apply("image1", component);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: intensity-component");
  }

  @Test
  public void testLumaComponent() throws IOException {
    StringBuilder log = new StringBuilder();
    ImageProcessModel mockModel = new MockImageModel(log);
    loadCommand = new Load("image1", "folder/file1.ppm");
    mockModel.apply("image1", loadCommand);
    component = new Component("image1", "image2", "luma");
    mockModel.apply("image1", component);
    assertEquals(log.toString(), "name: image1, command: load" +
            "name: image1, command: luma-component");
  }

  @Test
  public void testControllerInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm");
  }

  @Test
  public void testControllerInputs2() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("save image1 output/file2.ppm");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "save image1 output/file2.ppm");
  }

  @Test
  public void testControllerInputs3() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("brighten image1 30");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "brighten image1 30");
  }

  @Test
  public void testControllerInputs4() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("horizontal-flip image1");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "horizontal-flip image1");
  }

  @Test
  public void testControllerInputs5() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("vertical-flip image1");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "vertical-flip image1");
  }

  @Test
  public void testControllerInputs6() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 red");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 red");
  }

  @Test
  public void testControllerInputs7() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 green");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 green");
  }

  @Test
  public void testControllerInputs8() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 blue");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 blue");
  }

  @Test
  public void testControllerInputs9() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 value");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 value");
  }

  @Test
  public void testControllerInputs10() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 intensity");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 intensity");
  }

  @Test
  public void testControllerInputs11() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 luma");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 luma");
  }

  @Test
  public void testControllerInputs12() throws IOException {
    StringBuilder log = new StringBuilder();
    StringBuilder userInputs = new StringBuilder();
    userInputs.append("load image1 output/file1.ppm" + System.lineSeparator());
    userInputs.append("component image1 image2 luma");
    userInputs.append("component image2 image3 intensity");
    userInputs.append("component iamge3 image4 value");
    userInputs.append("save iamge4 output/final.ppm");
    ImageProcessController mockController = new MockController(log, userInputs, model);
    mockController.runProgram(model);
    assertEquals(log.toString(), userInputs.toString());
    assertEquals(log.toString(), "load image1 output/file1.ppm " +
            "component image1 image2 luma " +
            "component image2 image3 intensity " +
            "component image3 image4 value " +
            "save iamge4 output/final.ppm");
  }
}