package fi.uba.ar.unittester.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;


/**
 * Contains Unit Test and runs them.
 *
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */
public abstract class TestContainer extends Test {

  /**
   * The tests that the container will run. It's never null or empty.
   */
  private List<Test> tests = new ArrayList<Test>();

  /**
   * Runs tests in this container
   *
   * @param analyzer TestsAnalizer to persist test results.
   * @param tags
   */
  @Override
  public final void run(final TestAnalyzer analyzer,
                        final Map<String, Object> context, final String... tags) {

    setup(context);
    String currentTestName = analyzer.getCurrentTestName();

    if (!currentTestName.isEmpty()) {
      currentTestName += ".";
    }
    currentTestName = currentTestName + getTestSimpleName();

    analyzer.setCurrentTestName(currentTestName);
    for (Test test : tests) {
        if (!test.hasTag(Test.SKIP_TAG) && (tags.length == 0 || test.hasValidTagToRun(tags))) {
            test.run(analyzer, context);
        }
    }
    tearDown(context);
  }

  /**
   * Adds a new {@link Test} to be run.
   *
   * @param test The test to be run. It cannot be null.
   */
  protected void addTest(final Test test) {
    Validate.notNull(test, "The Test cannot be null.");
    String testName = test.getTestName();
    for (Test oneTest: tests) {
      if (testName.equals(oneTest.getTestName())) {
        return;
      }
    }
    tests.add(test);
  }

  public List<Test> getTests() {
    return tests;
  }
}
