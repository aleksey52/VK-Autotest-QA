package org.vkeducation.pages;

import org.openqa.selenium.By;
import org.vkeducation.enums.Theme;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private final By topPanelLeftCorner = By.xpath("//*[@id='topPanelLeftCorner']");
    private final By userSettingsDropdownMenuButton = By.xpath("//button[@aria-controls='user-dropdown-menu']");
    private final By themeChangeButton = By.xpath("//li[@data-l='t,themes_switcher']");
    private final By lightThemeButton = By.xpath("//li[@data-l='t,theme_light']");
    private final By darkThemeButton = By.xpath("//li[@data-l='t,theme_dark']");
    private final By messageButton = By.xpath("//button[@id='msg_toolbar_button']");
    private final By messageSettingsButton = By.xpath("//*[@data-tsid='msg_settings_button']");
    private final By createMenuButton = By.xpath("//button[@data-l='t, createMenu']");
    private final By createChatButton = By.xpath("//msg-menu[@id='msg-new-menu']/slot/msg-menu-item");
    private final By finishCreateChatButton = By.xpath("//button[@data-tsid='finish_create_chat_button']");
    private final By emptyMessageField = By.xpath("//msg-input[@data-tsid='write_msg_input']");

    public HomePage() {
        openPage();
        checkPage();
    }

    @Override
    public void checkPage() {
        $(topPanelLeftCorner)
                .shouldBe(visible.because("topPanelLeftCorner should be visible on the HomePage"));
        $(userSettingsDropdownMenuButton)
                .shouldBe(visible.because("userSettingsDropdownMenuButton should be visible on the HomePage"));
        $(messageButton)
                .shouldBe(visible.because("messageButton should be visible on the HomePage"));
    }

    public void openUserSettingsDropdownMenu() {
        $(userSettingsDropdownMenuButton)
                .shouldBe(visible.because("userSettingsDropdownMenuButton should be visible on the HomePage"))
                .click();
    }

    public void setupTheme(Theme theme) {
        openUserSettingsDropdownMenu();
        $(themeChangeButton)
                .shouldBe(visible.because("userSettingsDropdownMenuButton should be visible on the HomePage after open UserSettingsDropdownMenu"))
                .click();

        switch (theme) {
            case LIGHT -> $(lightThemeButton)
                    .shouldBe(visible.because("lightThemeButton should be visible in theme change menu"))
                    .click();
            case DARK -> $(darkThemeButton)
                    .shouldBe(visible.because("darkThemeButton should be visible in theme change menu"))
                    .click();
        }
    }

    public String getTextOfThemeChangeButton() {
        $(userSettingsDropdownMenuButton)
                .shouldBe(visible.because("userSettingsDropdownMenuButton should be visible on the HomePage"))
                .click();

        return $(themeChangeButton).getText();
    }

    public void createEmptyChat() {
        $(messageButton)
                .shouldBe(visible.because("messageButton should be visible on the HomePage"))
                .click();
        $(messageSettingsButton)
                .shouldBe(visible.because("messageSettingsButton should be visible after click messageButton"))
                .click();
        $(createMenuButton)
                .shouldBe(visible.because("createMenuButton should be visible on chat menu"))
                .click();
        $(createChatButton)
                .shouldBe(visible.because("createChatButton should be visible on creating chat page"))
                .click();
        $(finishCreateChatButton)
                .shouldBe(visible.because("finishCreateChatButton should be visible on creating chat page"))
                .click();
    }

    public boolean emptyMessageFieldIsDisplayed() {
        return $(emptyMessageField).isDisplayed();
    }
}
