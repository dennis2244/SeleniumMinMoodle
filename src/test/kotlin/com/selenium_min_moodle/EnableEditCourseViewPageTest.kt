package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import org.testng.Assert
import org.testng.annotations.Test

class EnableEditCourseViewPageTest : Base() {

    @Test
    fun setEditModeActive(){

        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
        Assert.assertEquals(courseViewPage.switchEditButton!!.text, TestData.bearbeitenEinschalten)

        courseViewPage.switchEditMode("active")

        Assert.assertEquals(courseViewPage.switchEditButton!!.text,TestData.bearbeitenAusschalten)
        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
    }

    @Test
    fun setEditModeDisabled(){

        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        courseViewPage.switchEditMode("disabled")

        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
        Assert.assertEquals(courseViewPage.switchEditButton!!.text,TestData.bearbeitenEinschalten)

    }
}