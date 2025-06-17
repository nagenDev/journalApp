/*In this class we will learn about mokito.it means like you are not using actual depedency you are
mocking that it is like we are creating some fake repository or dummy user just to run that component
you want to run
bcz if you start it will take some time to make the all connections with componenet  then start

 */
//package net.engineeringdigest.journlApp.service;
//
//import net.engineeringdigest.journlApp.entity.User;
//import net.engineeringdigest.journlApp.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.provider.Arguments;
//import org.mockito.ArgumentMatcher;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class UserDetailServicesImplTest {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Test
//    void loadUserByUsernameTest() {
//        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//                .thenReturn(new User("ram","shyam"));
//        UserDetails user = userDetailsService.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//    }
//}



package net.engineeringdigest.journlApp.service;

import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static  org.mockito.Mockito.*;

@ActiveProfiles("dev")
public class UserDetailServicesImplTest {

    @InjectMocks // injectmocks annotation create instance of userdetailsservice impl and search the annotation who has
    //mock annotation
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

   // @Disabled
    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User .builder().userName("ram").password("inrinrick").roles(new ArrayList<>()).build());
        // Now we can call the method to test
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}
