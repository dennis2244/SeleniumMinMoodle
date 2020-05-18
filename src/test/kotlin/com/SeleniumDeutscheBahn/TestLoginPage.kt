package com.SeleniumDeutscheBahn

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class LoginTest {

    private var driver: WebDriver? = null

    @BeforeTest
    fun createDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/kotlin/com/SeleniumDeutscheBahn/browserDriver/chromedriver")
        driver = ChromeDriver()
    }

    @AfterTest
    fun teardownDriver(){
        driver!!.quit()
    }

    @Test
    fun openMoodlePage(){
        val url = "https://lernen.min.uni-hamburg.de/login/index.php"
        driver!!.get(url)

        Assert.assertEquals(driver!!.currentUrl, url, "URL did not match expected Value")
    }
}