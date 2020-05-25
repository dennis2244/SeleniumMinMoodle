package com.SeleniumDeutscheBahn

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.FileInputStream
import java.util.*

class LoginTest {

    private var driver: WebDriver? = null
    private var props: Properties? = null

    @BeforeTest
    fun createDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/kotlin/com/SeleniumDeutscheBahn/browserDriver/chromedriver")
        driver = ChromeDriver()
    }

    @BeforeTest
    fun initProperties(){
        props = Properties()
        props!!.load(FileInputStream("src/properties.txt"))
    }

    @AfterTest
    fun teardownDriver(){
        driver!!.quit()
    }

    @Test
    fun openMoodlePage(){

        //Aufruf der Page
        val url = "https://lernen.min.uni-hamburg.de/login/index.php"
        driver!!.get(url)

        Assert.assertEquals(driver!!.currentUrl, url, "URL did not match expected Value")

    }

    @Test
    fun checkUsernameInputElement(){
        openMoodlePage()

        //Username Input wird angezeigt
        val usernameInputSelector = "#username"
        val usernameInputBy = By.cssSelector(usernameInputSelector)
        val usernameInputElement: WebElement = driver!!.findElement(usernameInputBy)

        Assert.assertTrue(usernameInputElement.isDisplayed,"Element with id "+usernameInputSelector+" was not displayed")

        //Wird der Placeholder korrekt angezeigt
        val usernameInputPlaceholderValue = usernameInputElement.getAttribute("placeholder")
        Assert.assertEquals(usernameInputPlaceholderValue,"Benutzerkennung")


    }

    @Test
    fun checkPasswordInputElement(){
        openMoodlePage()

        //Password Input wird angezeigt
        val passwordInputSelector = "#password"
        val passwordInputBy = By.cssSelector(passwordInputSelector)
        val passwordInputElement: WebElement = driver!!.findElement(passwordInputBy)

        Assert.assertTrue(passwordInputElement.isDisplayed,"Element with id "+passwordInputSelector+" was not displayed")

        //Wird der Placeholder korrekt angezeigt
        val passwordInputPlaceholderValue = passwordInputElement.getAttribute("placeholder")
        Assert.assertEquals(passwordInputPlaceholderValue,"Kennwort")

    }

    @Test
    fun checkLoginButton(){
        openMoodlePage()

        //Login Button wird angezeigt
        val loginButtonInputSelector = "#loginbtn"
        val loginButtonInputBy = By.cssSelector(loginButtonInputSelector)
        val loginButtonInputElement: WebElement = driver!!.findElement(loginButtonInputBy)

        Assert.assertTrue(loginButtonInputElement.isDisplayed,"Element with id "+loginButtonInputSelector+" was not displayed")


    }

    @Test
    fun enterCredentials(){
        openMoodlePage()
        val usernameInputSelector = "#username"
        val usernameInputBy = By.cssSelector(usernameInputSelector)
        val usernameInputElement: WebElement = driver!!.findElement(usernameInputBy)

        //Eingabe der Benutzerdaten
        usernameInputElement.sendKeys(props!!.getProperty("username"))
        Assert.assertEquals(usernameInputElement.getAttribute("value"),props!!.getProperty("username"))

        val passwordInputSelector = "#password"
        val passwordInputBy = By.cssSelector(passwordInputSelector)
        val passwordInputElement: WebElement = driver!!.findElement(passwordInputBy)

        //Eingabe des Benutzerpasswortes
        passwordInputElement.sendKeys(props!!.getProperty("password"))
        Assert.assertEquals(passwordInputElement.getAttribute("value"),props!!.getProperty("password"))
    }

    @Test
    fun loginWithCredentials() {
        enterCredentials()

        val loginButtonInputSelector = "#loginbtn"
        val loginButtonInputBy = By.cssSelector(loginButtonInputSelector)
        val loginButtonInputElement: WebElement = driver!!.findElement(loginButtonInputBy)

        loginButtonInputElement.click()

        val url = "https://lernen.min.uni-hamburg.de/my/"
        Assert.assertEquals(driver!!.currentUrl,url)


    }
}