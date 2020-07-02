package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class EditCourseSettingsPage (driver: WebDriver) {

    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(id = "id_fullname")
    val courseNameTextfield: WebElement? = null

    @FindBy(id = "id_cancel")
    val abort: WebElement? = null

    fun verifyPage():Boolean{
        return courseNameTextfield!!.isDisplayed
    }

    fun navigateBackTOCourseView(){
        abort!!.click()
    }
}