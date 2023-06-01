package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import commands.ImageCommand;
import commands.Load;
import commands.Mosaic;
import commands.Save;
import model.ImageModel;
import model.ImageProcessModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * tests for the mosaic command object.
 */
public class MosaicTest {
  private ImageProcessModel model;
  private ImageCommand doMosaic50;
  private ImageCommand doMosaic500;
  private ImageCommand doMosaic1000;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    ImageCommand mosaic_50 = new Load("mosaic50",
            "/Users/nick/Documents/NORTHEASTERN/" +
                    "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/flower.png");
    ImageCommand mosaic_500 = new Load("mosaic500","/Users/nick/Documents/NORTHEASTERN/" +
            "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/flower.png");
    ImageCommand mosaic_1000 = new Load("mosaic1000", "/Users/nick/Documents/NORTHEASTERN/" +
            "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/flower.png");
    ImageCommand saveCommand = new Save("loaded", "/Users/nick/Documents/NORTHEASTERN/" +
            "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/flower.png");
    doMosaic50 = new Mosaic("mosaic50", 50, getPseudoRandomSeeds(50));
    doMosaic500 = new Mosaic("mosaic500", 500, getPseudoRandomSeeds(500));
    doMosaic1000 = new Mosaic("mosaic1000", 1000,
            getPseudoRandomSeeds(1000));

    new Load("realMosaic50", "/Users/nick/Documents/NORTHEASTERN/" +
            "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/realMosaic50.png");
    new Load("realMosaic500", "/Users/nick/Documents/NORTHEASTERN/" +
            "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/flower.png");
    new Load("realMosaic1000", "/Users/nick/Documents/NORTHEASTERN/" +
            "Fall 2022 Academic/CS3500/Code stuff/Assignment 7/src/flower.png");
  }

  @Test
  public void test() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("mosaic50", doMosaic50);
    assertFalse(model.checkEmpty());
    model.apply("mosaic500", doMosaic500);
    model.apply("mosaic1000", doMosaic1000);

    for (int row = 0; row < 100; row++) {
      for (int col = 0; col < 100; col++) {
        Assert.assertEquals(model.arrayOfName("mosaic50")[row][col].
                equals(model.arrayOfName("realMosaic50")[row][col]), true);
      }
    }

    for (int row = 0; row < 100; row++) {
      for (int col = 0; col < 100; col++) {
        Assert.assertEquals(model.arrayOfName("mosaic500")[row][col].
                equals(model.arrayOfName("realMosaic500")[row][col]), true);
      }
    }

    for (int row = 0; row < 100; row++) {
      for (int col = 0; col < 100; col++) {
        Assert.assertEquals(model.arrayOfName("mosaic1000")[row][col].
                equals(model.arrayOfName("realMosaic1000")[row][col]), true);
      }
    }
  }

  /**
   * For use in the above method. Gets an array of random seeds using java's pseudo-random class,
   * so it's easier to test.
   * @param numSeeds the length of the seed array.
   * @return an array of seeds of the desired length.
   */
  private Mosaic.Posn[] getPseudoRandomSeeds(int numSeeds) {
    Mosaic.Posn[] output = new Mosaic.Posn[numSeeds];
    for (Mosaic.Posn entry : output) {
      Random rand = new Random(420);
      entry = new Mosaic.Posn(rand.nextInt(), rand.nextInt());
    }
    return output;
  }

}
