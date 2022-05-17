package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class KabinetPage {
    // components

    // locators
    //$("#name")
    SelenideElement nameInput = $("#name");

    // actions
    //.setValue("Test Name");
    public void setName(String name) {
        nameInput.setValue(name);
    }

}