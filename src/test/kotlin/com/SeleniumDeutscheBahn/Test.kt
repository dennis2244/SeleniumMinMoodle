package com.SeleniumDeutscheBahn

import org.testng.annotations.Test

class Test : Base(){

    @Test
    fun getStarted() {
        test = extent!!.createTest("Testname")

    }
}