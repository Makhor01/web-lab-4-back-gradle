package com.weblab4;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;



public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    public AuthControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterSuccess() {
        doNothing().when(authService).register("testuser", "password");

        authController.register("testuser", "password");

        verify(authService, times(1)).register("testuser", "password");
    }

    @Test
    public void testLoginSuccess() {
        when(authService.check("Basic dGVzdHVzZXI6cGFzc3dvcmQ=")).thenReturn("testuser");

        authController.login("Basic dGVzdHVzZXI6cGFzc3dvcmQ=");

        verify(authService, times(1)).check("Basic dGVzdHVzZXI6cGFzc3dvcmQ=");
    }

    @Test
    public void testLoginFailure() {
        doThrow(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login")).when(authService).check("Basic dGVzdHVzZXI6aW52YWxpZA==");

        assertThrows(ResponseStatusException.class, () -> {
            authController.login("Basic dGVzdHVzZXI6aW52YWxpZA==");
        });

        verify(authService, times(1)).check("Basic dGVzdHVzZXI6aW52YWxpZA==");
    }
}
