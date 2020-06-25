package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.data.TestData
import com.SeleniumDeutscheBahn.pages.CourseViewPage
import com.SeleniumDeutscheBahn.pages.LandingPage
import com.SeleniumDeutscheBahn.pages.LoginPage
import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.reporter.BasicFileReporter
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration
import com.aventstack.extentreports.reporter.configuration.Theme
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.Assert
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeTest
import java.util.concurrent.TimeUnit

open class Base {

    var driver: WebDriver? = null
    var htmlReporter: ExtentHtmlReporter? = null
    var extent: ExtentReports? = null
    var test: ExtentTest? = null


    @BeforeClass
    fun setupLoginAndNavigateToCourse(){
        htmlReporter = ExtentHtmlReporter(TestData.pathToReportFolder+"testreport.html")
        htmlReporter!!.config().documentTitle = "Report"
        htmlReporter!!.config().reportName = "Test Report"
        htmlReporter!!.config().theme = Theme.DARK

        extent = ExtentReports()
        extent!!.attachReporter(htmlReporter)

        System.setProperty("webdriver.gecko.driver", TestData.pathToDriver)
        driver = FirefoxDriver()
        driver!!.manage().deleteAllCookies()
        driver!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver!!.get(TestData.url)
        driver!!.manage().window().maximize()

        //Anmelden wird nun gleich hier gemacht, damit wir dies nicht immer in der eigentlichen Testklassen machen müssen
        var loginPage = LoginPage(driver!!)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        var landingPage: LandingPage = LandingPage(driver!!)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())
    }

    @AfterClass
    fun close(){
        extent!!.flush()
        //driver!!.close()
    }
}