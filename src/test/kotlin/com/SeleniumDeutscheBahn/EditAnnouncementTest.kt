package com.SeleniumDeutscheBahn

import com.SeleniumDeutscheBahn.data.TestData
import com.SeleniumDeutscheBahn.pages.AnnouncementPage
import org.testng.annotations.Test

class EditAnnouncementTest : CreateAnnouncementTest() {

    @Test
    fun editAnnouncementTest(){
        var announcement = AnnouncementPage(driver!!)
        announcement.editAnnouncement(TestData.anncouncementSubject, " ", TestData.announcementMessage)
        announcement.verifyEditedAnnouncement()
    }

}