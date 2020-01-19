package global.coda.hms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import global.coda.hms.constant.ApplicationConstant;

/**
 * class for Business Exception.
 *
 * @author Chandraleka
 *
 */
@ControllerAdvice
public class BusinessException extends Exception {

  /**method to show exception message.
   * @param exception to show
   * @return response to the client
   */
  @ExceptionHandler
  public ResponseEntity<Object> exception(BusinessException exception) {
    return ResponseEntity.status(ApplicationConstant.NUMBER404).body(exception);
  }

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
