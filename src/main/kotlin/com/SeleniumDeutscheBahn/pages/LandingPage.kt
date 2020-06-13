package com.SeleniumDeutscheBahn.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LandingPage (driver:WebDriver){
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(xpath = "//*[@title='W09']")
    val linkToCourse: WebElement? = null

    fun navigateToCourse(){
        linkToCourse!!.click()
    }

}