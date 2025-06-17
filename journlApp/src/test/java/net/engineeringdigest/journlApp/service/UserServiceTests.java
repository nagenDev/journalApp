package net.engineeringdigest.journlApp.service;
import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //    @ParameterizedTest
//    @CsvSource({
//            "ram",
//            "shyam",
//            "hari"
//    })
//    //you can also use @ValueSource(strings = {"ram", "shyam", "hari"}) for single string inputs and enum values by EnumSource
//    public void testAdd(String name) {
//        assertNotNull(userRepository.findByUserName(name));
//    }
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testAdd(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    //There are few more annotationa like @BeforeEach, @AfterEach, @BeforeAll, @AfterAll
    //BeforeEach will run before each test method, AfterEach will run after each test method, BeforeAll will run once before all test methods and AfterAll will run once after all test methods
    //BeforeAll will run only if the test class is static, otherwise it will throw an error

        //it will run like a loop and run like a,b and expected like that and the values peak from the @csv file or given input
        @Disabled
        @ParameterizedTest
        @CsvSource({
                "1, 2, 3",
                "4, 5, 9",
                "10, 20, 31",
                "100, 200, 300"
        })
        public void test ( int a, int b, int expected){
            assertEquals(expected, a + b);
        }

    }


