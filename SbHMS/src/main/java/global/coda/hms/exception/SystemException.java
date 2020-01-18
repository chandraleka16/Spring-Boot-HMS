package global.coda.hms.exception;

/**
 * class for System Exception.
 *
 * @author Chnadraleka
 *
 */
public class SystemException extends Exception {

  /**
   * serial version ID.
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * default constructor for System exception.
   *
   */
  public SystemException() {
    super();

  }

  /**
   * constructor with parameters for System exception.
   *
   * @param message            about the exception
   * @param cause              for the exception
   * @param enableSuppression  for business exception
   * @param writableStackTrace for business exception
   */
  public SystemException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

  /**
   * Constructor for System exception.
   *
   * @param message about the exception
   * @param cause   for the exception
   */
  public SystemException(String message, Throwable cause) {
    super(message, cause);

  }

  /**
   * constructor for System exception.
   *
   * @param message to show
   */
  public SystemException(String message) {
    super(message);

  }

  /**
   * constructor for System exception.
   *
   * @param cause for the exception
   */
  public SystemException(Throwable cause) {
    super(cause);

  }

}
