package guru.qa.classWork;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int PULL_REQUEST = 91;

    @Test
    void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий: " + REPOSITORY, () -> {
            $("[aria-label = 'Search or jump to…']").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозиторя", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Кликаем по вкладке Pull requests", () -> {
            $("[data-content='Pull requests']").click();
        });
        step("Проверяем наличие Pull requests с номером" + PULL_REQUEST, () -> {
            $(withText("#" + PULL_REQUEST)).should(Condition.exist);
        });
    }

    @Test
    void testAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPaige();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLInk(REPOSITORY);
        steps.openPullRequestTab();
        steps.checkPullRequestWithNumber(PULL_REQUEST);

    }
}
