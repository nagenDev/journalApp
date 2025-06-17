//package net.engineeringdigest.journlApp.service;
//
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
////import org.springframework.security.core.userdetails.User;
//import net.engineeringdigest.journlApp.entity.User;
//import java.util.stream.Stream;
//
//public class UserArgumentsProvider implements ArgumentsProvider {
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
//        return Stream.of(
//                Arguments.of(User.builder().userName("shyam").password("shyam").build()),
//               Arguments.of(User.builder().userName("suraj").password("suraj").build())
//        );
//
//    }
//}
////Question: How admin can provide the power to the clas to create user with different roles?
////Answer: Admin can create a user with different roles by providing a method in the UserService class that accepts a User object with roles specified. The AdminController can then call this method to create users with specific roles. The User entity should have a field for roles, which can be a list of strings representing different roles (e.g., "USER", "ADMIN"). When creating a user, the admin can specify the desired roles in the request body.
package net.engineeringdigest.journlApp.service;

import net.engineeringdigest.journlApp.entity.User; // ✅ your entity
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().userName("shyam").password("shyam123")),
                Arguments.of(User.builder().userName("suraj").password("suraj123"))
        );
    }
}
