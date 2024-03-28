package org.vkeducation.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginField = $(By.xpath("//input[@name='st.email']"));
    private final SelenideElement passwordField = $(By.xpath("//input[@name='st.password']"));
    private final SelenideElement submitButton = $(By.xpath("//input[@data-l='t,sign_in']"));
    private final SelenideElement errorMessage = $(By.xpath("//div[@class='input-e login_error']"));

    public void login(String username, String password) {
        loginField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        submitButton.shouldBe(visible).click();
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public void verifySuccessfulLogin() {
        passwordField.shouldBe(hidden);
    }
}
