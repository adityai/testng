package org.testng.internal.annotations;

/**
 * An implementation of IExpectedExceptions
 * 
 * Created on Dec 20, 2005
 * @author <a href="mailto:cedric@beust.com">Cedric Beust</a>
 */
public class ExpectedExceptionsAnnotation implements IExpectedExceptions {
  private Class[] m_value = {};
  
  public Class[] getValue() {
    return m_value;
  }

  public void setValue(Class[] value) {
    m_value = value;
  }
}
