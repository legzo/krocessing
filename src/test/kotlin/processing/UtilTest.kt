package processing

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UtilTest {

    @Test
    fun testPairs() {
        val pairs = listOf(1,2,3).pairwise
        assertEquals(pairs.size, 2)
        assertEquals(pairs, listOf(1 to 2, 2 to 3))
    }
}
