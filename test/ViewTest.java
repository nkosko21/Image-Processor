package test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import test.MockAppendable;
import view.ImageProcessView;
import view.ImageView;

import static org.junit.Assert.assertEquals;

/**
 * Tests the View component of the image process program.
 */
public class ViewTest {
  private ImageProcessView view;
  private ImageProcessView viewMockOut;
  private Appendable out;
  private Appendable mockOut;

  @Before
  public void init() {
    out = new StringBuffer();
    mockOut = new MockAppendable();
    view = new ImageView(out);
    viewMockOut = new ImageView(mockOut);
  }

  @Test
  public void testViewConstruction() {
    try {
      ImageProcessView view1 = new ImageView(null);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model or appendable cannot be null");
    }
    try {
      ImageProcessView view1 = new ImageView(null);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model or appendable cannot be null");
    }
    try {
      ImageProcessView view1 = new ImageView(System.out);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "model or appendable cannot be null");
    }
  }

  @Test
  public void testViewRenderMessage() throws IOException {
    assertEquals(out.toString(), "");
    view.renderMessage("testing!");
    assertEquals(out.toString(), "testing!");
  }

  @Test
  public void testViewRenderMessage2() throws IOException {
    assertEquals(out.toString(), "");
    view.renderMessage("");
    assertEquals(out.toString(), "");
  }

  @Test
  public void testMockAppendable() {
    assertEquals(mockOut.toString(), "");
    try {
      viewMockOut.renderMessage("testing!");
    }
    catch (IOException e) {
      assertEquals(e.getMessage(), "append failed");
    }
  }
}