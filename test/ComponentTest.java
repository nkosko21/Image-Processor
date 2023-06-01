package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import commands.Component;
import commands.ImageCommand;
import model.ImageModel;
import model.ImageProcessModel;
import commands.Load;
import commands.Save;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests each part of the Component command.
 */
public class ComponentTest {
  private ImageProcessModel model;
  private ImageCommand loadCommand;
  private ImageCommand loadCommand2;
  private ImageCommand loadCommand_Black;
  private ImageCommand loadCommand_White;
  private ImageCommand loadCommand_Red;
  private ImageCommand loadCommand_Green;
  private ImageCommand loadCommand_Blue;
  private ImageCommand loadCommand_Gray;
  private ImageCommand redComponentCommand;
  private ImageCommand redComponentCommand_Black;
  private ImageCommand redComponentCommand_White;
  private ImageCommand redComponentCommand_Red;
  private ImageCommand redComponentCommand_Green;
  private ImageCommand redComponentCommand_Blue;
  private ImageCommand redSaveCommand;
  private ImageCommand greenComponentCommand;
  private ImageCommand greenComponentCommand_Black;
  private ImageCommand greenComponentCommand_White;
  private ImageCommand greenComponentCommand_Red;
  private ImageCommand greenComponentCommand_Green;
  private ImageCommand greenComponentCommand_Blue;
  private ImageCommand greenSaveCommand;
  private ImageCommand blueComponentCommand;
  private ImageCommand blueComponentCommand_Black;
  private ImageCommand blueComponentCommand_White;
  private ImageCommand blueComponentCommand_Red;
  private ImageCommand blueComponentCommand_Green;
  private ImageCommand blueComponentCommand_Blue;
  private ImageCommand blueSaveCommand;
  private ImageCommand valueComponentCommand;
  private ImageCommand valueComponentCommand_Black;
  private ImageCommand valueComponentCommand_White;
  private ImageCommand valueComponentCommand_Red;
  private ImageCommand valueComponentCommand_Green;
  private ImageCommand valueComponentCommand_Blue;
  private ImageCommand valueComponentCommand_Gray;
  private ImageCommand valueSaveCommand;
  private ImageCommand intensityComponentCommand;
  private ImageCommand intensityComponentCommand_Black;
  private ImageCommand intensityComponentCommand_White;
  private ImageCommand intensityComponentCommand_Red;
  private ImageCommand intensityComponentCommand_Green;
  private ImageCommand intensityComponentCommand_Blue;
  private ImageCommand intensityComponentCommand_Gray;
  private ImageCommand intensitySaveCommand;
  private ImageCommand lumaComponentCommand;
  private ImageCommand lumaComponentCommand_Black;
  private ImageCommand lumaComponentCommand_White;
  private ImageCommand lumaComponentCommand_Gray;
  private ImageCommand lumaSaveCommand;
  private ImageCommand sepiaComponentCommand;
  private ImageCommand sepiaSaveCommand;
  private ImageCommand sharperComponentCommand;
  private ImageCommand sharperSaveCommand;
  private ImageCommand blurComponentCommand;
  private ImageCommand blurSaveCommand;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    loadCommand = new Load("loaded",
            "out/production/hw5imageprocessing/res/1.ppm");
    /*
    loadCommand_Black = new Load("loadedBlack",
            "output/Black.ppm");
    loadCommand_White = new Load("loadedWhite",
            "output/White.ppm");
    loadCommand_Red = new Load("loadedRed",
            "output/Red.ppm");
    loadCommand_Green = new Load("loadedGreen",
            "output/Green.ppm");
    loadCommand_Blue = new Load("loadedBlue",
            "output/Blue.ppm");
    loadCommand_Gray = new Load("loadedGray",
            "output/Gray.ppm");
    redComponentCommand = new Component("loaded", "redChangedLoaded",
            "red");
    redComponentCommand_Black =  new Component("loadedBlack", "redChangedLoadedBlack",
            "red");
    redComponentCommand_White =  new Component("loadedWhite", "redChangedLoadedWhite",
            "red");
    redComponentCommand_Red =  new Component("loadedRed", "redChangedLoadedRed",
            "red");
    redComponentCommand_Green =  new Component("loadedGreen", "redChangedLoadedGreen",
            "red");
    redComponentCommand_Blue =  new Component("loadedBlue", "redChangedLoadedBlue",
            "red");
*/

