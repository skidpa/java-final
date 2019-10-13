package se.experis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.experis.model.Users;
import se.experis.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Controller
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // add a user
    @PostMapping("/api/user")
    @ResponseBody
    public Users addAUser(HttpServletResponse response, @RequestBody Users user) { //TODO: Catch constraint error thing

        Users newUser = userRepository.save(user);

        if (newUser.getId() == 0) {
            response.setStatus(400);
        } else {
            response.setStatus(201);
        }
        return newUser;
    }
    // works
    // get user by id
    @GetMapping("/api/user/{id}")
    public Users getUserById(@PathVariable("id") int id){
        return userRepository.findUserById(id);
    }
    // get user by name if username is not unique this will return a 500 response
    // should work since user names are unique though
    @GetMapping("/api/user/name/{name}") // returns nothing
    public Users getUserByName(@PathVariable("name") String name){
        return userRepository.findUserByuserName(name);
    }

    @GetMapping("/api/user/email/{email}") // returns nothing
    public Users getUserByEmail(@PathVariable("email") String email){
        return userRepository.findUserByuserEmail(email);
    }

    // get all users
    // works
    @GetMapping("/api/user/list")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    // get all users by name
    // works
    @GetMapping("/api/user/list/name/{name}")
    public List<Users> getUserListByName(@PathVariable String name){
        return userRepository.findAllUserByuserName(name);
    }

    @GetMapping("/api/user/list/name/{email}")
    public List<Users> getUserListByEmail(@PathVariable String email){
        return userRepository.findAllUserByuserEmail(email);
    }

}
