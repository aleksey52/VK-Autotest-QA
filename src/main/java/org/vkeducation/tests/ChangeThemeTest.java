package org.vkeducation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.vkeducation.enums.Theme;
import org.vkeducation.pages.HomePage;
import org.vkeducation.pages.LoginPage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeThemeTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void init() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        homePage = new HomePage();
    }

    @ParameterizedTest
    @EnumSource(Theme.class)
    @Tag("AutoTest")
    @Tag("HomePage")
    @DisplayName("Setup Light Theme Test")
    public void testSetupLightTheme(Theme theme) {
        homePage.setupTheme(theme);
        sleep(500);
        final String buttonText = homePage.getTextOfThemeChangeButton();
        final String expectedTitle = theme.getTitle();
        assertTrue(buttonText.contains(expectedTitle),
                "The theme change button should contain title of the current theme: " + theme.getTitle());
    }
}
