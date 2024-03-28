package org.vkeducation;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

abstract public class BaseTest {

    public static final String BASE_URL = "https://ok.ru/";
    public static final String VALID_USERNAME = "technopol35";
    public static final String VALID_PASSWORD = "technopolisPassword";
    public static final String INVALID_USERNAME = "invalid_username";
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String EMPTY_STRING = "";

    @BeforeEach
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.baseUrl = BASE_URL;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
