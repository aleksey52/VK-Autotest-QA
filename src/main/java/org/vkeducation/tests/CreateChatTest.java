package org.vkeducation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.vkeducation.pages.HomePage;
import org.vkeducation.pages.LoginPage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateChatTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void init() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        homePage = new HomePage();
    }

    @Test
    @Tag("AutoTest")
    @Tag("HomePage")
    @DisplayName("Create Empty Chat Test")
    public void testCreateEmptyChat() {
        homePage.createEmptyChat();
        sleep(500);
        assertTrue(homePage.emptyMessageFieldIsDisplayed(),
                "After the chat has been successfully created, an empty message input field should appear");
    }
}
