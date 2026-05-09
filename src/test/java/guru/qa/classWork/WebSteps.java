package guru.qa.classWork;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPaige() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий: {repo} ")
    public void searchForRepository(String repo) {
        $("[aria-label = 'Search or jump to…']").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке репозиторя")
    public void clickOnRepositoryLInk(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Кликаем по вкладке Pull requests")
    public void openPullRequestTab() {
        $("[data-content='Pull requests']").click();
    }

    @Step("Проверяем наличие Pull requests с номером: {number}")
    public void checkPullRequestWithNumber(int number) {
        $(withText("#" + number)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
