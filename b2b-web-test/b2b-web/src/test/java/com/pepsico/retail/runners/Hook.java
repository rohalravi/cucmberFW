/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.runners;

import static java.lang.Boolean.TRUE;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.annotation.PostConstruct;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.cucumber.java.Scenario;
//import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Hook {

    @Value("${selenium.browser}")
    private String browser;

    @Value("${selenium.browser.x}")
    private Integer length;

    @Value("${selenium.browser.y}")
    private Integer height;

    @Value("${selenium.browser.headless}")
    private Boolean headless;

    @Value("${selenium.browser.remote}")
    private String remote;

    @Value("${target.application.baseUrl}")
    private String baseUrl;

    private WebDriver driver;

    private WebDriverWait wait;
    private JavascriptExecutor js;

    @PostConstruct
    public void initialize() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (isDriverLoaded()) {
                log.info("Shutdown instruction observed: Opened browsers are being closed!");
                closeDriver();
                log.info("Opened drivers closed!");
            }
        }));
    }

    private boolean isDriverLoaded() {
        return driver != null;
    }

    public WebDriver getDriver() {
        if (isEmpty(driver)) {
            initialiseDriver();
        }
        return driver;
    }

    public String getBrowser() {
        if ("chrome".equalsIgnoreCase(browser)) {
            return browser;
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return browser;
        } else if ("edge".equalsIgnoreCase(browser)) {
            return browser;
        } else if ("safari".equalsIgnoreCase(browser)) {
        }
        return null;
    }

    public WebDriverWait getWait() {
        if (isEmpty(wait)) {
            initialiseDriver();
        }
        return wait;
    }

    public JavascriptExecutor getJavascriptExecutor() {
        if (isEmpty(js)) {
            initialiseDriver();
        }
        return js;
    }

    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    public void closeDriver() {
        if (driver == null) {
            return;
        }

        driver.quit();
        driver = null;
    }

    private void initialiseDriver() {
        Dimension dimension = new Dimension(length, height);
        if (!isEmpty(driver)) {
            closeDriver();
        }

        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("java.awt.headless", "false");

        if ("chrome".equalsIgnoreCase(browser)) {
            setChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            setFirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            setSafariDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            setEdgeDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().setSize(dimension);

        goToBaseUrl();
    }

    private void setChromeDriver() {
      // WebDriverManager.chromedriver().setup();
      //log.info("Driver Path", WebDriverManager.chromedriver().getDownloadedDriverPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");

        if (TRUE.equals(headless)) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("window-size=1920,1080");
        }

        if ("grid".equals(remote)) {
            try {
                driver = new RemoteWebDriver(new URL("htpp://localhost:4444/wd/hub"), chromeOptions);
            } catch (MalformedURLException err) {
                log.error("The hub URL is malformed", err);
            }
        } else {
            driver = new ChromeDriver(chromeOptions);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;

    }

    private void setFirefoxDriver() {
     // WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxBinary firefoxBinary = new FirefoxBinary();

        if (TRUE.equals(headless)) {
            firefoxBinary.addCommandLineOptions("--headless");
            firefoxOptions.addArguments("--width=1920");
            firefoxOptions.addArguments("--height=1080");
        }

        firefoxOptions.setBinary(firefoxBinary);

        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    private void setEdgeDriver() {
       // WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();

        if (TRUE.equals(headless)) {
            edgeOptions.addArguments("--headless");
        }

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    private void setSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        driver = new SafariDriver(safariOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    private void goToBaseUrl() {
        driver.navigate().to(baseUrl);
    }

}