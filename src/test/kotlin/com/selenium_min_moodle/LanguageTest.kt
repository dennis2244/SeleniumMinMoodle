package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.LandingPage
import org.testng.Assert
import org.testng.annotations.Test

class LanguageTest : Base() {

    @Test
    fun languageTest(){
        val landingPage = LandingPage(driver!!)
        landingPage.switchLanguage(TestData.languageEnglish)
        Assert.assertTrue(landingPage.verifyLanguage(TestData.languageEnglish))

        landingPage.switchLanguage(TestData.languageDeutsch)
        Assert.assertTrue(landingPage.verifyLanguage(TestData.languageDeutsch))
    }
}