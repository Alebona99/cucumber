package com.guru99.deletecustomer;

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

public class DeleteCustomerPage {

    private static final String GURUSITE = "http://demo.guru99.com/test/delete_customer.php";
    private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";
    protected WebDriver driver;


    @Given("Open Delete Customer page")
    public void openThePage(){
        driver.get(GURUSITE);
    }


    @When("Insert Customer ID {string}")
    public void insertCustomerID(String arg0) {
        DeleteCustomerPageElements mainPage = new DeleteCustomerPageElements(driver);
        mainPage.inputCustomer.sendKeys(arg0);
    }

    @And("Click Submit button")
    public void submit() {
        DeleteCustomerPageElements mainPage = new DeleteCustomerPageElements(driver);
        mainPage.submit.click();
    }

    @And("I should see Confirm alert")
    public void iShouldSeeAlert() {
        Assertions.assertTrue(driver.switchTo().alert().getText().contains("Do you really want to delete this Customer?"));
    }

    @And("Click Confirm button")
    public void confirm() {
        driver.switchTo().alert().accept();
    }

    @And("I should see Success alert")
    public void iShouldSeeSuccessAlert() {
        Assertions.assertTrue(driver.switchTo().alert().getText().contains("Customer Successfully Delete!"));
    }


    @Then("I should see Home Page")
    public void seeHomePage() {
        DeleteCustomerPageElements mainPage = new DeleteCustomerPageElements(driver);
        Assertions.assertTrue(mainPage.title.getText().equals("Guru99 Bank"));
    }

    @And("Click Cancel button")
    public void clickCancel() {
        driver.switchTo().alert().dismiss();
    }


    @And("Click Reset button")
    public void clickReset() {
        DeleteCustomerPageElements mainPage = new DeleteCustomerPageElements(driver);
        mainPage.reset.click();
    }


    @Then("I should see blank Input")
    public void iShouldSeeBlankInput() {
        DeleteCustomerPageElements mainPage = new DeleteCustomerPageElements(driver);
        mainPage.inputCustomer.getAttribute("value").contains("");
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


    @When("Insert Customer ID <customerId>")
    public void insertCustomerIDCustomerId(String customerId) {
        DeleteCustomerPageElements mainPage = new DeleteCustomerPageElements(driver);
        mainPage.inputCustomer.sendKeys(customerId);
    }
}
