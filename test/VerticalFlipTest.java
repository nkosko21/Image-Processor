package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import commands.ImageCommand;
import model.ImageProcessModel;
import model.ImageModel;
import commands.Load;
import commands.Save;
import commands.VerticalFlip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the vertical flip command.
 */
public class VerticalFlipTest {
  private ImageProcessModel model;
  private ImageCommand loadCommand;
  private ImageCommand saveCommand;
  private ImageCommand vFlipCommand;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    loadCommand = new Load("loaded",
            "output/Koala.ppm");
    saveCommand = new Save("loaded",
            "output/vFlipped.ppm");
    vFlipCommand = new VerticalFlip("loaded");
  }

  @Test
  public void testImagesInside() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", vFlipCommand);
    model.apply("loaded", saveCommand);
  }
}
