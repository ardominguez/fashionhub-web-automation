package com.fashionhub.fwk.web.factory;

import lombok.Getter;

@Getter
public enum BrowserEnum {

    CHROME("Chrome", "chromium", "chrome"),
    EDGE("Edge", "chromium", "msedge"),
    FIREFOX("Firefox", "firefox", "firefox"),
    WEBKIT("Webkit", "webkit", "webkit");

    private final String name;
    private final String engine;
    private final String channel;

    BrowserEnum(String name, String engine, String channel) {
        this.name = name;
        this.engine = engine;
        this.channel = channel;
    }

    public static BrowserEnum fromName(String browserName) {
        return switch (browserName) {
            case "Edge" -> EDGE;
            case "Firefox" ->  FIREFOX;
            case "Webkit" -> WEBKIT;
            default -> CHROME;
        };
    }
}
