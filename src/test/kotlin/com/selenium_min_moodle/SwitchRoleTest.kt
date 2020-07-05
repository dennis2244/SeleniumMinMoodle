package com.selenium_min_moodle

import com.selenium_min_moodle.data.TestData
import com.selenium_min_moodle.pages.CourseViewPage
import com.selenium_min_moodle.pages.SwitchToRolePage
import org.testng.Assert
import org.testng.annotations.Test

class SwitchRoleTest : Base() {

    @Test
    fun switchRole(){
       val switchRole = SwitchToRolePage(driver!!)
       val courseView = CourseViewPage(driver!!)

        courseView.navigateToSwitchToRolePage()
        switchRole.verifyPage()
        switchRole.switchRole(TestData.switchRole)

        Assert.assertTrue(switchRole.verifyCurrentRole(TestData.switchRole))

        courseView.resetRole()
    }
}