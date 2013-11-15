package fi.uba.ar.unittester.framework;

public interface TagValidator {
    public boolean validTagToRun(final Test test, final String... tags);
}
