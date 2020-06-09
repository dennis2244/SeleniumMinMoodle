package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.LandingPage
import com.SeleniumDeutscheBahn.pages.LoginPage
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.annotations.Test

class LoginTest : Base() {

    @Test
    fun loginTest(){
       var loginPage: LoginPage = LoginPage(driver!!)
        PageFactory.initElements(driver!!, loginPage)
        loginPage.login("", "")

        Assert.assertTrue(loginPage.isUserLoggedIn())
    }

    @Test
    fun navigateToCourse(){
        var landingPage: LandingPage = LandingPage(driver!!)
        PageFactory.initElements(driver!!, landingPage)
        landingPage.navigateToCourse()

    }
}
