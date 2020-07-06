package com.selenium_min_moodle.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait



class UploadFilePage(driver:WebDriver) {
    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//*[contains(text(),'Datei zu ')]")
    var pageHeader: WebElement? = null

    @FindBy(id = "id_name")
    var fileNameInputField: WebElement? = null

    @FindBy(id = "id_introeditoreditable")
    var fileDescriptionInputField: WebElement? = null

    //@FindBy(xpath = "//*[@title='Datei hinzufügen']")
    @FindBy(className = "dndupload-arrow")
    var addFileBtn: WebElement? = null

    @FindBy(id = "fileurl")
    var fileurlInputElement: WebElement? = null

    @FindBy(xpath = "(//*[starts-with(@class,'fp-login-submit') and contains(text(), 'Download')])")
    var downloadBtn: WebElement? = null

    @FindBy(id = "id_submitbutton2")
    var submitbtn2: WebElement? = null

    @FindBy(className = "fp-reficons2")
    var imageWidget: WebElement? = null

    @FindBy(xpath = "(//*[starts-with(@class,'fp-select-confirm') and contains(text(), 'Datei auswählen')])")
    var confirmSelectBtn: WebElement? = null

    fun enterName(name:String){
        fileNameInputField!!.sendKeys(name)
    }

    fun enterDescription(description:String){
       fileDescriptionInputField!!.sendKeys(description)
    }

    fun uploadFileByUrl(Url:String){
       addFileBtn!!.click()
       var elements: WebElement = webDriver!!.findElement(By.partialLinkText("URL-Downloader"))
       elements.click()

       fileurlInputElement!!.sendKeys(Url)
       downloadBtn!!.click()
       imageWidget!!.click()
       confirmSelectBtn!!.click()
    }

    fun hitSubmit(){
       val wait = WebDriverWait(webDriver, 5)
       submitbtn2 = wait.until(ExpectedConditions.elementToBeClickable(submitbtn2))
       submitbtn2!!.click()
    }


}