package net.engineeringdigest.journlApp.repository;

import net.engineeringdigest.journlApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendEmail() {
        emailService.sendEmail("ngkv2325@gmail.com",
                "Test Java mail sender",
                "This is a test email sent from the Java mail sender service.");

    }
}