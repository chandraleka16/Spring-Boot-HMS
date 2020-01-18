package global.coda.hms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * class for SbHMSApplication.
 *
 * @author Chandraleka
 *
 */
@SpringBootApplication
@MapperScan("global.coda.hms.mapper")
public class SbHmsApplication {

  /**
   * main method for the application.
   *
   * @param args pass to main method
   */
  public static void main(String[] args) {
    SpringApplication.run(SbHmsApplication.class, args);
  }

}
