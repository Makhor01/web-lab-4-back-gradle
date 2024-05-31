package com.weblab4;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AuthServiceTest {

    @Test
    void testRegister() {
        // Создаем имитацию UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        // Создаем AuthService с имитацией UserRepository
        AuthService authService = new AuthService(userRepository);
        // Вызываем метод register с уникальным логином и паролем
        String login = "test_login";
        String password = "test_password";
        authService.register(login, password);
        // Проверяем, что метод userRepository.save() вызван один раз
        verify(userRepository, times(1)).save(any(User.class));
    }
}