package org.selenide.examples.selenoid;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SelenoidExtension.class)
class WebdriverTest {

    @Test
    void checkBrowserVersionTest() {

        WebDriver driver = WebDriverRunner.getAndCheckWebDriver();

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName();
        String browserVersion = cap.getBrowserVersion();

        System.out.println("B: " + browserName + " V: " + browserVersion);

        assertThat(browserName).contains("chrome");

        if (WebDriverRunner.hasWebDriverStarted()) {

            System.out.println("Close webdriver...");
            Selenide.closeWebDriver();
        }

        //driver.quit();
    }
}
