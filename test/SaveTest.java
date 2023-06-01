package test;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import commands.ImageCommand;
import model.ImageModel;
import model.ImageProcessModel;
import commands.ImageUtil;
import commands.Load;
import commands.Save;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the save command.
 */
public class SaveTest {
  private ImageProcessModel model;
  private ImageCommand loadCommandPPM;
  private ImageCommand loadCommandJPEG;
  private ImageCommand loadCommandPNG;
  private ImageCommand loadCommandBMP;
  private ImageCommand saveCommandPPM;
  private ImageCommand saveCommandJPEG;
  private ImageCommand saveCommandPNG;
  private ImageCommand saveCommandBMP;

  @Before
  public void init() throws IOException {
    model = new ImageModel();
    loadCommandPPM = new Load("loaded",
            "output/Koala.ppm");
    loadCommandJPEG = new Load("loaded",
            "resJPEG/flower.jpeg");
    loadCommandPNG = new Load("loaded",
            "resPNG/flower.png");
    loadCommandBMP = new Load("loaded",
            "resBMP/flower.bmp");
    saveCommandPPM = new Save("loaded",
            "output/Koala2.ppm");
    saveCommandJPEG = new Save("loaded",
            "resJPEG/flower2.jpeg");
    saveCommandPNG = new Save("loaded",
            "resPNG/flower2.png");
    saveCommandBMP = new Save("loaded",
            "resBMP/flower2.bmp");
  }

  /**
   * Tests if the given file is in ppm format.
   * @param filename the name of the file to be checked
   * @return true if the file is in ppm format
   */
  private boolean testFormat(String filename) {
    Scanner sc;
    try {
      sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found!");
      return false;
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    return token.equals("P3") && maxValue == 255 && width == 1024 && height == 768;
  }

  /**
   * Tests if the given file is in bmp format.
   * @param file the name of the file to be checked
   * @return true if the file is in bmp format
   */
  private boolean testBMP(String file) {
    Scanner sc;
    try {
      sc = new Scanner(new FileInputStream(file));
    }
    catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found!");
      return false;
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    return token.equals("BM6");
  }

  @Test
  public void testImagesInside() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommandPPM);
    assertFalse(model.checkEmpty());
    model.apply("loaded", saveCommandPPM);
    assertTrue(this.testFormat("output/dog.ppm"));
  }

  @Test
  public void testSaveJPEG() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommandJPEG);
    assertFalse(model.checkEmpty());
    model.apply("loaded", saveCommandJPEG);
    assertTrue(new ImageUtil().extOfFile("resJPEG/flower2.jpeg").equals("jpeg"));
  }

  @Test
  public void testSavePNG() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommandPNG);
    assertFalse(model.checkEmpty());
    model.apply("loaded", saveCommandPNG);
    assertTrue(new ImageUtil().extOfFile("resPNG/flower2.png").equals("png"));
  }

  @Test
  public void testSaveBMP() throws IOException {
    assertTrue(model.checkEmpty());
    model.apply("loaded", loadCommandBMP);
    assertFalse(model.checkEmpty());
    model.apply("loaded", saveCommandBMP);
    assertTrue(this.testBMP("resBMP/flower2.bmp"));
  }
}
