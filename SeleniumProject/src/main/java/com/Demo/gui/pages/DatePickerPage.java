package com.Demo.gui.pages;

import com.Demo.gui.BasePage;
import com.Demo.gui.utils.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DatePickerPage extends BasePage {

    public ScenarioContext context;
    public WebDriver driver;

    public DatePickerPage(ScenarioContext context){
        super(context);
        this.context=context;
        this.driver= context.driver;
    }

    public static final By datePicker=By.id("datepicker");
    public static final By datePickerLink=By.xpath("//*[@id=\"menu-item-2808\"]/a/span[2]");
    public static final By calenderPicker=By.className("ui-datepicker-calendar");
    public static final By iframe=By.xpath("//iframe[@class='demo-frame lazyloaded']");

    public WebElement getDatePicker(){return waitForElement(datePicker);}
    public WebElement getCalenderPicker(){return waitForElement(calenderPicker);}
    public WebElement getIframe(){return waitForElement(iframe);}

    public WebElement getDatePickerLink(){return waitForElement(datePickerLink);}

    public void clickOnDatePickerLink(){
        getDatePickerLink().click();
    }
    public void clickOnDatePicker(){
        driver.switchTo().frame(getIframe());
        getDatePicker().click();
    }

    public void selectDate(String date) {
        List<WebElement> columns = getCalenderPicker().findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            if (cell.getText().equals(date)) {
                cell.findElement(By.linkText(date)).click();
                break;
            }
        }
    }
}
