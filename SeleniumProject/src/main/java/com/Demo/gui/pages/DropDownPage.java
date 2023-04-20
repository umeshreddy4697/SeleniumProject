package com.Demo.gui.pages;

import com.Demo.gui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Demo.gui.utils.ScenarioContext;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage extends BasePage {
    public ScenarioContext context;
    public WebDriver driver;

    public DropDownPage(ScenarioContext context){
        super(context);
        this.context=context;
        this.driver= context.driver;
    }

    public static final By dropDownElement = By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select");


    public WebElement getDropDownElement(){
        return waitForElement(dropDownElement);
    }

    public List<String> printFirst10Elements(int numberOfElements){
        List<String> elements=new ArrayList<>();
        Select s = new Select(driver.findElement(dropDownElement));
        List <WebElement> getAllOptions = s.getOptions();
        for(int i =0; i<getAllOptions.size() ; i++){
            elements.add(getAllOptions.get(i).getText());
            if(i>numberOfElements){
                break;
            }
        }
        return elements;
    }
}
