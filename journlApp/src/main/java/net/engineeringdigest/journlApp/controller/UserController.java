package net.engineeringdigest.journlApp.controller;
//package net.engineeringdigest.journlApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journlApp.api.responce.WeatherResponce;
import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.repository.UserRepository;
import net.engineeringdigest.journlApp.service.UserService;
import net.engineeringdigest.journlApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User APIs", description = "read update and delete user details")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        if(userInDb !=null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponce weatherResponce = weatherService.getWeather("Mumbai");
        String greeting = "";
        if(weatherResponce != null) {
            greeting = ", the weather feels like " + weatherResponce.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+authentication.getName()+greeting,HttpStatus.OK);
    }
//e611b0564ec10fbf1d078106d8e511f8

}
