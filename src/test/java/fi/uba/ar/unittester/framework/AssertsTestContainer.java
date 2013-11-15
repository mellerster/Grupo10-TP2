package fi.uba.ar.unittester.framework;

public class AssertsTestContainer extends TestContainer {

    public AssertsTestContainer() {
        addTest(new OneEqualsOneTest());
        addTest(new TwoNotEqualsFourTest());
        addTest(new NotNullNewStringTest());
    }

}
