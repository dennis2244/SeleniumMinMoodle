package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.data.TestData
import com.SeleniumDeutscheBahn.pages.AnnouncementPage
import org.testng.annotations.Test

class DeleteAnnouncementTest : CreateAnnouncementTest() {

    @Test
    fun deleteAnnouncement(){
        var announcementPage = AnnouncementPage(driver!!)
        announcementPage.deleteAnnouncement(TestData.anncouncementSubject)
    }

}