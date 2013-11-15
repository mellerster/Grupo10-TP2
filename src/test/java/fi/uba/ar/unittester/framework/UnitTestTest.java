package fi.uba.ar.unittester.framework;

import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UnitTestTest {

    private IsNullTest testIsNull = new IsNullTest();

    @Before
    public void setUp() {
        testIsNull = new IsNullTest();
    }

    @org.junit.Test
    public void test_noAssertFailed() {
        TestAnalyzer analyzer = new TestAnalyzer();
        Map<String, Object> context = new HashMap<String, Object>();
        testIsNull.run(analyzer, context);
        assertThat(analyzer.getTestWithFails(), is(0));
    }

}
