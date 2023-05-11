package com.kuryaevao.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.browserSize = "3840×2160";
        Configuration.pageLoadTimeout = 600000;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
