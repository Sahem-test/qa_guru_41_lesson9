package guru.qa.classWork;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class LabelsTest {



    @Test
    @Feature("Issue, в репозитории")
    @Story("Создание Issue")
    @Owner("RozhkovAA")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Создание Issue для авторизированного пользователя")
    void testStaticLabels() {

    }

    @Test
    void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(t ->
                t.setName("Создание Issue для авторизированного пользователя"));
        Allure.feature("Issue, в репозитории");
        Allure.story("Создание Issue");
        Allure.label("Owner","RozhkovAA");
        Allure.label("Severity",SeverityLevel.CRITICAL.value());
        Allure.link("Testing","https://github.com/");
    }
}
