package Examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class SimpleTestsStep1 {

    @Test
    //@Tags({@Tag("siteTests"), @Tag("siteTests2") }) //если тэгов много
    //@Tag("siteTests")
    @DisplayName("Проверка текстов на стр. Кабинет")
    void expectTextTest0() {
        open("https://kabinet.dreamkas.ru/");
        $(".lg-banner__lead").shouldHave(text("Помогает отслеживать продажи"));
        $(byText("Откройте новые возможности вашей кассы")).shouldBe(visible, Duration.ofSeconds(10));
        $$(".lg-registration__text").find(text("Зарегистрируйтесь в Кабинете Дримкас, подключите кассу и отслеживайте работу магазина в реальном времени")).shouldBe(visible, Duration.ofSeconds(10));
        $(By.linkText("Посмотреть документацию к API")).isDisplayed();
    }

    @Test
    //@Tag("siteTests")
    @DisplayName("Отправки формы (заполнены не все поля)")
    void fillFormTest0() {
        open("https://kabinet.dreamkas.ru/");
        $(byText("Откройте новые возможности вашей кассы")).shouldBe(visible, Duration.ofSeconds(10));
        $(By.name("name")).setValue("Test");
        $(By.name("login")).setValue("ok@dex.ru");
        $(By.name("password")).setValue("pass");
        //$(By.name("confirmPassword")).setValue("pass"); // ! намеренно не заполняю обязательное поле
        $("button.lk-dialog-form__button").click(); // отправить
        //Expect (окно предупреждения) :
        $$(".md-input-message-animation").find(text("Заполните это поле")).shouldBe(visible, Duration.ofSeconds(10));
        //$$(".md-input-message-animation").find(text("Тра ля ля")).shouldBe(visible, Duration.ofSeconds(10)); //negative test
        //sleep(Long.parseLong("5000"));
    }
}