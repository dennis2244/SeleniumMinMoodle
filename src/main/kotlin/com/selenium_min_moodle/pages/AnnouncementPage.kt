package com.selenium_min_moodle.pages

import com.selenium_min_moodle.data.TestData
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class AnnouncementPage (driver: WebDriver) {
    var webDriver: WebDriver? = null
    private val searchQuery: String = "//a[contains(@class,'w-100 h-100 d-block') and contains(text() "

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(xpath = "(//a[contains(@class,'btn btn-link') and contains(text(), 'Löschen')])")
    val deleteButton: WebElement? = null

    @FindBy(xpath = "(//a[contains(@class,'btn btn-link') and contains(text(), 'Bearbeiten')])")
    val editButton: WebElement? = null

    @FindBy(xpath="//*[contains(@class, 'btn btn-primary')]")
    val submitButton: WebElement? = null

    @FindBy(name="subject")
    val subjectTextfield: WebElement? = null

    @FindBy(id="id_messageeditable")
    val messageTextfield: WebElement? = null

    @FindBy(id="id_submitbutton")
    val submitChanges: WebElement? = null

    @FindBy(id="user-notifications")
    val userNotification: WebElement? = null


    //Löscht die übergebene Ankündigung
    fun deleteAnnouncement(annoucement: String){
        clickAnnouncementInTable(annoucement)
        var wait = WebDriverWait(webDriver!!, 3)
        wait.until(ExpectedConditions.elementToBeClickable(editButton))

        deleteButton!!.click()
        submitButton!!.click()
    }

    //Bearbeitete eine Ankündigung
    fun editAnnouncement(annoucement: String, subject: String, message: String){
        clickAnnouncementInTable(annoucement)
        var wait = WebDriverWait(webDriver!!, 3)
        wait.until(ExpectedConditions.elementToBeClickable(editButton))

        editButton!!.click()
        subjectTextfield!!.sendKeys(subject!!)
        messageTextfield!!.clear()
        messageTextfield!!.sendKeys(message!!)
        submitChanges!!.click()
    }

    //Hilfsmethode zum Ankicken der Ankündigung in der Tabelle
    fun clickAnnouncementInTable(announcement: String){
        val tableElement: WebElement? = webDriver!!.findElement(By.xpath(
            "($searchQuery, '$announcement')])"))

        tableElement!!.click()
    }

    fun verifyEditedAnnouncement(): Boolean{
       val messageText: String = userNotification!!.text
        return messageText.contains(TestData.announcementEditText1 + TestData.announcementEditText2)
    }
}
