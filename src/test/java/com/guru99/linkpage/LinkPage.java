package com.guru99.linkpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkPage {

    private static final String GURUSITE = "http://demo.guru99.com/test/link.html";
    private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";
    protected WebDriver driver;


    @Given("Open the page")
    public void openThePage() {
        driver.get(GURUSITE);
    }

    @When("Click on first link")
    public void clickOnLink() {
        LinkPageElements mainPage = new LinkPageElements(driver);
        mainPage.firstLink.click();
    }

    @Then("I should see {string}")
    public void iShouldSee(String arg0) {
        LinkPageElements mainPage = new LinkPageElements(driver);
        Assertions.assertTrue(mainPage.searchGoogle.getAttribute("aria-label").contains(arg0));
        Assertions.assertTrue(driver.getPageSource().contains(arg0));
        Assertions.assertTrue(mainPage.logoGoogle.isDisplayed());
    }


    @When("Click on second link")
    public void clickOnSecondLink(){
        LinkPageElements mainPage = new LinkPageElements(driver);
        mainPage.secondLink.click();
    }


    @Then("I should see logo {string}")
    public void iShouldSeeLogo(String arg0) {
        LinkPageElements mainPage = new LinkPageElements(driver);
        Assertions.assertTrue(mainPage.logoFacebook.isDisplayed());
        Assertions.assertTrue(mainPage.paragrafoFacebook.getText().contains(arg0));
    }


    @And("Go back")
    public void goBack() {
        driver.navigate().back();
    }

    @Then("I should see the link")
    public void iShouldSeeTheLink() {
        LinkPageElements mainPage = new LinkPageElements(driver);
        Assertions.assertTrue(mainPage.firstLink.getText().contains("click here"));
    }

    @Before
    public void beforeScenario() {
        System.setProperty(WEBDRIVER_CHROME_NAME, WEBDRIVER_CHROME_PATH);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setCapability("setJavascriptEnabled", "true");

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

}
