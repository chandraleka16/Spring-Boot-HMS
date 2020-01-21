package global.coda.hms.jpa.controller;

import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.jpa.model.User;
import global.coda.hms.jpa.service.UserService;
import global.coda.hms.model.Doctor;

@ RestController
public class UserController {
  @ Autowired
  UserService service;
  Logger LOGGER=LogManager.getLogger(UserController.class);
  
  @ PostMapping("/createUser")
  public ResponseEntity<User> createDoctor(@ RequestBody User user)
      throws SystemException, BusinessException {
    LOGGER.traceEntry("creating user",user);
    LOGGER.info("Inside Create User");
    return ResponseEntity.status(HttpStatus.OK).body(service.createUser(user));

  }

  @ GetMapping("/users")
  public ResponseEntity<List<User>> getAllUser() {
    return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
  }

  @ GetMapping("/usernames")
  public ResponseEntity<Collection<String>> getAllUserName() {
    return new ResponseEntity<>(service.getAllUserNames(), HttpStatus.OK);
  }
}