    sepiaComponentCommand = new Component("loaded", "sepiaChangedLoaded",
            "sepia");
    sharperComponentCommand = new Component("loaded", "sharperChangedLoaded",
            "sharper");
    blurComponentCommand = new Component("loaded", "blurChangedLoaded",
            "blur");

    redSaveCommand = new Save("redChangedLoaded",
            "output/redChangedLoaded.ppm");

    sepiaSaveCommand = new Save("sepiaChangedLoaded",
            "C:/Users/13741/Documents/hw5imageprocessing/out/production/" +
                    "hw5imageprocessing/res/sepiaChangedLoaded.ppm");
    sharperSaveCommand = new Save("sharperChangedLoaded",
            "C:/Users/13741/Documents/hw5imageprocessing/out/production/" +
                    "hw5imageprocessing/res/shaperChangedLoaded.ppm");
    blurSaveCommand = new Save("blurChangedLoaded",
            "C:/Users/13741/Documents/hw5imageprocessing/out/production/" +
                    "hw5imageprocessing/res/NewblurChangedLoaded.ppm");

    greenComponentCommand = new Component("loaded", "greenChangedLoaded",
            "green");
    greenComponentCommand_Black =  new Component("loadedBlack", "greenChangedLoadedBlack",
            "green");
    greenComponentCommand_White =  new Component("loadedWhite", "greenChangedLoadedWhite",
            "green");
    greenComponentCommand_Red =  new Component("loadedRed", "greenChangedLoadedRed",
            "green");
    greenComponentCommand_Green =  new Component("loadedGreen", "greenChangedLoadedGreen",
            "green");
    greenComponentCommand_Blue =  new Component("loadedBlue", "greenChangedLoadedBlue",
            "green");

    greenSaveCommand = new Save("greenChangedLoaded",
            "output/greenChangedLoaded.ppm");

    blueComponentCommand = new Component("loaded", "blueChangedLoaded",
            "blue");
    blueComponentCommand_Black =  new Component("loadedBlack", "blueChangedLoadedBlack",
            "blue");
    blueComponentCommand_White =  new Component("loadedWhite", "blueChangedLoadedWhite",
            "blue");
    blueComponentCommand_Red =  new Component("loadedRed", "blueChangedLoadedRed",
            "blue");
    blueComponentCommand_Green =  new Component("loadedGreen", "blueChangedLoadedGreen",
            "blue");
    blueComponentCommand_Blue =  new Component("loadedBlue", "blueChangedLoadedBlue",
            "blue");

    blueSaveCommand = new Save("blueChangedLoaded",
            "output/blueChangedLoaded.ppm");

    valueComponentCommand = new Component("loaded", "valueChangedLoaded",
            "value");
    valueComponentCommand_Black =  new Component("loadedBlack", "valueChangedLoadedBlack",
            "value");
    valueComponentCommand_White =  new Component("loadedWhite", "valueChangedLoadedWhite",
            "value");
    valueComponentCommand_Red =  new Component("loadedRed", "valueChangedLoadedRed",
            "value");
    valueComponentCommand_Green =  new Component("loadedGreen", "valueChangedLoadedGreen",
            "value");
    valueComponentCommand_Blue =  new Component("loadedBlue", "valueChangedLoadedBlue",
            "value");
    valueComponentCommand_Gray =  new Component("loadedGray", "valueChangedLoadedGray",
            "value");

    valueSaveCommand = new Save("loaded",
            "output/valueChangedLoaded.ppm");

