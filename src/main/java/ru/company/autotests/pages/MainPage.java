package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.company.autotests.steps.BaseSteps;

/**
 * Created by Иванка on 29.10.2017.
 */
public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class='home-tabs i-bem dropdown-menu home-tabs_js_inited']")
    WebElement sectionWithButtons;

    public void clickOnButton(String buttonName) {
        WebDriver driver = BaseSteps.getDriver();
        WebElement element = sectionWithButtons;
        element = element.findElement(By.xpath("./a[text()='" + buttonName + "']"));
        element.click();
        //sectionWithButtons.findElement(By.xpath(".a[text()='" + buttonName + "']")).click();
    }

}
