package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.LandingPage
import com.selenium_min_moodle.pages.LoginPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit


class ParallelTestExecution {

    var driver: WebDriver? = null

    @Test
    fun createAnnouncement() {
        System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
        var driver = ChromeDriver()
        driver.manage().deleteAllCookies()
        driver.get(TestData.url)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver.manage().window().maximize()

        var loginPage = LoginPage(driver)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        var landingPage = LandingPage(driver)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver)
        courseViewPage.createNewAnnouncement(TestData.anncouncementSubject, TestData.announcementMessage)

        Assert.assertTrue(courseViewPage.verifyNewAnnouncement())
    }

    @Test
    fun switchEditMode() {
        System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
        var driver = ChromeDriver()
        driver.manage().deleteAllCookies()
        driver.get(TestData.url)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver.manage().window().maximize()

        var loginPage = LoginPage(driver)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        var landingPage = LandingPage(driver)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver)

        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
        Assert.assertEquals(courseViewPage.switchEditButton!!.text, TestData.bearbeitenEinschalten)

        courseViewPage.switchEditMode("active")

        Assert.assertEquals(courseViewPage.switchEditButton!!.text,TestData.bearbeitenAusschalten)
        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
    }

    @Test
    fun changeSystemLanguage(){
        System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
        var driver = ChromeDriver()
        driver.manage().deleteAllCookies()
        driver.get(TestData.url)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver.manage().window().maximize()

        var loginPage = LoginPage(driver)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        val landingPage = LandingPage(driver)
        landingPage.navigateToCourse()
        landingPage.switchLanguage(TestData.languageEnglish)
        Assert.assertTrue(landingPage.verifyLanguage(TestData.languageEnglish))

        landingPage.switchLanguage(TestData.languageDeutsch)
        Assert.assertTrue(landingPage.verifyLanguage(TestData.languageDeutsch))
    }
}