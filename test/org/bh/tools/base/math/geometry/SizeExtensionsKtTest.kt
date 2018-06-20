package org.bh.tools.base.math.geometry


import org.bh.tools.base.math.*
import org.bh.tools.base.util.*
import org.junit.*


/**
 * @author ben
 * @since 6/15/18.
 */
class SizeExtensionsKtTest {

    @Test
    fun randomPoint() {
        val numberOfRandomSamples = 10_000

        val onePixelInteger = IntegerSize(1, 1)
        val onePixelFraction = FractionSize(1, 1)
        val thirtyPixelInteger = IntegerSize(30, 30)
        val thirtyPixelFraction = FractionSize(30, 30)

        var onePixelIntegerEncompassment = FractionRect(onePixelInteger.fractionValue.midXmidY, FractionSize.zero)
        var onePixelFractionEncompassment = FractionRect(onePixelFraction.fractionValue.midXmidY, FractionSize.zero)
        var thirtyPixelIntegerEncompassment = FractionRect(thirtyPixelInteger.fractionValue.midXmidY, FractionSize.zero)
        var thirtyPixelFractionEncompassment = FractionRect(thirtyPixelFraction.fractionValue.midXmidY, FractionSize.zero)

        for (sampleIndex in 0..numberOfRandomSamples) {
            val onePixelIntegerRandomPoint = onePixelInteger.randomPoint()
            val onePixelFractionRandomPoint = onePixelFraction.randomPoint()
            val thirtyPixelIntegerRandomPoint = thirtyPixelInteger.randomPoint()
            val thirtyPixelFractionRandomPoint = thirtyPixelFraction.randomPoint()

            assertContains("", onePixelInteger, onePixelIntegerRandomPoint)
            assertContains("", onePixelFraction, onePixelFractionRandomPoint)
            assertContains("", thirtyPixelInteger, thirtyPixelIntegerRandomPoint)
            assertContains("", thirtyPixelFraction, thirtyPixelFractionRandomPoint)

            onePixelIntegerEncompassment = onePixelIntegerEncompassment.expanded(toInclude = onePixelIntegerRandomPoint.fractionValue)
            onePixelFractionEncompassment = onePixelFractionEncompassment.expanded(toInclude = onePixelFractionRandomPoint.fractionValue)
            thirtyPixelIntegerEncompassment = thirtyPixelIntegerEncompassment.expanded(toInclude = thirtyPixelIntegerRandomPoint.fractionValue)
            thirtyPixelFractionEncompassment = thirtyPixelFractionEncompassment.expanded(toInclude = thirtyPixelFractionRandomPoint.fractionValue)
        }

        assertEquals(FractionRect(FractionPoint.zero, onePixelInteger.fractionValue),
                     onePixelIntegerEncompassment,
                     tolerance = defaultCalculationTolerance)

        assertEquals(FractionRect(FractionPoint.zero, onePixelFraction),
                     onePixelFractionEncompassment,
                     tolerance = 0.001)

        assertEquals(FractionRect(FractionPoint.zero, thirtyPixelInteger.fractionValue),
                     thirtyPixelIntegerEncompassment,
                     tolerance = defaultCalculationTolerance)

        assertEquals(FractionRect(FractionPoint.zero, thirtyPixelFraction),
                     thirtyPixelFractionEncompassment,
                     tolerance = 0.05)
    }
}

