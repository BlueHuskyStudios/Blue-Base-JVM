package org.bh.tools.base.math.geometry

import org.bh.tools.base.math.*


/*
 * @author Ben Leggiero
 * @since 2018-03-01
 */



val IntegerRect.awtValue get() = java.awt.Rectangle(x.int32Value, y.int32Value, width.int32Value, height.int32Value)
val java.awt.Rectangle.integerValue get() = IntegerRect(x = x.integerValue, y = y.integerValue, width = width.integerValue, height = height.integerValue)



operator fun FractionRect.Companion.invoke(awtValue: java.awt.geom.Rectangle2D) = FractionRect(awtValue.x, awtValue.y, awtValue.width, awtValue.height)
val FractionRect.awtValue get() = java.awt.geom.Rectangle2D.Double(x, y, width, height)

val java.awt.Rectangle.fractionValue get() = FractionRect(x = x, y = y, width = width, height = height)
