package test.dependent;

/**
 * This class exercises dependent methods
 *
 * @author Cedric Beust, Aug 19, 2004
 * 
 */
public class SampleDependentMethods2 {
  private boolean m_oneA = false;
  private boolean m_oneB = false;
  private boolean m_secondA = false;
  private boolean m_thirdA = false;
  
  /**
   * @testng.test groups = "one"
   */
  public void oneA() {
//    ppp("oneA");
    assert ! m_secondA : "secondA shouldn't have been run yet";
    m_oneA = true;
  }
  
  /**
   * @testng.test
   */
  public void canBeRunAnytime() {
    
  }
  
  /**
   * @testng.test dependsOnGroups = "one"
   */
  public void secondA() {
//    ppp("secondA");
    assert m_oneA : "SampleDependentMethods2.oneA wasn't run";
    assert m_oneB : "SampleDependentMethods2.oneB wasn't run";
    assert ! m_secondA : "secondA shouldn't have been run yet";
    m_secondA = true;
  }

  /**
   * @testng.test dependsOnMethods = "secondA"
   */
  public void thirdA() {
//    ppp("thirdA");
    assert m_oneA : "SampleDependentMethods2.oneA wasn't run";
    assert m_oneB : "SampleDependentMethods2.oneB wasn't run";
    assert m_secondA : "secondA wasn't run";
    assert ! m_thirdA : "thirdA shouldn't have been run yet";
    m_thirdA = true;
  }

  /**
   * @testng.test groups = "one"
   */
  public void oneB() {
//    ppp("oneB");
    assert ! m_secondA : "secondA shouldn't have been run yet";
    m_oneB = true;
  }
  
  /**
   * @testng.configuration afterTestClass = "true"
   */
  public void tearDown() {
    assert m_oneA : "SampleDependentMethods2.oneA wasn't run";
    assert m_oneB : "SampleDependentMethods2.oneB wasn't run";
    assert m_secondA : "secondA wasn't run";
    assert m_thirdA : "thirdA wasn't run";
  }
  
  public static void ppp(String s) {
    System.out.println("[SampleDependentMethods] " + s);
  }
}