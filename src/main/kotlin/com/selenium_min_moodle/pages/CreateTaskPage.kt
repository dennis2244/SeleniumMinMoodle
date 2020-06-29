package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select
import java.lang.Exception

class CreateTaskPage(driver:WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver, this)
    }
    @FindBy(xpath = "//*[contains(text(),'Aufgabe zu ')]")
    var pageHeader: WebElement? = null

    @FindBy(id = "id_name")
    var taskNameInputField: WebElement? = null

    @FindBy(id = "id_introeditoreditable")
    var taskDescriptionInputField: WebElement? = null

    @FindBy(id = "id_duedate_day")
    var taskDueDate: WebElement? = null

    @FindBy(id = "id_duedate_month")
    var taskDueMonth: WebElement? = null

    @FindBy(id = "id_gradingduedate_day")
    var gradingDueDay: WebElement? = null

    @FindBy(id = "id_submitbutton2")
    var submitbtn2: WebElement? = null

    fun enterName(name:String){
        taskNameInputField!!.sendKeys(name)
    }

    fun enterDescription(description:String){
        taskDescriptionInputField!!.sendKeys(description)
    }

    fun setDueDate(date:String){
        var tdd: Select = Select(taskDueDate)
        try {
            tdd.selectByValue(date)
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun setDueMonth(month:String){
        var tdm: Select = Select(taskDueMonth)
        try {
            tdm.selectByValue(month)
        }
        catch (e: Exception){
            e.printStackTrace()
        }

    }

    fun setGradingDay(day:String){
        var gdd: Select = Select(gradingDueDay)
        try {
            gdd.selectByValue(day)
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun hitSubmit(){
        submitbtn2!!.click()
    }

}