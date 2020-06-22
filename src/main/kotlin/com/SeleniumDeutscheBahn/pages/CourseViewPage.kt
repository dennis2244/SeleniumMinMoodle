package com.SeleniumDeutscheBahn.pages

import net.bytebuddy.asm.Advice
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory
import java.util.concurrent.TimeUnit

class CourseViewPage(driver:WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(xpath="//*[contains(@id, 'single_button')]")
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

    @FindBy(xpath = "(//span[contains(@class,'section-modchooser-text') and contains(text(), 'Aktivität oder Material anlegen')])[2]")
    //*[@id="yui_3_17_2_1_1592160051238_1031"]
    val createActivityOrMaterialLink: WebElement? = null

    @FindBy(xpath = "(//*[starts-with(@id,'moodle-dialogue-') and contains(@class, 'moodle-dialogue-hd')])")
    val menuHeader: WebElement? = null

    @FindBy(id = "item_assign")
    val taskField: WebElement? = null

    @FindBy(xpath = "(//span[contains(@class,'instancename') and contains(text(), 'Testaufgabe Nummer 1')])")
    val testAufgabe1: WebElement? = null

    //@FindBy(xpath = "(//*[contains(@name,'submitbuttonn') and contains(@value, 'Hinzufügen')])")
    //val menuSubmitButton: WebElement? = null


    //Wechselt den Bearbeitungsmodus
    fun switchEditMode(mode: String){


        when (mode) {
               "active" -> if(switchEditButton!!.text.equals("Bearbeiten einschalten")){
                   switchEditButton.click()
               }
               "disabled" -> if(switchEditButton!!.text.equals("Bearbeiten ausschalten")) {
                   switchEditButton.click()
               }

        }


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

    fun createMaterialOrActivity(){
        createActivityOrMaterialLink!!.click()
        Thread.sleep(10000)

    }

    fun selectAufgabe(){
        taskField!!.click()
    }

    fun submitChoices(){
        submitButton!!.click()
    }


}