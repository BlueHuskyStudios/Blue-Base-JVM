@file:Suppress("unused")

package org.bh.tools.base.math.geometry

import org.bh.tools.base.math.*
import java.util.*

/**
 * @author Ben Leggiero
 * @since 2018-03-22
 */

val java.awt.Dimension.sizeValue get() = IntegerSize(width = width.integerValue, height = height.integerValue)
val IntegerSize.awtValue get() = java.awt.Dimension(width.int32Value, height.int32Value)



// MARK: - Silliness

/**
 * Generates some random point (x, y) where 0 <= x <= width and 0 <= y <= height.
 */
@Suppress("UNCHECKED_CAST") // checked transitively
fun IntegerSize.randomPoint(): IntegerPoint {
    val random = Random()

    return IntegerPoint(
            x = random.nextInteger(
                    minimumValue = minX,
                    maximumValue = maxX + 1
            ),
            y = random.nextInteger(
                    minimumValue = minY,
                    maximumValue = maxY + 1
            )
    )
}


/**
 * Generates some random point (x, y) where 0 <= x <= width and 0 <= y <= height.
 */
fun FractionSize.randomPoint(): FractionPoint {
    val random = Random()

    return FractionPoint(
            x = random.nextFraction(
                    minimumValue = minX,
                    maximumValue = maxX
            ),
            y = random.nextFraction(
                    minimumValue = minY,
                    maximumValue = maxY
            )
    )
}