    intensityComponentCommand = new Component("loaded", "intensityChangedLoaded",
            "intensity");
    intensityComponentCommand_Black =  new Component("loadedBlack", "intensityChangedLoadedBlack",
            "intensity");
    intensityComponentCommand_White =  new Component("loadedWhite", "intensityChangedLoadedWhite",
            "intensity");
    intensityComponentCommand_Red =  new Component("loadedRed", "intensityChangedLoadedRed",
            "intensity");
    intensityComponentCommand_Green =  new Component("loadedGreen", "intensityChangedLoadedGreen",
            "intensity");
    intensityComponentCommand_Blue =  new Component("loadedBlue", "intensityChangedLoadedBlue",
            "intensity");
    intensityComponentCommand_Gray =  new Component("loadedGray", "intensityChangedLoadedGray",
            "intensity");

    intensitySaveCommand = new Save("intensityChangedLoaded",
            "output/intensityChangedLoaded.ppm");

    lumaComponentCommand = new Component("loaded", "luma",
            "luma");
    lumaComponentCommand_Black =  new Component("loadedBlack", "lumaChangedLoadedBlack",
            "luma");
    lumaComponentCommand_White =  new Component("loadedWhite", "lumaChangedLoadedWhite",
            "luma");
    lumaComponentCommand_Gray =  new Component("loadedGray", "lumaChangedLoadedGray",
            "luma");

