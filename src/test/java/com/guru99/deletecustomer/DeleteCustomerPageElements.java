package com.guru99.deletecustomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPageElements {

    @FindBy( name = "cusid")
    public WebElement inputCustomer;

    @FindBy( name = "submit")
    public WebElement submit;

    @FindBy( name = "res")
    public WebElement reset;

    @FindBy( className = "barone")
    public WebElement title;


    public DeleteCustomerPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
