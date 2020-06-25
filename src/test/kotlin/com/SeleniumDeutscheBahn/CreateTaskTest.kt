package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.data.TestData
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


        createTaskPage.enterName(TestData.taskName)
        createTaskPage.enterDescription(TestData.taskDescription)
        createTaskPage.setDueDate(TestData.dueDate)
        createTaskPage.setDueMonth(TestData.dueMonth)
        createTaskPage.setGradingDay(TestData.gradindDueDay)

        createTaskPage.hitSubmit()

        Assert.assertTrue(courseViewPage.testAufgabe1!!.isDisplayed)


    }

    fun deleteTask(){
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.testAufgabe1!!.isDisplayed)

    }
}