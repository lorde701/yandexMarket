package ru.company.autotests.steps;

import ru.company.autotests.pages.MainMarketPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 29.10.2017.
 */
public class MainMarketSteps extends BaseSteps{
    MainMarketPage mainMarketPage = new MainMarketPage();

    @Step("произошло нажатие на кнопку {0}")
    public void clickGeneralSec(String sectionName) {
        mainMarketPage.chooseSection(sectionName);
    }

    @Step("произошло нажатие на кнопку {0}")
    public void clickElectronicSection(String electronicSectionName) {
        mainMarketPage.chooseElectronicSections(electronicSectionName);
    }
}
