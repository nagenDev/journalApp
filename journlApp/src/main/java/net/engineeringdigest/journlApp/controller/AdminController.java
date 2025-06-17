package net.engineeringdigest.journlApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journlApp.cache.AppCache;
import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name = "Admin APIs", description = "APIs for admin operations")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public void createUser(@RequestBody User user) {
        userService.saveAdmin(user);
    }

    @GetMapping("clear-app-cache")
    public void clearAppCache() {
        appCache.init();
    }
}
