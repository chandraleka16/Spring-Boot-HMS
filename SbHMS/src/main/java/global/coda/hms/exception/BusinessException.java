package global.coda.hms.exception;

/**
 * class for Business Exception.
 *
 * @author Chnadraleka
 *
 */
public class BusinessException extends Exception {

  /**
   * serial version ID.
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * default constructor for Business exception.
   *
   */
  public BusinessException() {
    super();

  }

  /**
   * constructor with parameters for business exception.
   *
   * @param message            about the exception
   * @param cause              for the exception
   * @param enableSuppression  for business exception
   * @param writableStackTrace for business exception
   */
  public BusinessException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

  /**
   * Constructor for business exception.
   *
   * @param message about the exception
   * @param cause   for the exception
   */
  public BusinessException(String message, Throwable cause) {
    super(message, cause);

  }

  /**
   * constructor for business exception.
   *
   * @param message to show
   */
  public BusinessException(String message) {
    super(message);

  }

  /**
   * constructor for business exception.
   *
   * @param cause for the exception
   */
  public BusinessException(Throwable cause) {
    super(cause);

  }

}
