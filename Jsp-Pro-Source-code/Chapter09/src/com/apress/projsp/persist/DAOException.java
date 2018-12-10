package com.apress.projsp.persist;

/**
 * @author dmj
 */
public class DAOException extends Exception
{
  /**
   * Constructor for DAOException.
   */
  public DAOException() {
    super();
  }

  /**
   * Constructor for DAOException.
   * 
   * @param message
   */
  public DAOException(String message) {
    super(message);
  }

  /**
   * Constructor for DAOException.
   * 
   * @param message
   * @param cause
   */
  public DAOException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor for DAOException.
   * 
   * @param cause
   */
  public DAOException(Throwable cause) {
    super(cause);
  }
}
