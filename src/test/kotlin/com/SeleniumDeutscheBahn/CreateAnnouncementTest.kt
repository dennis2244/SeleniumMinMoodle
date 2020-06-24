package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.CourseViewPage
import com.SeleniumDeutscheBahn.pages.LandingPage
import com.aventstack.extentreports.Status
import org.testng.Assert
import org.testng.annotations.Test

open class CreateAnnouncementTest : Base() {

    @Test
    fun createNewAnnouncementTest(){
        test = extent!!.createTest("Create a new announcement")
        test!!.log(Status.INFO, "Login and navigate to course view")

        test!!.log(Status.INFO, "Course view should displayed")

        test!!.log(Status.INFO, "Creating a new announcement")
        var courseViewPage = CourseViewPage(driver!!)
        courseViewPage.createNewAnnouncement("Testautomatisierung", "Das hier ist die Nachricht.")

        when (courseViewPage.verifyNewAnnouncement()) {
            true -> test!!.log(Status.PASS, "Announcement was created correctly!")
            false -> test!!.log(Status.FAIL, "Failed to create an announcement!")
        }
    }

}