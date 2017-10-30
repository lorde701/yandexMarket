package ru.company.autotests.steps;

import org.junit.Assert;
import ru.company.autotests.pages.BasePage;
import ru.company.autotests.pages.FindedProductPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class FindedProductSteps {

    @Step("наименование найденного товара соответствует названию сохраненного")
    public void checkSavedAndFindedNames() {
        FindedProductPage page = new FindedProductPage();
        String realName = page.getProductName();
        String expectedName = BaseSteps.firstProductName;
        Assert.assertEquals(expectedName, realName);
    }
}
