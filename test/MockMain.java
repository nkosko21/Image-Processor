package test;

/**
 * The Mock class of the main method to test the input parsing properly.
 */
public class MockMain {
  private StringBuilder log;

  /**
   * The public constructor for this MockMain class.
   * @param log the StringBuilder to store inputs
   */
  public MockMain(StringBuilder log) {
    this.log = log;
  }

  /**
   * Appends arguments passed to constructor to the log.
   * @param args the arguments to be parsed.
   */
  public void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      this.log.append(args[i] + System.lineSeparator());
    }
  }
}
