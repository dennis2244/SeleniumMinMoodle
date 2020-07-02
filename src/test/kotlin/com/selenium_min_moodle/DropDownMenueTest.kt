package com.selenium_min_moodle

import com.selenium_min_moodle.pages.CourseCompletionPage
import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.EditCourseSettingsPage
import com.selenium_min_moodle.pages.LearningTargetPage
import org.testng.Assert
import org.testng.annotations.Test

class DropDownMenueTest : Base() {

    @Test
    fun dropDownMenue(){
        val courseViewPage = CourseViewPage(driver!!)
        courseViewPage.selectActionViaDropDown("Lernziele")

        val learningTarget = LearningTargetPage(driver!!)
        Assert.assertTrue(learningTarget.verifyPage())
        learningTarget.navigateBackToCourseView()

        courseViewPage.selectActionViaDropDown("Kursabschluss")
        val courseCompletion = CourseCompletionPage(driver!!)
        Assert.assertTrue(courseCompletion.verifyPage())
        courseCompletion.navigateBackToCourseView()

        courseViewPage.selectActionViaDropDown("Einstellungen bearbeiten")
        val editCourseSettings = EditCourseSettingsPage(driver!!)
        Assert.assertTrue(editCourseSettings.verifyPage())
        editCourseSettings.navigateBackTOCourseView()
    }
}