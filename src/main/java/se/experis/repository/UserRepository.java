package se.experis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findUserById(int id);
    Users findUserByuserName(String name);
    Users findUserByuserEmail(String email);
    List<Users> findAllUserByuserEmail(String email);
    List<Users> findAllUserByuserName(String name);
}
