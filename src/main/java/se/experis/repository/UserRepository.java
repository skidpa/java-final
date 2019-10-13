package se.experis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(int id);
    User findUserByuserName(String name);
    User findUserByuserEmail(String email);
    List<User> findAllUserByuserEmail(String email);
    List<User> findAllUserByuserName(String name);
}
