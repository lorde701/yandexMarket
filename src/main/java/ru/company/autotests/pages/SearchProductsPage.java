package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Иванка on 29.10.2017.
 */
public class SearchProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='n-filter-panel-aside__content']")
    WebElement searchSettings;

    public void goToAllFilters(){
        WebElement element = searchSettings.findElement(By.xpath("//./descendant::*[text()='Перейти ко всем фильтрам']"));
        click(element);
    }
}
