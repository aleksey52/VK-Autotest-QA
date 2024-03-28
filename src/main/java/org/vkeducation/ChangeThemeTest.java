package org.vkeducation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vkeducation.enums.Theme;
import org.vkeducation.pages.HomePage;
import org.vkeducation.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class ChangeThemeTest extends BaseTest{

    private HomePage homePage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        open(BASE_URL);
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
    }

    @Test
    public void testSetupLightTheme() {
        homePage.setupTheme(Theme.LIGHT);
        sleep(500);
        assertTrue(homePage.getThemeChangeButton().getText().contains(Theme.LIGHT.getTitle()));
    }

    @Test
    public void testSetupDarkTheme() {
        homePage.setupTheme(Theme.DARK);
        sleep(500);
        assertTrue(homePage.getThemeChangeButton().getText().contains(Theme.DARK.getTitle()));
    }
}
