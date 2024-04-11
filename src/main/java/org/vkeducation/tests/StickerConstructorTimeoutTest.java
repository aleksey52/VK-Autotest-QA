package org.vkeducation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.vkeducation.pages.MessagePage;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StickerConstructorTimeoutTest extends BaseTest {

    public static final String SHORT_STRING = "*";
    public static final int MAX_REPEAT_COUNT = 36;

    private MessagePage messagePage;

    @BeforeEach
    public void init() {
        messagePage = new MessagePage(VALID_USERNAME, VALID_PASSWORD);
    }

    @Test
    @Tag("AutoTest")
    @Tag("MessagePage")
    @DisplayName("Send Custom Sticker Test")
    public void testSendCustomSticker() {
        assertAll("short_text_for_custom_sticker",
                () -> assertTimeout(ofMillis(4500), () -> {
                    messagePage.createEmptyChat();
                    messagePage.sendCustomSticker(SHORT_STRING);
                }),
                () -> assertTrue(messagePage.stickerInMessageIsDisplayed(),
                        "The created sticker should be displayed in the chat")
        );

        assertAll("long_text_for_custom_sticker",
                () -> assertTimeout(ofMillis(4500), () -> {
                    messagePage.createEmptyChat();
                    messagePage.sendCustomSticker(SHORT_STRING.repeat(MAX_REPEAT_COUNT));
                }),
                () -> assertTrue(messagePage.stickerInMessageIsDisplayed(),
                        "The created sticker should be displayed in the chat")
        );
    }
}
