package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.CourseViewPage
import com.SeleniumDeutscheBahn.pages.CreateTaskPage
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.annotations.Test

class CreateTaskTest : LoginAndNavigateToCourseTest() {

    @Test
    fun createTask(){
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)
        PageFactory.initElements(driver!!, CourseViewPage(driver!!))

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

        createTaskPage.enterName(taskName)
        //Assert.assertEquals(createTaskPage.taskNameInputField!!.text,taskName)
        createTaskPage.enterDescription(taskDescription)
        //Assert.assertEquals(createTaskPage.taskDescriptionInputField!!.text,taskDescription)
        //createTaskPage.setDueDate(dueDate)




    }
}