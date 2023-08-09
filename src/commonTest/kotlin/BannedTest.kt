package org.example

import kotlin.test.Test
import kotlin.test.fail

class BannedTest {
    @Test
    fun test() {
        fail("Should not be invoked")
    }
}
