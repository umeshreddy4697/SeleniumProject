package com.Demo.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Demo.gui.utils.ScenarioContext;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;
    public ScenarioContext context;


    public BasePage(ScenarioContext context){
        this.context=context;
    }

    public void invokeDriver(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            driver= new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver=new FirefoxDriver();
        }
        context.driver=driver;
    }

    public WebElement waitForElement(By locator){
        WebDriverWait wait=new WebDriverWait(context.driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=context.driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public List<WebElement> waitForElements(By locator){
        WebDriverWait wait=new WebDriverWait(context.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> element=context.driver.findElements(locator);
        return element;
    }

    public void quitDriver(){
        driver.quit();
    }
}
