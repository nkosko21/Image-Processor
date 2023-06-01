package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import commands.HorizontalFlip;
import commands.ImageCommand;
import model.ImageProcessModel;
import model.ImageModel;
import commands.Load;
import commands.Save;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the save command.
 */
public class HorizontalFlipTest {
  private ImageProcessModel model;
  private ImageCommand loadCommand;
  private ImageCommand saveCommand;
  private ImageCommand hFlipCommand;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    loadCommand = new Load("loaded",
            "output/Koala.ppm");
    saveCommand = new Save("loaded",
            "output/hFlipped.ppm");
    hFlipCommand = new HorizontalFlip("loaded");
  }

  @Test
  public void testImagesInside() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", hFlipCommand);
    model.apply("loaded", saveCommand);
  }
}
