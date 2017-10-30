package ru.company.autotests.util;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.company.autotests.steps.BaseSteps;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.junit.AllureRunListener;
/**
 * Created by Иванка on 29.10.2017.
 */
public class NewAllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure) {
        takeScreenshot();
        super.testFailure(failure);
    }
    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
