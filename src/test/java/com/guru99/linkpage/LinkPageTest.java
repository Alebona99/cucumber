package com.guru99.linkpage;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:report/linkpage.html", "json:report/linkpage-report.json"}, features ={"src/test/java/features/Guru99.feature"})
public class LinkPageTest {

}
