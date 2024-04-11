package org.vkeducation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.vkeducation.pages.MessagePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateChatTest extends BaseTest {

    private MessagePage messagePage;

    @BeforeEach
    public void init() {
        messagePage = new MessagePage(VALID_USERNAME, VALID_PASSWORD);
    }

    @Test
    @Tag("AutoTest")
    @Tag("MessagePage")
    @DisplayName("Create Empty Chat Test")
    public void testCreateEmptyChat() {
        messagePage.createEmptyChat();
        sleep(500);
        assertTrue(messagePage.messageFieldIsDisplayed(),
                "After the chat has been successfully created, an empty message input field should appear");
    }
}
