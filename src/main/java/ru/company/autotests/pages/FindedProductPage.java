package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.company.autotests.steps.BaseSteps;

/**
 * Created by Иванка on 30.10.2017.
 */
public class FindedProductPage extends BasePage {
    @FindBy(xpath = "//h1")
    WebElement productName;

    public String getProductName(){
        WebElement element = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'n-title__text']"));
        return element.getText();
    }
}
