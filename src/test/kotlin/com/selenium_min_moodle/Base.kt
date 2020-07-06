package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.LandingPage
import com.selenium_min_moodle.pages.LoginPage
import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.Theme
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.Assert
import org.testng.annotations.*
import java.util.concurrent.TimeUnit

open class Base {

    var driver: WebDriver? = null
    var htmlReporter: ExtentHtmlReporter? = null
    var extent: ExtentReports? = null
    var test: ExtentTest? = null

    @BeforeClass
    fun setupLoginAndNavigateToCourse(){
        htmlReporter = ExtentHtmlReporter(TestData.pathToReportFolder+"testreport.html")
        htmlReporter!!.setAppendExisting(true)
        htmlReporter!!.config().documentTitle = "Report"
        htmlReporter!!.config().reportName = "Test Report"
        htmlReporter!!.config().theme = Theme.DARK

        extent = ExtentReports()
        extent!!.attachReporter(htmlReporter)

        when(TestData.browser) {
            "chrome" ->
            {
                System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
                driver = ChromeDriver()
            }
             "firefox" ->
             {
                 System.setProperty("webdriver.gecko.driver", TestData.pathToFirefoxDriver)
                 driver = FirefoxDriver()
             }
        }

        driver!!.manage().deleteAllCookies()
        driver!!.get(TestData.url)
        driver!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver!!.manage().window().maximize()

        //Anmelden wird nun gleich hier gemacht, damit wir dies nicht immer in der eigentlichen Testklassen machen müssen
        var loginPage = LoginPage(driver!!)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        var landingPage = LandingPage(driver!!)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())
    }

    @AfterClass
    fun close(){
        extent!!.flush()
        driver!!.close()
    }
}