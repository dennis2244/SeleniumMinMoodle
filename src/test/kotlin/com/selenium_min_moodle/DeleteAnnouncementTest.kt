package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.AnnouncementPage
import org.testng.annotations.Test

class DeleteAnnouncementTest : CreateAnnouncementTest() {

    @Test
    fun deleteAnnouncement(){
        var announcementPage = AnnouncementPage(driver!!)
        announcementPage.deleteAnnouncement(TestData.anncouncementSubject)
    }

}