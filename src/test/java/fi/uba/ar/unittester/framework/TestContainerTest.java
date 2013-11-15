package fi.uba.ar.unittester.framework;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestContainerTest {

    private TestContainer container;

    @Before
    public void setUp() {
        container = new AssertsTestContainer();
    }

    @Test
    public void runAllTests() {
        TestAnalyzer analyzer = new TestAnalyzer();
        Map<String, Object> context = new HashMap<String, Object>();
        container.run(analyzer, context);
        assertThat(analyzer.getTestWithFails(), is(0));
        assertThat(analyzer.getSuccessfulTestsCount(), is(2));
    }
}
