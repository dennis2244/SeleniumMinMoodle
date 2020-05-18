package com.SeleniumDeutscheBahn

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
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

        val usernameInputSelector = "#username"
        val usernameInputBy = By.cssSelector(usernameInputSelector)
        val usernameInputElement: WebElement = driver!!.findElement(usernameInputBy)

        Assert.assertTrue(usernameInputElement.isDisplayed,"Element was not displyed")

        val passwordInputSelector = "#password"
        val passwordInputBy = By.cssSelector(passwordInputSelector)
        val passwordInputElement: WebElement = driver!!.findElement(passwordInputBy)

        Assert.assertTrue(passwordInputElement.isDisplayed,"Element was not displyed")


    }
}