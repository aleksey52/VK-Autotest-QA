package org.vkeducation.pages;

import static com.codeborne.selenide.Selenide.open;

abstract public class BasePage {

    public static final String BASE_URL = "https://ok.ru/";

    public void openPage() {
        open(BASE_URL);
    }

    public abstract void checkPage();
}
