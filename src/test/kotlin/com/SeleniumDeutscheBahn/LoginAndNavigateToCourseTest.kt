package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.pages.CourseViewPage
import com.SeleniumDeutscheBahn.pages.LandingPage
import com.SeleniumDeutscheBahn.pages.LoginPage
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.annotations.Test

open class LoginAndNavigateToCourseTest : Base() {

    @Test
    fun navigateToCourse(){
        var landingPage: LandingPage = LandingPage(driver!!)
        landingPage.navigateToCourse()

        var courseViewPage = CourseViewPage(driver!!)
        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())
    }
}
