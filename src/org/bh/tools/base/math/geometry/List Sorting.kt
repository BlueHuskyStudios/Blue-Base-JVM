package org.bh.tools.base.math.geometry

import org.bh.tools.base.math.*
import java.util.*


/*
 * To sort lists
 *
 * @author Ben Leggiero
 * @since 2018-03-22
 */



private fun <Content> List<Content>.sortedQueueValue(sorter: ComparatorBlock<Content>): Queue<Content> {
    val x = PriorityQueue<Content> { lhs, rhs ->
        when {
            lhs == null -> ComparisonResult.right
            rhs == null -> ComparisonResult.left
            else -> sorter(lhs, rhs)
        }
                .nativeValue
    }
    x.addAll(this)
    return x
}


inline fun <ContentType> List<ContentType>.sorted(crossinline sorter: ComparatorBlock<ContentType>): List<ContentType> =
        this.sortedWith(kotlin.Comparator<ContentType> { lhs, rhs ->
            (
                    if (lhs == null) ComparisonResult.right
                    else if (rhs == null) ComparisonResult.left
                    else sorter(lhs, rhs)
                    ).nativeValue
        })

