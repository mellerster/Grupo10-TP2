package fi.uba.ar.unittester.framework;

import java.util.Map;

public class SampleTestContainer extends TestContainer{

    @Override
    public void setup(Map<String, Object> context) {
        context.put("valor",1);
    }

    public SampleTestContainer() {
        addTest(new OneEqualsOneTest());
        addTest(new TwoNotEqualsFourTest());
        addTest(new InvalidNotNullTest());
    }

}
