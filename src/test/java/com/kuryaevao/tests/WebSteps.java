package com.kuryaevao.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {REPOSITORY}")
    public void searchForRepository(String REPOSITORY) {
        $(".header-search-input").click();

        $(".header-search-input").sendKeys(REPOSITORY);

        $(".header-search-input").submit();
    }

    @Step("Проверяем, что вывелись результаты поиска")
    public void checkResults() {
        $(".codesearch-results").shouldHave(text("repository results"));
    }

    @Step("Кликаем на проект CharactersLotR")
    public void selectProject() {
        $$("ul.repo-list li a").findBy(text("/CharactersLotR")).click();
    }

    @Step("Проверяем, что мы провалились в нужный проект")
    public void checkProject() {
        $("#repository-container-header strong").$("a").shouldHave(text("CharactersLotR"));
    }

    @Step("Открываем Issues")
    public void openIssues() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что мы попали в Issues")
    public void checkIssues() {
        $(".container-md h3").shouldHave(text("Welcome to issues!"));
    }
}