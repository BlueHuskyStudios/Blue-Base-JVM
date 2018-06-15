@file:Suppress("unused")

package org.bh.tools.base.math

import org.bh.tools.base.abstraction.*
import org.bh.tools.base.struct.*
import java.util.*

/*
 * Random != funny
 * But `Random` == `fun` with this file!
 *
 * @author Ben Leggiero
 * @since 2017-02-19
 */



/**
 * Finds a pseudorandom fraction between the given minimum and maximum values, inclusively.
 *
 * @param minimumValue _optional_ - The lowest possible returned value. Defaults to `0`
 * @param maximumValue The highest possible returned value
 */
fun Random.nextFraction(minimumValue: Fraction = 0.0, maximumValue: Fraction) =
        nextFraction(bounds = OpenRange(startInclusive = minimumValue, endInclusive = maximumValue))


/**
 * Finds a pseudorandom fraction value in the given bounds, inclusively. An open bound indicates infinity.
 */
fun Random.nextFraction(bounds: OpenRange<Fraction>): Fraction {

    val closedRange = ClosedRange(
            start = bounds.startInclusive ?: -Fraction.greatestFiniteMagnitude,
            endInclusive = bounds.endInclusive ?: Fraction.greatestFiniteMagnitude)

    val r = nextFraction() // 0.0 to 1.0
    return ((r * closedRange.size) + closedRange.min)
}


/**
 * Finds a pseudorandom integer between the given minimum and maximum values, inclusively.
 *
 * @param minimumValue _optional_ - The lowest possible returned value. Defaults to `0`
 * @param maximumValue The highest possible returned value
 */
fun Random.nextInteger(minimumValue: Integer = 0, maximumValue: Integer) =
        nextInteger(OpenRange(startInclusive = minimumValue, endInclusive = maximumValue))


/**
 * Finds a pseudorandom integer within the given bounds, inclusively. An open bound indicates infinity.
 */
fun Random.nextInteger(bounds: OpenRange<Integer>) = nextFraction(bounds.fractionValue).integerValue


/**
 * Finds a pseudorandom integer, not kept within any bounds; between the lowest and the highest possible values.
 *
 * @see Int.MIN_VALUE
 * @see Int.MAX_VALUE
 */
fun Random.nextInteger() = nextInteger(bounds = OpenRange.infiniteRange())


/**
 * @see Random.nextDouble
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Random.nextFraction(): Fraction = nextDouble()
