package com.selenium_min_moodle

import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.LandingPage
import org.testng.Assert
import org.testng.annotations.BeforeClass

open class LoginAndNavigateToCourseTest : Base() {

    @BeforeClass
    fun navigateToCourse(){
        var landingPage: LandingPage = LandingPage(driver!!)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())
    }
}
