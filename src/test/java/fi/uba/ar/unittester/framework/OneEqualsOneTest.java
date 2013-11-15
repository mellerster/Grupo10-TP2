package fi.uba.ar.unittester.framework;

import java.util.Map;

public class OneEqualsOneTest extends UnitTest {

  @Override
  public void test(Map<String, Object> context) {
    Assert.assertEquals(1,1);
  }

}
