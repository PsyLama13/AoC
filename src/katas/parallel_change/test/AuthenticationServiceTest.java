package katas.parallel_change.test;

import katas.parallel_change.main.method.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {

    @Test
    public void administratorIsAlwaysAuthenticated() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int adminId = 12345;
        Assertions.assertTrue(service.isAuthenticated(adminId));
    }
    @Test
    public void normalUserIsNotAuthenticatedInitially() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int normalUserId = 11111;
        Assertions.assertFalse(service.isAuthenticated(normalUserId));
    }

}