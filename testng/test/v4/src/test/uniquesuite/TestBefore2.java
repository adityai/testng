package test.uniquesuite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBefore2 extends BaseBefore {

  @Test
  public void verify() {
    Assert.assertEquals(m_beforeCount, 1);
  }
}
