package global.coda.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import global.coda.hms.jpa.model.User;
import global.coda.hms.jpa.repository.UserRepository;

/**
 * class for SbHMSApplication.
 *
 * @author Chandraleka
 *
 */
@ SpringBootApplication
@ MapperScan("global.coda.hms.mapper")
@ MapperScan("global.coda.hms.security.mapper")

public class SbHmsApplication {
  Logger LOGGER = LogManager.getLogger(SbHmsApplication.class);

  /**
   * main method for the application.
   *
   * @param args pass to main method
   */
  public static void main(String[] args) {
    SpringApplication.run(SbHmsApplication.class, args);
  }

}
