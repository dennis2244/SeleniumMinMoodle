package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.LoginPage
import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.reporter.BasicFileReporter
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration
import com.aventstack.extentreports.reporter.configuration.Theme
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
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

    private val url: String = "https://lernen.min.uni-hamburg.de/login/index.php"
    private val pathToDriver: String = ".\\src\\test\\resources\\drivers\\chromedriver.exe"
    private val pathToReportFolder: String = ".\\src\\test\\resources\\testreports\\"

    @BeforeClass
    fun setupAndLogin(){
        htmlReporter = ExtentHtmlReporter(pathToReportFolder+"testreport.html")
        htmlReporter!!.config().documentTitle = "Report"
        htmlReporter!!.config().reportName = "Test Report"
        htmlReporter!!.config().theme = Theme.DARK

        extent = ExtentReports()
        extent!!.attachReporter(htmlReporter)

        System.setProperty("webdriver.chrome.driver", pathToDriver)
        driver = ChromeDriver()
        driver!!.manage().deleteAllCookies()
        driver!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver!!.get(url)
        driver!!.manage().window().maximize()

        //Anmelden wird nun gleich hier gemacht, damit wir dies nicht immer in der eigentlichen Testklassen machen müssen
        var loginPage = LoginPage(driver!!)
        loginPage.login("", "")
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,("Meine Kurse"))
    }

    @AfterClass
    fun close(){
        extent!!.flush()
        //driver!!.close()
    }
}