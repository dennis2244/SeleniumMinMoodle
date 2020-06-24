package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.CourseViewPage
import com.SeleniumDeutscheBahn.pages.CreateTaskPage
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.annotations.Test

class CreateTaskTest : Base() {

    @Test
    fun createTask(){
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())

        courseViewPage.switchEditMode("active")

        courseViewPage.createMaterialOrActivity()
        //manueller Click erforderlich

        Assert.assertTrue(courseViewPage.menuHeader!!.isDisplayed)

        courseViewPage.selectAufgabe()

        Assert.assertTrue(courseViewPage.submitButton!!.isDisplayed)

        courseViewPage.submitChoices()


        var createTaskPage: CreateTaskPage = CreateTaskPage(driver!!)
        Assert.assertTrue(createTaskPage.pageHeader!!.isDisplayed)

        var taskName: String = "Testaufgabe Nummer 1"
        var taskDescription: String = "Beispieltask zu Selenium Webdriver"
        var dueDate: String = "12"
        var dueMonth: String = "7"
        var gradindDueDay: String = "25"

        createTaskPage.enterName(taskName)
        createTaskPage.enterDescription(taskDescription)
        createTaskPage.setDueDate(dueDate)
        createTaskPage.setDueMonth(dueMonth)
        createTaskPage.setGradingDay(gradindDueDay)

        createTaskPage.hitSubmit()

        Assert.assertTrue(courseViewPage.testAufgabe1!!.isDisplayed)


    }

    fun deleteTask(){
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.testAufgabe1!!.isDisplayed)

    }
}