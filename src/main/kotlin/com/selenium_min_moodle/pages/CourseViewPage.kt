package com.selenium_min_moodle.pages

import com.selenium_min_moodle.data.TestData
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class CourseViewPage(driver:WebDriver) {
    var webDriver: WebDriver? = null
    private val searchQueryACtion: String = "//*[contains(text(), "

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

    @FindBy(id = "item_resource")
    val fileField: WebElement? = null

    @FindBy(xpath = "(//span[contains(@class,'instancename') and contains(text(), 'Testaufgabe Nummer 1')])")
    val testAufgabe1: WebElement? = null

    @FindBy(id = "action-menu-toggle-2")
    val actionMenue: WebElement? = null

    @FindBy(id = "action-menu-2-menu")
    val actionElements: WebElement? = null

    @FindBy(id = "action-menu-1-menubar")
    val userMenue: WebElement? = null

    @FindBy(id = "actionmenuaction-7")
    val menueSwitchToRole: WebElement? = null

    //@FindBy(xpath = "(//*[contains(@name,'submitbuttonn') and contains(@value, 'Hinzufügen')])")
    //val menuSubmitButton: WebElement? = null


    //Wechselt den Bearbeitungsmodus
    fun switchEditMode(mode: String){


        when (mode) {
               "active" -> if(switchEditButton!!.text.equals(TestData.bearbeitenEinschalten)){
                   switchEditButton.click()
               }
               "disabled" -> if(switchEditButton!!.text.equals(TestData.bearbeitenAusschalten)) {
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
        val actualText: String = newAnnouncementCreationText!!.text
        return actualText.contains(TestData.creationText)
    }

    fun createMaterialOrActivity(){
        createActivityOrMaterialLink!!.click()
        Thread.sleep(10000)

    }

    fun selectAufgabe(){
        taskField!!.click()
    }

    fun selectFileUpload(){
        fileField!!.click()
    }

    fun submitChoices(){
        submitButton!!.click()
    }

    fun selectActionViaDropDown(action: String){
        var wait = WebDriverWait(webDriver!!, 3)
        wait.until(ExpectedConditions.elementToBeClickable(actionMenue))
        actionMenue!!.click()

        webDriver!!.findElement(By.xpath("$searchQueryACtion '$action')]")).click()

        }

    fun navigateToSwitchToRolePage(){
        userMenue!!.click()
        menueSwitchToRole!!.click()
    }

    fun resetRole(){
        navigateToSwitchToRolePage()
    }

}