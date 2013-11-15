package fi.uba.ar.unittester.framework;

import java.util.Map;

public class NotNullNewStringTest extends UnitTest {

  @Override
  public void test(Map<String, Object> context) {
    Assert.assertNotNull(new String());
  }

}
