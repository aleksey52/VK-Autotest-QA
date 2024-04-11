package org.vkeducation.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final By loginField = By.xpath("//input[@name='st.email']");
    private final By passwordField = By.xpath("//input[@name='st.password']");
    private final By submitButton = By.xpath("//input[@data-l='t,sign_in']");
    private final By errorMessage = By.xpath("//div[@class='input-e login_error']");

    public LoginPage() {
        openPage();
        checkPage();
    }

    @Override
    public void checkPage() {
        $(loginField)
                .shouldBe(visible.because("loginField should be visible on the LoginPage"));
        $(passwordField)
                .shouldBe(visible.because("passwordField should be visible on the LoginPage"));
        $(submitButton)
                .shouldBe(visible.because("submitButton should be visible on the LoginPage"));
    }

    public void login(String username, String password) {
        $(loginField)
                .shouldBe(visible.because("loginField should be visible on the LoginPage"))
                .setValue(username);
        $(passwordField)
                .shouldBe(visible.because("passwordField should be visible on the LoginPage"))
                .setValue(password);
        $(submitButton)
                .shouldBe(visible.because("passwordField should be visible on the LoginPage"))
                .click();
    }

    public boolean errorMessageIsDisplayed() {
        return $(errorMessage).isDisplayed();
    }

    public void verifySuccessfulLogin() {
        $(passwordField)
                .shouldBe(hidden.because("passwordField should be hidden after login"));
    }
}
