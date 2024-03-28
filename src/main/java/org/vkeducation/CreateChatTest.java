package org.vkeducation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vkeducation.pages.HomePage;
import org.vkeducation.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateChatTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        open(BASE_URL);
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
    }

    @Test
    public void testCreateEmptyChat() {
        homePage.createEmptyChat();
        sleep(500);
        assertTrue(homePage.getEmptyMessageField().isDisplayed());
    }
}
