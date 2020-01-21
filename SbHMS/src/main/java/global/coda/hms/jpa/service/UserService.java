package global.coda.hms.jpa.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hms.jpa.repository.UserRepository;
import global.coda.hms.jpa.model.User;

@ Service
public class UserService {
  @ Autowired
  UserRepository repository;

  public List<User> getAllUsers() {
    List<User> userList = null;
    return (List<User>) repository.findAll();

  }

  public Collection<String> getAllUserNames() {
    return (Collection<String>) repository.findAllUserNames();
  }

  public User createUser(User user) {
    return  repository.save(user);
  }

}
