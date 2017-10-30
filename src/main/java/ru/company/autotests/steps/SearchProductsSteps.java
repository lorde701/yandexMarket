package ru.company.autotests.steps;

import ru.company.autotests.pages.SearchProductsPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class SearchProductsSteps extends BaseSteps {
    @Step("переход к расширенному поиску")
    public void goToAllFilters(){
        new SearchProductsPage().goToAllFilters();
    }
}
