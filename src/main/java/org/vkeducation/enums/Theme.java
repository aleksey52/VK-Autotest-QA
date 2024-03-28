package org.vkeducation.enums;

public enum Theme {

    LIGHT("Светлая"),
    DARK("Тёмная");

    private final String title;

    Theme(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
