package fi.uba.ar.unittester.framework;

/**
 * Error caused when an assertion failed.
 *
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */
public class AssertionFailError extends AssertionError {

  private static final long serialVersionUID = 1L;

  /**
   * Makes a new instance of a {@link AssertionFailError}.
   *
   * @param theAssertionName The name of the assertion that caused the fail.
   * It cannot be null nor empty.
   */
  public AssertionFailError(final String theAssertionName) {
    super(theAssertionName);
  }
}
