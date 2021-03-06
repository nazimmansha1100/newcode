/**
 *
 */
package runner;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.cucumber.listener.ExtentCucumberFormatter;


//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.BrowserFactory;
//import cucumber.api.junit.Cucumber;
import utils.utilities;


/**
 * @author Niharika
 *
 *
 */
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/medicalHistory.feature"}, tags = {"@download", "@medicalMenu"},
        glue = {"stepDefinitions"},
        monochrome = true,

        plugin = {"pretty", "html:target/cucumber", "com.cucumber.listener.ExtentCucumberFormatter", "json:target/cucumber.json"}
        //plugin = {"pretty","html:target/cucumber","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber/report.html"}

)
public class RunCukeTestng extends AbstractTestNGCucumberTests {

    static Properties prop;


    @BeforeClass
    public static void setup() {
        utilities.loadReport();
        prop = utilities.loadProperties();
        BrowserFactory.getDriver();
    }

    @AfterClass
    public static void afterClass(){
        BrowserFactory.close();
    }


}
