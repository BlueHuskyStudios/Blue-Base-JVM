package org.bh.tools.base.math.geometry



/*
 * Extending [Point]
 *
 * @author Ben Leggiero
 * @since 2018-03-22
 */


operator fun FractionPoint.Companion.invoke(awtValue: java.awt.geom.Point2D) = FractionPoint(awtValue.x, awtValue.y)
operator fun FractionPoint.Companion.invoke(fxValue: javafx.geometry.Point2D) = FractionPoint(fxValue.x, fxValue.y)



val java.awt.Point.fractionValue get() = FractionPoint(this)
val javafx.geometry.Point2D.fractionValue get() = FractionPoint(this)
