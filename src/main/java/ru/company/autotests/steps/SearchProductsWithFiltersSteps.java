package ru.company.autotests.steps;

import org.junit.Assert;
import ru.company.autotests.pages.SearchProductsWithFiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class SearchProductsWithFiltersSteps {

    SearchProductsWithFiltersPage page = new SearchProductsWithFiltersPage();

    @Step("на странице {0} элементов")
    public void checkProductAmount(Integer expectedAmount) {
        Integer realCount = page.getProductCount();
        Assert.assertEquals(expectedAmount, realCount);
    }

    @Step("первый элемент списка запомнен")
    public void memberFirstProduct() {
        page.getFirstElementName();
    }

    @Step("в поисковую строку ввести значение {0} и нажать \"Найти\"")
    public void findRemeberedProduct(String productName) {
        page.fillFieldForFind(productName);
        page.clickFindButton();

    }
}
