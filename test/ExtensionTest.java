package test;

import org.junit.Before;
import org.junit.Test;

import commands.ImageUtil;

import static org.junit.Assert.assertEquals;

/**
 * Tests whether the extension method works in the ImageUtil class.
 */
public class ExtensionTest {
  ImageUtil util;

  @Before
  public void init() {
    util = new ImageUtil();
  }

  @Test
  public void testNames() {
    String name1 = "/home/user/bob.txt";
    String ext1 = "/home/user/image1.ppm";
    String ext2 = "/home/user/image2.jpeg";
    String ext3 = "/home/user/image3.png";
    String ext4 = "/home/user/image4.bmp";
    String invalid1 = "falsdjfl;sjf;sadlf";
    String invalid2 = "falsdjfl;sjf;sadl.";


    assertEquals(util.extOfFile(name1), "txt");
    assertEquals(util.extOfFile(ext1), "ppm");
    assertEquals(util.extOfFile(ext2), "jpeg");
    assertEquals(util.extOfFile(ext3), "png");
    assertEquals(util.extOfFile(ext4), "bmp");
    assertEquals(util.extOfFile(ext3), "png");
    assertEquals(util.extOfFile(invalid1), "falsdjfl;sjf;sadlf");
    assertEquals(util.extOfFile(invalid2), "");
  }
}
