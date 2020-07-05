package com.selenium_min_moodle.data

class TestData {

    companion object {
        //@JvmStatic
        //Login Daten
        const val username: String = ""
        const val password: String = ""

        //Vergleichtexte auf der GUI
        const val meineKurse: String = "Meine Kurse"
        const val bearbeitenEinschalten: String = "Bearbeiten einschalten"
        const val bearbeitenAusschalten: String = "Bearbeiten ausschalten"
        const val creationText: String = "Der Beitrag wurde erfolgreich eingefügt."
        const val announcementEditText1: String = "Beitrag von"
        const val announcementEditText2: String = "wurde aktualisiert"
        const val languageDeutsch = "deutsch"
        const val languageEnglish = "englisch"

        //Eingabedaten über die GUI
        const val anncouncementSubject: String = "Testautomatisierung"
        const val announcementMessage: String = "Das hier ist die Nachricht."

        const val taskName: String = "Testaufgabe Nummer 1"
        const val taskDescription: String = "Beispieltask zu Selenium Webdriver"
        const val dueDate: String = "12"
        const val dueMonth: String = "7"
        const val gradindDueDay: String = "25"

        const val fileName: String = "Logo"
        const val fileDescription: String = "Selenium Logo"
        const val uploadFileUrl: String = "https://www.qytera.de/sites/default/files/styles/large/public/field/image/big-logo.png?itok=R5Fx3Cp4"

        //Setup Daten
        const val url: String = "https://lernen.min.uni-hamburg.de/login/index.php"
        const val pathToFirefoxDriver: String = ".\\src\\test\\resources\\drivers\\geckodriver.exe"
        const val pathToChromeDriver: String = ".\\src\\test\\resources\\drivers\\chromedriver.exe"
        const val pathToReportFolder: String = ".\\src\\test\\resources\\testreports\\"
        const val browser: String = "chrome"
    }
}