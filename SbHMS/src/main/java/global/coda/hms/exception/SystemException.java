package global.coda.hms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import global.coda.hms.constant.ApplicationConstant;

/**
 * class for System Exception.
 *
 * @author Chandraleka
 *
 */
@ControllerAdvice
public class SystemException extends Exception {

  /**
   * method to show exception message.
   *
   * @param exception to show
   * @return response to the client
   */
  @ExceptionHandler
  public ResponseEntity<Object> exception(BusinessException exception) {
    return ResponseEntity.status(ApplicationConstant.NUMBER404).body("Sorry!\nSomething went Wrong!");
  }

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
