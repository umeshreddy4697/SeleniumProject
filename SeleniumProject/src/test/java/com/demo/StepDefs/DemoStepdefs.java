package com.demo.StepDefs;

import com.Demo.gui.BasePage;
import com.Demo.gui.pages.DatePickerPage;
import com.Demo.gui.pages.DragAndDropPage;
import com.Demo.gui.pages.DropDownPage;
import com.Demo.gui.utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class DemoStepdefs {

    public WebDriver driver;
    public ScenarioContext context;
    public BasePage basePage;
    public DropDownPage dropDownPage;
    public DragAndDropPage dragAndDropPage;
    public DatePickerPage datePickerPage;

    public DemoStepdefs(ScenarioContext context){
        this.context=context;
        this.driver= context.driver;
        this.basePage=new BasePage(context);
        this.dropDownPage=new DropDownPage(context);
        this.dragAndDropPage=new DragAndDropPage(context);
        this.datePickerPage=new DatePickerPage(context);
    }

    @Given("launch chrome browser with url {string}")
    public void launchChromeBrowserWithUrl(String url){
        driver.navigate().to(url);
    }

    @Then("print first {int} elements from dropdown")
    public void printFirstElementsFromDropdown(int noOfElements) {
        List<String> elements=dropDownPage.printFirst10Elements(noOfElements);
        System.out.println(elements);
    }

    @Then("click on drag and drop")
    public void clickOnDragAndDrop() {
        dragAndDropPage.clickOnDragAndDropLink();
    }

    @Then("perform drag and drop")
    public void performDragAndDrop() {
        dragAndDropPage.performDragAndDrop();
    }

    @Then("click on date picker")
    public void clickOnDatePicker() {
        datePickerPage.clickOnDatePickerLink();
        datePickerPage.clickOnDatePicker();
    }

    @Then("select date {string}")
    public void selectDate(String date) {
        datePickerPage.selectDate(date);
    }
}
