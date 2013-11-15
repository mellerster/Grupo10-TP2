package fi.uba.ar.unittester.framework;

import org.apache.commons.lang.Validate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Defines the entry point for the execution of a Test.
 *
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */

public abstract class Test {

    /**
     * Defines the way a tag is validated
     */
    private TagValidator tagValidator;

    /**
     * Tags that belongs to this UnitTest.
     */
    private Set<String> tags = new HashSet<String>();
    public static final String SKIP_TAG = "skip";

    /**
     * Default constructor set default SimpleTagValidator.
     */
    public Test() {
        tagValidator = new SimpleTagValidator();
    }


    /**
     * Define your own way of validate a tag.
     *
     * @param aTagValidator tag validator.
     */
    public Test(SimpleTagValidator aTagValidator) {
        Validate.notNull(aTagValidator, "Tag validator can not be null");
        tagValidator = aTagValidator;
    }


    /**
     * Add new tag to the UnitTest
     *
     * @param newTag
     */
    public void addTag(final String newTag) {
        if (tags == null) {
            tags = new HashSet<String>();
        }
        tags.add(newTag.toLowerCase());
    }

    /*
     * Returns if the test has the tag passed by parameter.
     *
     * @param tagToSearch
     */
    public boolean hasTag(final String tagToSearch) {

        for (String tag : tags) {
            if (tag.equals(tagToSearch.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Defines what should be executed before test execution.
     */
    void setup(final Map<String, Object> context) {
    }

    /**
     * Defines what should be executed after test execution.
     */
    void tearDown(final Map<String, Object> context) {
    }

    /**
     * Runs the test.
     */
    public abstract void run(TestAnalyzer analyzer, Map<String, Object> context, final String... tags);

    /**
     * Returns the test name without package information.
     *
     * @return The test name without package information. It's never null nor
     *         empty.
     */
    public String getTestSimpleName() {
        return getClass().getSimpleName();
    }

    /**
     * Returns the test name whit package information.
     *
     * @return The test name whit package information. It's never null nor
     *         empty.
     */
    public String getTestName() {
        return getClass().getName();

    }

    public boolean hasValidTagToRun(String[] tags) {
        return tagValidator.validTagToRun(this, tags);
    }
}
