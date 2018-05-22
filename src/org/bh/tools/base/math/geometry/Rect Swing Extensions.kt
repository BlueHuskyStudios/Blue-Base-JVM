package org.bh.tools.base.math.geometry

import org.bh.tools.base.math.*
import java.awt.Rectangle
import org.bh.tools.base.math.geometry.Rect
import java.awt.geom.*


/*
 * @author Ben Leggiero
 * @since 2018-03-01
 */



val IntegerRect.awtValue: Rectangle get() = Rectangle(x.int32Value, y.int32Value, width.int32Value, height.int32Value)
val java.awt.Rectangle.integerValue: IntegerRect get() = IntegerRect(x = x.integerValue, y = y.integerValue, width = width.integerValue, height = height.integerValue)




operator fun FractionRect.Companion.invoke(awtValue: Rectangle2D) = FractionRect(awtValue.x, awtValue.y, awtValue.width, awtValue.height)
val FractionRect.awtValue: Rectangle2D get() = Rectangle2D.Double(x, y, width, height)

val java.awt.Rectangle.fractionValue: FractionRect get() = FractionRect(x = x, y = y, width = width, height = height)
