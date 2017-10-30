package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.company.autotests.steps.BaseSteps;

/**
 * Created by Иванка on 30.10.2017.
 */
public class AllFiltersPage extends BasePage {

    @FindBy(name = "glf-pricefrom-var")
    WebElement priceFromInput;

    @FindBy(xpath = "//*[@class='n-filter-block__list-items i-bem']")
    WebElement manufacturerList;

    @FindBy(xpath = "//*[@class='n-filter-panel-extend__button-bar']")
    WebElement panelButton;



    public void fillPriceFrom(String price) {
        fillField(priceFromInput, price);
    }

    public void chooseManufacturer(String value) {
        manufacturerList.findElement(By.xpath("./descendant::label[text()='" + value + "']")).click();
    }

    public void clickButton(String buttonName) {
        WebElement element = panelButton.findElement(By.xpath("./descendant::span[text()='" + buttonName + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(element).click().perform();
    }



}
