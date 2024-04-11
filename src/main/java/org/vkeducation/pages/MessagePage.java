package org.vkeducation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MessagePage extends BasePage {

    private final By messageSettingsButton = By.xpath("//*[@data-tsid='msg_settings_button']");
    private final By messageSearchButton = By.xpath("//msg-icon[@icon='search']");
    private final By messageSearchField = By.xpath("//input[@data-tsid='chat-search-input']");
    private final By createMenuButton = By.xpath("//button[@data-l='t, createMenu']");
    private final By createChatButton = By.xpath("//msg-menu[@id='msg-new-menu']/slot/msg-menu-item");
    private final By finishCreateChatButton = By.xpath("//button[@data-tsid='finish_create_chat_button']");
    private final By emptyMessageField = By.xpath("//msg-input[@data-tsid='write_msg_input']");
    private final By openSmilesButton = By.xpath("//button[@data-tsid='open_smiles_button']");
    private final By stickerConstructorMenu = By.xpath("//li[@data-tsid='sticker-constructor-menu']");
    private final By userStickerInput = By.xpath("//msg-input[@data-tsid='user-sticker-input']");
    private final By sendOwnStickerButton = By.xpath("//*[@key='send-own-sticker']");
    private final By stickerInMessage = By.xpath("//msg-sticker[@data-tsid='sticker_in_message']");

    public MessagePage(String username, String password) {
        final HomePage homePage = new HomePage(username, password);
        homePage.openMessagePage();
        checkPage();
    }

    @Override
    public void checkPage() {
        $(messageSettingsButton)
                .shouldBe(visible.because("messageSettingsButton should be visible on MessagePage"));
        $(messageSearchButton)
                .shouldBe(visible.because("messageSearchButton should be visible on MessagePage"));
        $(messageSearchField)
                .shouldBe(visible.because("messageSearchField should be visible on MessagePage"));
        $(createMenuButton)
                .shouldBe(visible.because("createMenuButton should be visible on MessagePage"));
    }

    public void createEmptyChat() {
        $(messageSettingsButton)
                .shouldBe(visible.because("messageSettingsButton should be visible on MessagePage"))
                .click();
        $(createMenuButton)
                .shouldBe(visible.because("createMenuButton should be visible on MessagePage"))
                .click();
        $(createChatButton)
                .shouldBe(visible.because("createChatButton should be visible on creating chat page"))
                .click();
        $(finishCreateChatButton)
                .shouldBe(visible.because("finishCreateChatButton should be visible on creating chat page"))
                .click();
    }

    public boolean messageFieldIsDisplayed() {
        return $(emptyMessageField).isDisplayed();
    }

    public void sendCustomSticker(String text) {
        $(openSmilesButton)
                .shouldBe(visible.because("openSmilesButton should be visible in chat"))
                .click();
        sleep(500);
        $(stickerConstructorMenu)
                .shouldBe(visible.because("stickerConstructorMenu should be visible in smiles menu"))
                .click();
        $(userStickerInput)
                .shouldBe(visible.because("userStickerInput should be visible in smiles menu"));
        final Actions actions = new Actions(getWebDriver());
        actions.sendKeys($(userStickerInput), text).perform();
        $(sendOwnStickerButton)
                .shouldBe(visible.because("sendOwnStickerButton should be visible in smiles menu"))
                .click();
        sleep(1500);
    }

    public boolean stickerInMessageIsDisplayed() {
        return $(stickerInMessage).isDisplayed();
    }
}
