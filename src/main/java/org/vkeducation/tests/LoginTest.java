package org.vkeducation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vkeducation.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @BeforeEach
    public void init() {
        loginPage = new LoginPage();
    }

    @Test
    @Tag("AutoTest")
    @Tag("LoginPage")
    @DisplayName("Login Invalid Credentials Test")
    public void testLoginInvalidCredentials() {
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        assertTrue(loginPage.errorMessageIsDisplayed(),
                "If credentials is invalid, an error message should appear");
    }

    @Test
    @Tag("AutoTest")
    @Tag("LoginPage")
    @DisplayName("Login Empty Username Test")
    public void testLoginEmptyUsername() {
        loginPage.login(EMPTY_STRING, VALID_PASSWORD);
        assertTrue(loginPage.errorMessageIsDisplayed(),
                "If username is empty, an error message should appear");
    }

    @Test
    @Tag("AutoTest")
    @Tag("LoginPage")
    @DisplayName("Login Empty Password Test")
    public void testLoginEmptyPassword() {
        loginPage.login(VALID_USERNAME, EMPTY_STRING);
        assertTrue(loginPage.errorMessageIsDisplayed(),
                "If password is empty, an error message should appear");
    }

    @Test
    @Tag("AutoTest")
    @Tag("LoginPage")
    @DisplayName("Successful Login Test")
    public void testSuccessfulLogin() {
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        loginPage.verifySuccessfulLogin();
        logger.info("Successful login to the account, the password field has become hidden");
    }
}
