package fi.uba.ar.unittester.framework;

import org.apache.commons.lang.Validate;

/** Error caused by an Assertion.
 * 
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 *
 */
public class AssertionError extends Error {

  /**
   * The name of the assertion that caused the error. It's never null nor empty.
   */
  private String assertionName;

  private static final long serialVersionUID = 1L;

  /** Makes a new instance of a {@link AssertionError}.
   * @param theAssertionName The name of the assertion that caused the error.
   * It cannot be null nor empty.
   */
  public AssertionError(final String theAssertionName) {
    Validate.notEmpty(theAssertionName,
        "The assertion name cannot be null nor empty.");
    assertionName = theAssertionName;
  }

  /** Returns the name of the assertion that caused the error.
   * @return The name of the assertion that caused the error. It's never null
   * nor empty.
   */
  public String getAssertionName() {
    return assertionName;
  }
}
