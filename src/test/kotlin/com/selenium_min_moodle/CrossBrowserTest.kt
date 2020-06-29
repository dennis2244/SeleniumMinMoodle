package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.BeforeTest
import org.testng.annotations.Parameters
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class CrossBrowserTest {

    var driver: WebDriver? = null

    @BeforeTest
    @Parameters("browser")
    fun setup(browserName: String){
        when(browserName) {
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
        driver!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver!!.get(TestData.url)
        driver!!.manage().window().maximize()

    }

    @Test
    fun createNewAnnouncementTest(){
        var courseViewPage = CourseViewPage(driver!!)
        courseViewPage.createNewAnnouncement(TestData.anncouncementSubject, TestData.announcementMessage)

       courseViewPage.verifyNewAnnouncement()
    }
}