package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.company.autotests.pages.BasePage;
import ru.company.autotests.steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иванка on 30.10.2017.
 */
public class SearchProductsWithFiltersPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 b-zone i-bem b-zone b-spy-visible b-spy-visible_js_inited')][1]/div[@class='n-snippet-card2__part n-snippet-card2__part_type_center']/div/div/a")
    WebElement firstProductName;

    @FindBy(id = "header-search")
    WebElement findProductInput;

    @FindBy(xpath = "//span[text()='Найти']")
    WebElement findButton;


    public Integer getProductCount() {
        List<WebElement> productList = BaseSteps.getDriver().findElements(By.xpath("//div[contains(@class,'n-snippet-card2 b-zone i-bem b-zone b-spy-visible b-spy-visible_js_inited')]"));
        return productList.size();
    }

    public void getFirstElementName() {
        BaseSteps.firstProductName = firstProductName.getText();
    }

    public void fillFieldForFind(String name) {
        fillField(findProductInput, name);
    }

    public void clickFindButton() {
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(findButton).click().perform();
    }


}
