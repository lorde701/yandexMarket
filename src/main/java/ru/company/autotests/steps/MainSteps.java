package ru.company.autotests.steps;

import ru.company.autotests.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 29.10.2017.
 */
public class MainSteps extends BaseSteps{

    @Step("нажата кнопка {0}")
    public void clickOnButton(String buttonName) {
        new MainPage().clickOnButton(buttonName);
    }
}
