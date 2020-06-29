package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.AnnouncementPage
import org.testng.annotations.Test

class EditAnnouncementTest : CreateAnnouncementTest() {

    @Test
    fun editAnnouncementTest(){
        var announcement = AnnouncementPage(driver!!)
        announcement.editAnnouncement(TestData.anncouncementSubject, " ", TestData.announcementMessage)
        announcement.verifyEditedAnnouncement()
    }

}