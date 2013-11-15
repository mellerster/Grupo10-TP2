package fi.uba.ar.unittester.framework;

/** Utility class that provides several assertion methods that can be used by
 * {@link Test} implementations.
 * 
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 *
 */
public class Assert {

  /** Asserts that a given boolean condition is true.
   * @param assertionCondition The boolean condition for the assertion.
   */
  public static void assertTrue(final boolean assertionCondition) {
    if (!assertionCondition) {
      throw new AssertionFailError("assertTrue");
    }
  }

  /** Asserts that a given boolean condition is false.
   * @param assertionCondition The boolean condition for the assertion.
   */
  public static void assertFalse(final boolean assertionCondition) {
    if (assertionCondition) {
      throw new AssertionFailError("assertFalse");
    }
  }

  /** Asserts that two objects are equal.
   * @param first The first object to be compared.
   * @param second The second object to be compared.
   */
  public static void assertEquals(final Object first,
      final Object second) {
    if (!first.equals(second)) {
      throw new AssertionFailError("assertEquals");
    }
  }

  /** Asserts that two objects are not equal.
   * @param first The first object to be compared.
   * @param second The second object to be compared.
   */
  public static void assertNotEquals(final Object first,
      final Object second) {
    if (first.equals(second)) {
      throw new AssertionFailError("assertNotEquals");
    }
  }

  /** Asserts that the given object is not null.
   * @param assertionCondition The object for the assertion.
   */
  public static void assertNotNull(final Object assertionCondition) {
    if (assertionCondition == null) {
      throw new AssertionFailError("assertNotNull");
    }
  }

  /** Asserts that the given object is null.
   * @param assertionCondition The object for the assertion.
   */
  public static void assertNull(final Object assertionCondition) {
    if (assertionCondition != null) {
      throw new AssertionFailError("assertNotNull");
    }
  }
}
