package ru.company.autotests.steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.company.autotests.util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иванка on 29.10.2017.
 */
public class BaseSteps {
    public static String firstProductName;

    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() {
        baseUrl = properties.getProperty("app.url");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
