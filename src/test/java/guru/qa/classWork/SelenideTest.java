package guru.qa.classWork;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    void issueSearch(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com/");
        $("[aria-label = 'Search or jump to…']").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("[data-content='Pull requests']").click();
        $(withText("#91")).should(Condition.exist);
       // $(withText("#91")).should(Condition.id("15"));  // делаем негативный тест

    }
}
