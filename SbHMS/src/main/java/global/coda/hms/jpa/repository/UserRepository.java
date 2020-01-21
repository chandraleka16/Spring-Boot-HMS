package global.coda.hms.jpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import global.coda.hms.jpa.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  @Query(
      value = "SELECT user_name from user ORDER By user_name ASC", 
      nativeQuery = true)
    Collection<String> findAllUserNames();
  

}
