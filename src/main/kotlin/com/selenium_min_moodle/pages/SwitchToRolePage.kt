package com.selenium_min_moodle.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.WebElement
import java.util.concurrent.TimeUnit

class SwitchToRolePage(driver: WebDriver) {

    var webDriver: WebDriver? = null

    init {
        this.webDriver = driver
        PageFactory.initElements(driver!!, this)
    }

    @FindBy(xpath= "//*[contains(@class, 'btn btn-secondary') and contains(text(), 'Trainer/in ohne Bearbeitungsrecht')]")
    val nonEditingTeacherRoleButton: WebElement? = null

    @FindBy(xpath="//*[contains(@class, 'btn btn-secondary') and contains(text(), 'Teilnehmer/in')]")
    val studentRoleButton: WebElement? = null

    @FindBy(xpath= "//*[contains(@class, 'btn btn-secondary') and contains(text(), 'Gast')]")
    val guestRoleButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@class, 'meta role role-gast')]")
    val currentRole: WebElement? = null

    fun verifyPage(): Boolean{
        return studentRoleButton!!.isDisplayed
        webDriver!!.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
    }

    //Welchselt die Rolle des Users
    fun switchRole(role: String){
        when(role){
            "Trainer" -> nonEditingTeacherRoleButton!!.click()
            "Teilnehmer" -> studentRoleButton!!.click()
            "Gast" ->  guestRoleButton!!.click()
        }
    }

    //Überprüft die geänderte Rolle (Trainer/in ohne Bearbeitungsrecht, Gast, Teilnehmer/in
    fun verifyCurrentRole(role:String): Boolean{
        return currentRole!!.text.contains("$role")
    }

}