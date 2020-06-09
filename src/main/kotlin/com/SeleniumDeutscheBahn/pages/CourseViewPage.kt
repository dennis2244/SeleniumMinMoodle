package com.SeleniumDeutscheBahn.pages

import org.openqa.selenium.WebDriver

class CourseViewPage(driver:WebDriver) {

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
    fun newAnnouncement(subject: String, message: String){

    }

}