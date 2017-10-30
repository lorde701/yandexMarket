package ru.company.autotests.steps;

import ru.company.autotests.pages.AllFiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class AllFiltersSteps extends BaseSteps {
    AllFiltersPage allFiltersPage = new AllFiltersPage();

    @Step("задана минимальная сумма - {0}")
    public void setMinPrice(String price) {
        allFiltersPage.fillPriceFrom(price);
    }

    @Step("производитель {0} выбран")
    public void clickManufacturer(String value) {
        allFiltersPage.chooseManufacturer(value);
    }

    @Step("кнопка {0} нажата")
    public void clickButton(String buttonName) {
        allFiltersPage.clickButton(buttonName);
    }
}
