package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


class LoginPage (driver:WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(id="username")
    val username: WebElement? = null

    @FindBy(id="password")
    val password: WebElement? = null

    @FindBy(id="loginbtn")
    val loginButton: WebElement? = null

    @FindBy(xpath = "(//*[starts-with(@id,'instance-') and contains(@class, 'card-title d-inline')])[3]")
    //@FindBy(id="instance-25494-header")
    val meineKurse: WebElement? = null

    fun login(user: String, pw: String){
        username!!.sendKeys(user)
        password!!.sendKeys(pw)
        loginButton!!.click()
    }

    fun isUserLoggedIn(): Boolean{
        return meineKurse!!.isDisplayed
    }

}