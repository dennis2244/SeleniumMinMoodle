package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LearningTargetPage (driver: WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(id = "removeoutcomes")
    val removeOutcomes: WebElement? = null

    @FindBy(xpath="//*[contains(text(), 'W09')]")
    val backToCourseView: WebElement? = null

    fun verifyPage(): Boolean{
        return removeOutcomes!!.isDisplayed
    }

    fun navigateBackToCourseView(){
        backToCourseView!!.click()
    }
}