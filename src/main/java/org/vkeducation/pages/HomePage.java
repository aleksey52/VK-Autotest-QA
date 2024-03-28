package org.vkeducation.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.vkeducation.enums.Theme;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final SelenideElement userSettingsDropdownMenuButton = $(By.xpath("//button[@aria-controls='user-dropdown-menu']"));
    private final SelenideElement themeChangeButton = $(By.xpath("//li[@data-l='t,themes_switcher']"));
    private final SelenideElement lightThemeButton = $(By.xpath("//li[@data-l='t,theme_light']"));
    private final SelenideElement darkThemeButton = $(By.xpath("//li[@data-l='t,theme_dark']"));
    private final SelenideElement messageButton = $(By.xpath("//button[@id='msg_toolbar_button']"));
    private final SelenideElement messageSettingsButton = $(By.xpath("//*[@data-tsid='msg_settings_button']"));
    private final SelenideElement createMenuButton = $(By.xpath("//button[@data-l='t, createMenu']"));
    private final SelenideElement createChatButton = $(By.xpath("//msg-menu[@id='msg-new-menu']/slot/msg-menu-item"));
    private final SelenideElement finishCreateChatButton = $(By.xpath("//button[@data-tsid='finish_create_chat_button']"));
    private final SelenideElement emptyMessageField = $(By.xpath("//msg-input[@data-tsid='write_msg_input']"));

    public void openUserSettingsDropdownMenu() {
        userSettingsDropdownMenuButton.shouldBe(visible).click();
    }

    public void setupTheme(Theme theme) {
        openUserSettingsDropdownMenu();
        themeChangeButton.shouldBe(visible).click();

        switch (theme) {
            case LIGHT -> lightThemeButton.shouldBe(visible).click();
            case DARK -> darkThemeButton.shouldBe(visible).click();
        }
    }

    public SelenideElement getThemeChangeButton() {
        userSettingsDropdownMenuButton.shouldBe(visible).click();

        return themeChangeButton;
    }

    public void createEmptyChat() {
        messageButton.shouldBe(visible).click();
        messageSettingsButton.shouldBe(visible).click();
        createMenuButton.shouldBe(visible).click();
        createChatButton.shouldBe(visible).click();
        finishCreateChatButton.shouldBe(visible).click();
    }

    public SelenideElement getEmptyMessageField() {
        return emptyMessageField;
    }
}
