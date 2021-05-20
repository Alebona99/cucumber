package com.guru99.deletecustomer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:report/deletecustomer.html", "json:report/deletecustomer-report.json"}, features = {"src/test/java/features/Guru99Delete.feature"})
public class DeleteCustomerPageTest {
}
