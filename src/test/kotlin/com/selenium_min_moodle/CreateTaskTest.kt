package com.selenium_min_moodle

import com.aventstack.extentreports.Status
import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.CreateTaskPage
import org.testng.Assert
import org.testng.annotations.Test

class CreateTaskTest : Base() {

    @Test
    fun createTask(){
        test = extent!!.createTest("Create a new Task")
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        test!!.log(Status.INFO, "Login and navigate to course view")


        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())
        test!!.log(Status.INFO, "Course view should displayed")

        courseViewPage.switchEditMode("active")
        test!!.log(Status.INFO, "Switch edit Mode to active")

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
        test!!.log(Status.INFO, "Creating a new announcement")

        Assert.assertTrue(courseViewPage.testAufgabe1!!.isDisplayed)


    }

    fun deleteTask(){
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.testAufgabe1!!.isDisplayed)

    }
}