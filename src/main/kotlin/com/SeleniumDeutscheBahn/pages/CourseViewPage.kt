package com.SeleniumDeutscheBahn.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.util.concurrent.TimeUnit

class CourseViewPage(driver:WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(xpath="//*[contains(@id, 'single_button5ee')]")
    val switchEditButton: WebElement? = null

    @FindBy(className="instancename")
    val newAnnouncement: WebElement? = null

    @FindBy(xpath= "//*[contains(@class, 'btn btn-primary')]")
    val newTopicButton: WebElement? = null

    @FindBy(id="id_subject")
    val subjectTextfield: WebElement? = null

    @FindBy(id="id_messageeditable")
    val messageTextfield: WebElement? = null

    @FindBy(name="submitbutton")
    val submitButton: WebElement? = null

    @FindBy(id="user-notifications")
    val newAnnouncementCreationText: WebElement? = null

    //Wechselt den Bearbeitungsmodus
    fun switchEditMode(mode: String){

        /*
        when (mode) {
               active -> stell sicher, dass der Bearbeitungsmodus aktiviert ist
               disabled -> stell sicher, dass der Bearbeitungsmodus deaktiviert ist
        }
         */

    }

    //Legt eine neue Ankündigung an (mit Betreff und Mitteilung)
    fun createNewAnnouncement(subject: String, message: String){
        newAnnouncement!!.click()
        webDriver!!.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS)
        newTopicButton!!.click()
        webDriver!!.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
        subjectTextfield!!.sendKeys(subject)
        messageTextfield!!.sendKeys(message)
        submitButton!!.click()
    }

    //Verify CourseViewPage is displayed
    fun courseViewPageIsDisplayed(): Boolean{
        return switchEditButton!!.isDisplayed
    }

    //Verify new announcement saved correctly
    fun verifyNewAnnouncement(): Boolean{
        val creationText: String = "Der Beitrag wurde erfolgreich eingefügt."
        val actualText: String = newAnnouncementCreationText!!.text
        return actualText.contains(creationText)
    }

}