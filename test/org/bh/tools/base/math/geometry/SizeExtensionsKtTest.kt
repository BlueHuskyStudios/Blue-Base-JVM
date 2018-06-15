package org.bh.tools.base.math.geometry


import org.bh.tools.base.util.*
import org.junit.*


/**
 * @author ben
 * @since 6/15/18.
 */
class SizeExtensionsKtTest {

    @Test
    fun randomPoint() {
        val onePixelInteger = IntegerSize(1, 1)
        val onePixelFloat = IntegerSize(1, 1)
        val thirtyPixelInteger = IntegerSize(30, 30)
        val thirtyPixelFloat = IntegerSize(30, 30)

        val numberOfRandomSamples = 5000

        for (sampleIndex in 0..numberOfRandomSamples) {
            val onePixelIntegerRandomPoint = onePixelInteger.randomPoint()
            val onePixelFloatRandomPoint = onePixelFloat.randomPoint()
            val thirtyPixelIntegerRandomPoint = thirtyPixelInteger.randomPoint()
            val thirtyPixelFloatRandomPoint = thirtyPixelFloat.randomPoint()

            assertContains("", onePixelInteger, onePixelIntegerRandomPoint)
            assertContains("", onePixelFloat, onePixelFloatRandomPoint)
        }
    }
}