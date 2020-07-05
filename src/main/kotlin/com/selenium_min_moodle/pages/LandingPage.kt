package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LandingPage (driver:WebDriver){
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(xpath = "//*[@title='W09']")
    val linkToCourse: WebElement? = null

    @FindBy(xpath= "//*[contains(@class, 'dropdown-toggle nav-link')]")
    val languageDropdown: WebElement? = null

    @FindBy(xpath= "//*[contains(@class, 'dropdown-item') and contains(text(), 'Deutsch \u200E(de)\u200E')]")
    val langaugeGerman: WebElement? = null

    @FindBy(xpath= "//*[contains(@class, 'dropdown-item') and contains(text(), 'English \u200E(en)\u200E')]")
    val langaugeEnglish: WebElement? = null


    fun navigateToCourse(){
        linkToCourse!!.click()
    }

    //Methode zum Wechseln der Sprache
    fun switchLanguage(language:String){
        languageDropdown!!.click()
        when (language){
            "deutsch" -> langaugeGerman!!.click()
            "englisch" -> langaugeEnglish!!.click()
        }
    }

    fun verifyLanguage(language: String): Boolean {
        val currentLanguage = webDriver!!.currentUrl
        print(currentLanguage)
        return if (language == "deutsch") currentLanguage.contains("lang=de")
        else return currentLanguage.contains("lang=en")
    }
}