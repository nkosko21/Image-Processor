package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import commands.Brighten;
import commands.ImageCommand;
import model.ImageModel;
import model.ImageProcessModel;
import commands.Load;
import commands.Save;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the save command.
 */
public class BrightenTest {
  private ImageProcessModel model;
  private ImageCommand loadCommand_Gray_95;
  private ImageCommand loadCommand_Gray_75;
  private ImageCommand loadCommand_Gray;
  private ImageCommand loadCommand_Black;
  private ImageCommand loadCommand_White;
  private ImageCommand loadCommand_Black2;
  private ImageCommand loadCommand_White2;
  private ImageCommand loadCommand;
  private ImageCommand saveCommand;
  private ImageCommand brightenCommand;
  private ImageCommand brightenCommand_10;
  private ImageCommand darkenCommand_10;
  private ImageCommand brightenWhiteCommand_10;
  private ImageCommand darkenBlackCommand_10;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    loadCommand = new Load("loaded",
            "output/Koala.ppm");
    loadCommand_Gray_95 = new Load("loadedGray95",
            "output/Gray_95.ppm");
    loadCommand_Gray_75 = new Load("loadedGray75",
            "output/Gray_75.ppm");
    loadCommand_Gray = new Load("loadedGray",
            "output/Gray.ppm");
    loadCommand_Black = new Load("loadedBlack",
            "output/Black.ppm");
    loadCommand_White = new Load("loadedWhite",
            "output/White.ppm");
    loadCommand_Black2 = new Load("loadedBlack2",
            "output/Black.ppm");
    loadCommand_White2 = new Load("loadedWhite2",
            "output/White.ppm");
    saveCommand = new Save("loaded",
            "output/whiteKoala.ppm");
    brightenCommand = new Brighten("loaded", +50);
    brightenCommand_10 = new Brighten("loadedGray", +10);
    darkenCommand_10 = new Brighten("loadedGray", -10);
    brightenWhiteCommand_10 = new Brighten("loadedWhite", +10);
    darkenBlackCommand_10 = new Brighten("loadedblack", -10);
  }

  @Test
  public void testImagesInside() throws IOException {

    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", brightenCommand);
    model.apply("loaded", saveCommand);

    model.apply("loadedGray95", loadCommand_Gray_95);
    model.apply("loadedGray75", loadCommand_Gray_75);
    model.apply("loadedGray", loadCommand_Gray);
    model.apply("loadedGray", brightenCommand_10);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j].getBlue(),
                model.arrayOfName("loadedGray_95")[i][j].getBlue());
      }
    }
    model.apply("loadedGray", darkenCommand_10);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j].getBlue(),
                model.arrayOfName("loadedGray_75")[i][j].getBlue());
      }
    }

    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedWhite2", loadCommand_White2);
    model.apply("loadedBlack2", loadCommand_Black2);
    model.apply("loadedWhite", brightenWhiteCommand_10);
    model.apply("loadedDark", darkenBlackCommand_10);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j].getBlue(),
                model.arrayOfName("loadedWhite2")[i][j].getBlue());
      }
    }
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j].getBlue(),
                model.arrayOfName("loadedBlack2")[i][j].getBlue());
      }
    }
  }
}