package org.bh.tools.base

import org.bh.tools.base.abstraction.Fraction
import org.bh.tools.base.math.*
import org.bh.tools.base.math.RoundingDirection.*
import org.bh.tools.base.math.RoundingThreshold.*
import java.math.*
import java.math.RoundingMode.*

/**
 * @author Ben Leggiero
 * @since 2017-08-06
 */



/**
 * Finds the [java.math.RoundingMode] appropriate the given [Fraction], [RoundingDirection], and [RoundingThreshold]
 *
 * @param fraction The fraction for which the rounding mode will be used
 * @param direction _optional_ - The direction in which rounding will occur.
 *                  Defaults to [default][RoundingDirection.default]
 * @param threshold _optional_ - The part of the number that will trigger a different result.
 *                  Defaults to [default][RoundingThreshold.default]
 */
fun RoundingMode(fraction: Fraction,
                 direction: RoundingDirection = RoundingDirection.default,
                 threshold: RoundingThreshold = RoundingThreshold.default
): RoundingMode = when (threshold) {
    halfway -> when (direction) {
        up -> if (fraction > 0) HALF_UP else HALF_DOWN
        down -> if (fraction > 0) HALF_DOWN else HALF_UP
        awayFromZero -> HALF_UP
        towardZero -> HALF_DOWN
    }
    integer -> when (direction) {
        up -> CEILING
        down -> FLOOR
        awayFromZero -> if (fraction > 0) CEILING else FLOOR
        towardZero -> if (fraction > 0) FLOOR else CEILING
    }
}


/**
 * Returns the rounded version of this fraction.
 * If `this` `isNaN()` or `isInfinity()`, it's returned immediately without changing the value.
 *
 * @param direction The direction to round
 * @param threshold      Describes at what part of the number the rounding should occur
 *
 * @return This number rounded, or unchanged if it's already an integer, infinite, or Not a Number.
 */
fun Fraction.preciselyRounded(direction: RoundingDirection = RoundingDirection.default,
                     threshold: RoundingThreshold = RoundingThreshold.default): Fraction =
        if (isNaN() || isInfinite() || !hasFractionComponent) this
        else BigDecimal(this, MathContext.DECIMAL64).setScale(0, RoundingMode(this, direction, threshold)).fractionValue