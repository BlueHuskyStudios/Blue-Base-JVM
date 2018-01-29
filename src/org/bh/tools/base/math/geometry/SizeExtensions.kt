package org.bh.tools.base.math.geometry

import org.bh.tools.base.math.*
import java.util.*

/**
 * @author Ben Leggiero
 * @since 2018-03-22
 */

val java.awt.Dimension.sizeValue: IntegerSize get() = IntegerSize(width = width.integerValue, height = height.integerValue)
val IntegerSize.awtValue: java.awt.Dimension get() = java.awt.Dimension(width.int32Value, height.int32Value)



// MARK: - Silliness

/**
 * Generates some random point (x, y) where 0 <= x <= width and 0 <= y <= height.
 */
@Suppress("UNCHECKED_CAST") // checked transitively
fun <NumberType : Number> ComputableSize<NumberType>.randomPoint(): Point<NumberType> {
    val random = Random()

    return if (width.isNativeInteger && height.isNativeInteger) {
        Point(
                x = random.nextInteger(
                        minimumValue = minX.integerValue,
                        maximumValue = maxX.integerValue + 1
                ) as NumberType,
                y = random.nextInteger(
                        minimumValue = minY.integerValue,
                        maximumValue = maxY.integerValue + 1) as NumberType
        )
    } else if (width.isNativeFraction && height.isNativeFraction) {
        Point(
                x = (random.nextFraction() * (width.fractionValue + 1)) as NumberType,
                y = (random.nextFraction() * (height.fractionValue + 1)) as NumberType
        )
    } else {
        print("Type not supported: ${width::class} x ${width::class}")
        Point(
                x = width,
                y = height
        )
    }
}
