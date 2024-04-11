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

    public HomePage(String username, String password) {
        final LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
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

    public void openMessagePage() {
        $(messageButton)
                .shouldBe(visible.because("messageButton should be visible on the HomePage"))
                .click();
    }
}