    lumaSaveCommand = new Save("luma",
            "output/lumaChangedLoaded.ppm");
  }

  @Test
  public void testRedComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", redComponentCommand);
    model.apply("redChangedLoaded", redSaveCommand);
    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedBlack", redComponentCommand_Black);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("redChangedLoadedBlack")[i][j]);
      }
    }
    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedWhite", redComponentCommand_White);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("redChangedLoadedWhite")[i][j]);
      }
    }
    model.apply("loadedRed", loadCommand_Red);
    model.apply("loadedRed", redComponentCommand_Red);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("redChangedLoadedRed")[i][j]);
      }
    }
    model.apply("loadedGreen", loadCommand_Green);
    model.apply("loadedGreen", redComponentCommand_Green);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("redChangedLoadedGreen")[i][j]);
      }
    }
    model.apply("loadedBlue", loadCommand_Blue);
    model.apply("loadedBlue", redComponentCommand_Blue);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("redChangedLoadedBlue")[i][j]);
      }
    }
  }

  @Test
  public void testGreenComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", greenComponentCommand);
    model.apply("greenChangedLoaded", greenSaveCommand);
    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedBlack", greenComponentCommand_Black);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("greenChangedLoadedBlack")[i][j]);
      }
    }
    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedWhite", greenComponentCommand_White);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("greenChangedLoadedWhite")[i][j]);
      }
    }
    model.apply("loadedRed", loadCommand_Red);
    model.apply("loadedRed", greenComponentCommand_Red);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("greenChangedLoadedRed")[i][j]);
      }
    }
    model.apply("loadedGreen", loadCommand_Green);
    model.apply("loadedGreen", greenComponentCommand_Green);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("greenChangedLoadedGreen")[i][j]);
      }
    }
    model.apply("loadedBlue", loadCommand_Blue);
    model.apply("loadedBlue", greenComponentCommand_Blue);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("greenChangedLoadedBlue")[i][j]);
      }
    }
  }

  @Test
  public void testBlueComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", blueComponentCommand);
    model.apply("blueChangedLoaded", blueSaveCommand);

    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedBlack", blueComponentCommand_Black);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("blueChangedLoadedBlack")[i][j]);
      }
    }
    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedWhite", blueComponentCommand_White);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("blueChangedLoadedWhite")[i][j]);
      }
    }
    model.apply("loadedRed", loadCommand_Red);
    model.apply("loadedRed", blueComponentCommand_Red);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("blueChangedLoadedRed")[i][j]);
      }
    }
    model.apply("loadedGreen", loadCommand_Green);
    model.apply("loadedGreen", blueComponentCommand_Green);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("blueChangedLoadedGreen")[i][j]);
      }
    }
    model.apply("loadedBlue", loadCommand_Blue);
    model.apply("loadedBlue", blueComponentCommand_Blue);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("blueChangedLoadedBlue")[i][j]);
      }
    }
  }

  @Test
  public void testValueComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", valueComponentCommand);
    model.apply("valueChangedLoaded", valueSaveCommand);

    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedBlack", valueComponentCommand_Black);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("valueChangedLoadedBlack")[i][j]);
      }
    }
    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedWhite", valueComponentCommand_White);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("valueChangedLoadedWhite")[i][j]);
      }
    }
    model.apply("loadedRed", loadCommand_Red);
    model.apply("loadedRed", valueComponentCommand_Red);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("valueChangedLoadedRed")[i][j]);
      }
    }
    model.apply("loadedGreen", loadCommand_Green);
    model.apply("loadedGreen", valueComponentCommand_Green);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("valueChangedLoadedGreen")[i][j]);
      }
    }
    model.apply("loadedBlue", loadCommand_Blue);
    model.apply("loadedBlue", valueComponentCommand_Blue);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("valueChangedLoadedBlue")[i][j]);
      }
    }
    model.apply("loadedGray", loadCommand_Gray);
    model.apply("loadedGray", valueComponentCommand_Gray);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("valueChangedLoadedGray")[i][j]);
      }
    }
  }

  @Test
  public void testIntensityComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", intensityComponentCommand);
    model.apply("intensityChangedLoaded", intensitySaveCommand);

    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedBlack", intensityComponentCommand_Black);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("intensityChangedLoadedBlack")[i][j]);
      }
    }
    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedWhite", intensityComponentCommand_White);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("intensityChangedLoadedWhite")[i][j]);
      }
    }
    model.apply("loadedGray", loadCommand_Gray);
    model.apply("loadedGray", intensityComponentCommand_Gray);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j],
                model.arrayOfName("intensityChangedLoadedGray")[i][j]);
      }
    }
    model.apply("loadedRed", loadCommand_Red);
    model.apply("loadedRed", intensityComponentCommand_Red);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j],
                model.arrayOfName("intensityChangedLoadedRed")[i][j]);
      }
    }
    model.apply("loadedGreen", loadCommand_Green);
    model.apply("loadedGreen", intensityComponentCommand_Green);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j],
                model.arrayOfName("intensityChangedLoadedGreen")[i][j]);
      }
    }
    model.apply("loadedBlue", loadCommand_Blue);
    model.apply("loadedBlue", intensityComponentCommand_Blue);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j],
                model.arrayOfName("intensityChangedLoadedBlue")[i][j]);
      }
    }
  }

  @Test
  public void testLumaComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", lumaComponentCommand);
    model.apply("luma", lumaSaveCommand);
    model.apply("loadedBlack", loadCommand_Black);
    model.apply("loadedBlack", lumaComponentCommand_Black);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedBlack")[i][j],
                model.arrayOfName("lumaChangedLoadedBlack")[i][j]);
      }
    }
    model.apply("loadedWhite", loadCommand_White);
    model.apply("loadedWhite", lumaComponentCommand_White);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedWhite")[i][j],
                model.arrayOfName("lumaChangedLoadedWhite")[i][j]);
      }
    }
    model.apply("loadedGray", loadCommand_Gray);
    model.apply("loadedGray", lumaComponentCommand_Gray);
    for (int i = 0; i < 768; i++) {
      for (int j = 0; j < 1024; j++) {
        assertEquals(model.arrayOfName("loadedGray")[i][j].getBlue(),
                model.arrayOfName("lumaChangedLoadedGray")[i][j].getBlue());
      }
    }
  }

  @Test
  public void testBlurComponent() throws IOException {

    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", blurComponentCommand);
    model.apply("blurChangedLoaded", blurSaveCommand);

  }

  @Test
  public void testSepiaComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", sepiaComponentCommand);
    model.apply("sepiaChangedLoaded", sepiaSaveCommand);
  }

  @Test
  public void testShaperComponent() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommand);
    assertFalse(model.checkEmpty());
    model.apply("loaded", sharperComponentCommand);
    model.apply("sharperChangedLoaded", sharperSaveCommand);
  }
}