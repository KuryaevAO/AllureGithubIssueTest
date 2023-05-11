package com.kuryaevao.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubIssueTest extends TestBase {

    String REPOSITORY = "kuryaevao/";

    @Test
    void FindIssueTest() {

        open("https://github.com/");
        $(".header-search-input").click();//наводимся на поле поиска
        $(".header-search-input").sendKeys(REPOSITORY);//вбиваем наш запрос
        $(".header-search-input").submit();//подтверждаем наш запрос
        $(".codesearch-results").shouldHave(text("repository results"));//проверяем, что вывелись результаты поиска
        $$("ul.repo-list li a").findBy(text("/CharactersLotR")).click();// кликаем на проект CharactersLotR
        $("#repository-container-header strong").$("a").shouldHave(text("CharactersLotR"));//проверяем, что мы провалились в нужный проект
        $(By.partialLinkText("Issues")).click();//открываем Issues
        $(".container-md h3").shouldHave(text("Welcome to issues!"));//проверяем, что мы попали в Issues
    }
}
