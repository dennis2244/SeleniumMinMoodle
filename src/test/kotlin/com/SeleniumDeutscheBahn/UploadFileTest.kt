package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.data.TestData
import com.SeleniumDeutscheBahn.pages.CourseViewPage
import com.SeleniumDeutscheBahn.pages.CreateTaskPage
import com.SeleniumDeutscheBahn.pages.UploadFilePage
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.Test

class UploadFileTest: Base() {

    @Test
    fun uploadFile() {
        var courseViewPage: CourseViewPage = CourseViewPage(driver!!)

        Assert.assertTrue(courseViewPage.courseViewPageIsDisplayed())

        courseViewPage.switchEditMode("active")

        courseViewPage.createMaterialOrActivity()
        //manueller Click erforderlich

        Assert.assertTrue(courseViewPage.menuHeader!!.isDisplayed)

        courseViewPage.selectFileUpload()

        Assert.assertTrue(courseViewPage.submitButton!!.isDisplayed)

        courseViewPage.submitChoices()

        var uploadFilePage: UploadFilePage = UploadFilePage(driver!!)
        Assert.assertTrue(uploadFilePage.pageHeader!!.isDisplayed)

        uploadFilePage.enterName(TestData.fileName)
        uploadFilePage.enterDescription(TestData.fileDescription)
        //manueller Klick auf File Icon und Auswahl von URL Download
        uploadFilePage.uploadFileByUrl(TestData.uploadFileUrl)

        uploadFilePage.hitSubmit()

    }
}