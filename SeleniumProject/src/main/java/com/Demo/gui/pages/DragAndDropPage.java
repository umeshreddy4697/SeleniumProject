package com.Demo.gui.pages;

import com.Demo.gui.BasePage;
import com.Demo.gui.utils.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDropPage extends BasePage {

    public ScenarioContext context;
    public WebDriver driver;

    public DragAndDropPage(ScenarioContext context){
        super(context);
        this.context=context;
        this.driver= context.driver;
    }

    public static final By dragAndDropLink = By.xpath("//*[@id=\"menu-item-2804\"]/a/span[2]");
    public static final By iframe=By.xpath("//iframe[@class='demo-frame lazyloaded']");
    public static final By firstImage=By.id("gallery");
    public static final By trashElement=By.id("trash");



    public WebElement getDragAndDropLink(){
        return waitForElement(dragAndDropLink);
    }

    public WebElement getFirstImage(){
        return waitForElement(firstImage);
    }

    public WebElement getTrashElement(){
        return waitForElement(trashElement);
    }

    public WebElement getIframe(){
        return waitForElement(iframe);
    }


    public void clickOnDragAndDropLink(){
        getDragAndDropLink().click();
    }

    public void performDragAndDrop(){
        Actions act=new Actions(driver);
        driver.switchTo().frame(getIframe());
        List<WebElement> list=getFirstImage().findElements(By.tagName("li"));
        act.dragAndDrop(list.get(0), getTrashElement()).build().perform();
    }
}
