package com.Demo.gui.utils;

import com.Demo.gui.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class CustomHooks extends BasePage {

    public CustomHooks(ScenarioContext context) {
        super(context);
    }

    @Before("@Initialize_Driver")
    public void getDriverContext(){
        invokeDriver("Chrome");
    }

    @After("@Quit_Driver")
    public void invokeQuitDriver(){
        quitDriver();
    }
}
