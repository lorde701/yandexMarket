import org.junit.Test;
import ru.company.autotests.steps.*;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Иванка on 29.10.2017.
 */
public class MarketTest extends BaseSteps{
    @Test
    @Title("Поиск товара на Яндекс.Маркете")
    public void TestYandexMarket() {
        MainSteps mainPageSteps = new MainSteps();
        MainMarketSteps mainMarketSteps = new MainMarketSteps();
        SearchProductsSteps searchProductsSteps = new SearchProductsSteps();
        AllFiltersSteps allFiltersSteps = new AllFiltersSteps();
        SearchProductsWithFiltersSteps searchProductsWithFiltersSteps = new SearchProductsWithFiltersSteps();
        FindedProductSteps findedProductSteps = new FindedProductSteps();


        mainPageSteps.clickOnButton("Маркет");

        mainMarketSteps.clickGeneralSec("Электроника");
        mainMarketSteps.clickElectronicSection("Телевизоры");

        searchProductsSteps.goToAllFilters();

        allFiltersSteps.setMinPrice("20000");
        allFiltersSteps.clickManufacturer("Samsung");
        allFiltersSteps.clickManufacturer("LG");
        allFiltersSteps.clickButton("Показать подходящие");

        searchProductsWithFiltersSteps.checkProductAmount(12);
        searchProductsWithFiltersSteps.memberFirstProduct();
        searchProductsWithFiltersSteps.findRemeberedProduct(BaseSteps.firstProductName);

        findedProductSteps.checkSavedAndFindedNames();
    }

}
