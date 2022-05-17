package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SimpleTests {

     /*
    @BeforeAll
    static void openPage() {
        Configuration.browserSize = "1920x1080";
        open("https://biocad.ru");

            @BeforeEach
    void preconditionBrowser() {
        baseUrl = "https://biocad.ru";
        browserSize = "1920x1080";
    }
    }

      */

     /*
    @AfterEach
    void closeBrowser() { closeWebDriver();}
    */

    @AfterAll
    public static void afterAll() {
        closeWebDriver();
    }

     /*
    @AfterEach
    void closeBrowser() { closeWebDriver();}
    */


    @Tag("siteTests")
    @DisplayName("Проверка текстов на странице Кабинет")
    @Test
    void expectTextTest() {
        open("https://kabinet.dreamkas.ru/");
        $(".lg-banner__lead").shouldHave(text("Помогает отслеживать продажи"));
        $(byText("Откройте новые возможности вашей кассы")).shouldBe(visible, Duration.ofSeconds(10));
        $$(".lg-registration__text").find(text("Зарегистрируйтесь в Кабинете Дримкас, подключите кассу и отслеживайте работу магазина в реальном времени")).shouldBe(visible, Duration.ofSeconds(10));
        $(By.linkText("Посмотреть документацию к API")).shouldBe(visible, Duration.ofSeconds(10));
        //$(By.linkText("Посмотреть 1 документацию 1 к 1 API")).shouldBe(visible, Duration.ofSeconds(10)); //negative test
    }



}
