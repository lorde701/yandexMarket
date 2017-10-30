package ru.company.autotests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.company.autotests.steps.BaseSteps;
import java.util.ArrayList;

/**
 * Created by Иванка on 29.10.2017.
 */
public class MainMarketPage extends BasePage{

//    @FindBy(xpath = "//ul[@class='topmenu__list']")
//    WebElement generalSections;
//
//    @FindBy(xpath = "//ul[@class='topmenu__list']")
//    WebElement electronicSections;

    WebDriver driver = BaseSteps.getDriver();
    String[] xp2 = new String[3];
    private ArrayList<String> xpathGeneralSeletion = new ArrayList<>();
    private ArrayList<String> xpathElectricSection = new ArrayList<>();

    private static final String GENERAL_SECTION = "//ul[@class='topmenu__list']/descendant::a[text()='%s']";
    private static final String GENERAL_SECTION_ALTERNATIVE = "//div[@class='n-topmenu-new-horizontal__links']/descendant::a[text()='%s']";
    private static final String GENERAL_SECTION_ALTERNATIVE2 = "//div[@class='n-navigation-vertical i-bem n-navigation-vertical_js_inited']/descendant::span[text()='%s']";

    private static final String ELECTRIC_SELECTION = "//ul[@class='topmenu__list']/descendant::a[text()='%s']";
    private static final String ELECTRIC_SELECTION_ALTERNATIVE = "//div[@class='n-topmenu-new-horizontal__links']/descendant::a[text()='%s']";
    private static final String ELECTRIC_SELECTION_ALTERNATIVE2 = "//div[@class='n-navigation-vertical-menu__column-container']/descendant::a[text()='%s']";



    public void chooseSection(String sectionName) {
        xpathGeneralSeletion.add(GENERAL_SECTION);
        xpathGeneralSeletion.add(GENERAL_SECTION_ALTERNATIVE);
        xpathGeneralSeletion.add(GENERAL_SECTION_ALTERNATIVE2);

        xp2[0] = GENERAL_SECTION;
        xp2[1] = GENERAL_SECTION_ALTERNATIVE;
        xp2[2] = GENERAL_SECTION_ALTERNATIVE2;

        WebElement element = getExistGeneralElement(xp2, sectionName);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void chooseElectronicSections(String electronicSectionName) {
        xpathElectricSection.add(ELECTRIC_SELECTION);
        xpathElectricSection.add(ELECTRIC_SELECTION_ALTERNATIVE);
        xpathElectricSection.add(ELECTRIC_SELECTION_ALTERNATIVE2);
        WebElement element = getExistElectricalElement(xpathElectricSection, electronicSectionName);
        scrollAndWaitToBeVisible(element);
        element.click();
    }
    private WebElement getExistGeneralElement(String[] xpath, String selectName) {
        for (int i = 0; i < xpath.length; ++i) {
            try {
                if (i == xpath.length - 1) {
                    WebElement element = driver.findElement(By.xpath("//button/span[text()='Все категории']"));
                    scrollAndWaitToBeClickable(element);
                    //Thread.sleep(5000);
                    String script = "var object = arguments[0];"
                            + "var theEvent = document.createEvent(\"MouseEvent\");"
                            + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                            + "object.dispatchEvent(theEvent);"
                            ;

                    ((JavascriptExecutor)driver).executeScript(script, element);
                }
                return driver.findElement(By.xpath(String.format(xpath[i], selectName)));
            } catch (NoSuchElementException e) {
                System.out.println("Элемент с xpath-ом: " + i + " и параметром: " + selectName + " не найден");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private WebElement getExistElectricalElement(ArrayList<String> xpath, String selectName) {
        for (String i : xpath) {
            try {
                return driver.findElement(By.xpath(String.format(i, selectName)));
            } catch (NoSuchElementException e) {
                System.out.println("Элемент с xpath-ом: " + i + " и параметром: " + selectName + " не найден");
            }
        }
        return null;
    }
//        try {
//            System.out.println("xpath1:  " + xpath1 + "  name: " + selectName);
//            return driver.findElement(By.xpath(String.format(xpath1, selectName)));
//        } catch (NoSuchElementException e) {
//
//
//            System.out.println("xpath2:  " + xpath2 + "  name: " + selectName);
//            return driver.findElement(By.xpath(String.format(xpath2, selectName)));
//        }
//    }
}
