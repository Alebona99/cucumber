package com.guru99.linkpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkPageElements {

    @FindBy( xpath = "//a[@href='http://www.google.com']")
    public WebElement firstLink;

    @FindBy( name = "btnK")
    public WebElement searchGoogle;

    @FindBy( xpath = "//img[@alt='Google']")
    public WebElement logoGoogle;

    @FindBy( xpath = "//a[2]")
    public WebElement secondLink;

    @FindBy( className = "fb_logo")
    public WebElement logoFacebook;

    @FindBy( className = "_8eso")
    public WebElement paragrafoFacebook;

    public LinkPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
