package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.UploadFilePage
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