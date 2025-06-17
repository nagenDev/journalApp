package net.engineeringdigest.journlApp.repository;

import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.service.UserArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void testAdd() {
        userRepository.getUsersForSA();
    }
}
