package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import com.aventstack.extentreports.Status
import org.testng.annotations.Test

open class CreateAnnouncementTest : Base() {

    @Test
    fun createNewAnnouncementTest(){
        test = extent!!.createTest("Create a new announcement")
        test!!.log(Status.INFO, "Login and navigate to course view")

        test!!.log(Status.INFO, "Course view should displayed")

        test!!.log(Status.INFO, "Creating a new announcement")
        var courseViewPage = CourseViewPage(driver!!)
        courseViewPage.createNewAnnouncement(TestData.anncouncementSubject, TestData.announcementMessage)

        when (courseViewPage.verifyNewAnnouncement()) {
            true -> test!!.log(Status.PASS, "Announcement was created correctly!")
            false -> test!!.log(Status.FAIL, "Failed to create an announcement!")
        }
    }

}