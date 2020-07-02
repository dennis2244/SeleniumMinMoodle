package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CourseCompletionPage (driver: WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(id = "id_courseprerequisites")
    val aktivitaetsabschluss:WebElement? = null

    @FindBy(id = "id_cancel")
    val abortButton: WebElement? = null

    fun verifyPage(): Boolean{
        return aktivitaetsabschluss!!.isDisplayed
    }

    fun navigateBackToCourseView(){
        abortButton!!.click()
    }

}