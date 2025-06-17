package net.engineeringdigest.journlApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static  final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public boolean saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            logger.info("ldkfjglkdgjdlkj");
            //logger.info("ldkfjglkdgjdlkj for {} "user.getUsername(),e);//you can use place holder and string cocatination is easy without +.
            logger.warn("jdlkj");
            logger.error("slkdfjslk");
            logger.debug("lskjflsj");
            logger.trace("lskjlkfjs");
            return false;
        }


    }
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);

    }

    public void saveUser(User user) {
        userRepository.save(user);

    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id) {//Optional<> means result will be Optional.empty() if no match found
        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
//controller ----------> service ------------> repository
