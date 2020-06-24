package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.CourseViewPage
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.annotations.Test

class EnableEditCourseViewPageTest : Base() {

    @Test
    fun setEditModeActive(){

        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
        Assert.assertEquals(courseViewPage.switchEditButton!!.text,"Bearbeiten einschalten")

        courseViewPage.switchEditMode("active")

        Assert.assertEquals(courseViewPage.switchEditButton!!.text,"Bearbeiten ausschalten")
        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
    }

    @Test
    fun setEditModeDisabled(){

        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        courseViewPage.switchEditMode("disabled")

        Assert.assertTrue(courseViewPage.switchEditButton!!.isDisplayed)
        Assert.assertEquals(courseViewPage.switchEditButton!!.text,"Bearbeiten einschalten")

    }
}