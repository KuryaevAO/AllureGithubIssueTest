package com.kuryaevao.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepsGithubIssueTest extends TestBase {

    String REPOSITORY = "kuryaevao/";

    @Test
    void LambdaStepsFindIssueTest() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Наводимся на поле поиска", () -> {
            $(".header-search-input").click();
        });

        step("Вбиваем наш запрос", () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
        });

        step("Подтверждаем наш запрос", () -> {
            $(".header-search-input").submit();
        });

        step("Проверяем, что вывелись результаты поиска", () -> {
            $(".codesearch-results").shouldHave(text("repository results"));
        });

        step("Кликаем на проект CharactersLotR", () -> {
            $$("ul.repo-list li a").findBy(text("/CharactersLotR")).click();
        });

        step("Проверяем, что мы провалились в нужный проект", () -> {
            $("#repository-container-header strong").$("a").shouldHave(text("CharactersLotR"));
        });

        step("Открываем Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Проверяем, что мы попали в Issues", () -> {
            $(".container-md h3").shouldHave(text("Welcome to issues!"));
        });

    }
}
