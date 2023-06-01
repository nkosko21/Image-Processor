package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import commands.ImageCommand;
import model.ImageModel;
import model.ImageProcessModel;
import commands.Load;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the load command.
 */
public class LoadTestPNG {
  private ImageProcessModel model;
  private ImageCommand loadCommand;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    loadCommand = new Load("frog",
            "resPNG/flower.png");
  }

  @Test
  public void testImagesInside() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("a", loadCommand);
    assertFalse(model.checkEmpty());
  }
}
