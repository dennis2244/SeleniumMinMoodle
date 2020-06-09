package com.SeleniumDeutscheBahn.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LandingPage (driver:WebDriver){

    @FindBy(xpath = "//*[@title='W09']")
    val linkToCourse: WebElement? = null

    fun navigateToCourse(){
        linkToCourse!!.click()
    }

}