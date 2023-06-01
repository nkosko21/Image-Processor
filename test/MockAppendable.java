package test;

import java.io.IOException;

/**
 * Mock Appendable that will throw IOException when appending and
 * returns an empty string when attempting to call the toString method.
 */
class MockAppendable implements Appendable {
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("append failed");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("append failed");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("append failed");
  }

  @Override
  public String toString() {
    return "";
  }
}