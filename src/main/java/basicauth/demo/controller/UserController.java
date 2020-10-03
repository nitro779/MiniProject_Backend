package basicauth.demo.controller;

import basicauth.demo.models.User;
import basicauth.demo.repositories.UserRepository;
import basicauth.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @GetMapping("/login")
    public void login(){

    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
