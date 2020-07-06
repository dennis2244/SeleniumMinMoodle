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
    var driver2: WebDriver? = null
    var driver3: WebDriver? = null

    @Test(threadPoolSize = 3)
    fun createAnnouncement() {
        System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
        driver = ChromeDriver()
        driver!!.manage().deleteAllCookies()
        driver!!.get(TestData.url)
        driver!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver!!.manage().window().maximize()


        var loginPage = LoginPage(driver!!)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        var landingPage = LandingPage(driver!!)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver!!)
        courseViewPage.createNewAnnouncement(TestData.anncouncementSubject, TestData.announcementMessage)

        Assert.assertTrue(courseViewPage.verifyNewAnnouncement())
    }

    @Test
    fun switchEditMode() {
        System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
        driver2 = ChromeDriver()
        driver2!!.manage().deleteAllCookies()
        driver2!!.get(TestData.url)
        driver2!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver2!!.manage().window().maximize()

        var loginPage = LoginPage(driver2!!)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        var landingPage = LandingPage(driver2!!)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver2!!)

        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
        Assert.assertEquals(courseViewPage.switchEditButton!!.text, TestData.bearbeitenEinschalten)

        courseViewPage.switchEditMode("active")

        Assert.assertEquals(courseViewPage.switchEditButton!!.text,TestData.bearbeitenAusschalten)
        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
    }

    @Test
    fun changeSystemLanguage(){
        System.setProperty("webdriver.chrome.driver", TestData.pathToChromeDriver)
        driver3 = ChromeDriver()
        driver3!!.manage().deleteAllCookies()
        driver3!!.get(TestData.url)
        driver3!!.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        driver3!!.manage().window().maximize()

        var loginPage = LoginPage(driver3!!)
        loginPage.login(TestData.username, TestData.password)
        Assert.assertTrue(loginPage.isUserLoggedIn())
        Assert.assertEquals(loginPage.meineKurse!!.text,(TestData.meineKurse))

        val landingPage = LandingPage(driver3!!)
        landingPage.navigateToCourse()
        landingPage.switchLanguage(TestData.languageEnglish)
        Assert.assertTrue(landingPage.verifyLanguage(TestData.languageEnglish))

        landingPage.switchLanguage(TestData.languageDeutsch)
        Assert.assertTrue(landingPage.verifyLanguage(TestData.languageDeutsch))
    }
}