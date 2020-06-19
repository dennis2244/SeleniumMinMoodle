package com.SeleniumDeutscheBahn.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select

class CreateTaskPage(driver:WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }
    @FindBy(xpath = "//*[contains(text(),'Aufgabe zu ')]")
    var pageHeader: WebElement? = null

    @FindBy(id = "id_name")
    var taskNameInputField: WebElement? = null

    @FindBy(id = "id_introeditoreditable")
    var taskDescriptionInputField: WebElement? = null

    //@FindBy(id = "id_duedate_day")
    //var taskDueDate: Select? = null

    fun enterName(name:String){
        taskNameInputField!!.sendKeys(name)
    }

    fun enterDescription(description:String){
        taskDescriptionInputField!!.sendKeys(description)
    }

    fun setDueDate(date:String){
        //taskDueDate!!.selectByValue(date)
    }

}