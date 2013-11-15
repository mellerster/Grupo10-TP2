package fi.uba.ar.unittester.framework;

public class SimpleTagValidator implements TagValidator {

    public  boolean validTagToRun(final Test test, final String... tags) {
        for (String tag : tags) {
            if (test.hasTag(tag)) {
                return true;
            }
        }
        return false;
    }
}
