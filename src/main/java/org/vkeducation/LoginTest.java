package org.vkeducation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vkeducation.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void init() {
        loginPage = new LoginPage();
        open(BASE_URL);
    }

    @Test
    public void testLoginInvalidCredentials() {
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testLoginEmptyUsername() {
        loginPage.login(EMPTY_STRING, VALID_PASSWORD);
        assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testLoginEmptyPassword() {
        loginPage.login(VALID_USERNAME, EMPTY_STRING);
        assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        loginPage.verifySuccessfulLogin();
    }
}
