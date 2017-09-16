@file:Suppress("unused")

package org.bh.tools.base.collections

import org.bh.tools.base.collections.extensions.removeFirst


/*
 * JVM extensions of Blue Base/Core's Queue
 *
 * @author Ben Leggiero
 * @since 2017-07-30
 */


/**
 * Creates a new [java.util.Queue] out of this Blue Base Queue
 */
fun <Element> org.bh.tools.base.collections.Queue<Element>.javaQueueValue(): java.util.Queue<Element> {
    val mutableListCopy: MutableList<Element> = this.mutableListValue()
    return object: java.util.Queue<Element> {
        override val size: Int get() = mutableListCopy.size

        override fun contains(element: Element): Boolean = mutableListCopy.contains(element)

        override fun containsAll(elements: Collection<Element>): Boolean = mutableListCopy.containsAll(elements)

        override fun addAll(elements: Collection<Element>): Boolean = mutableListCopy.addAll(elements)

        override fun clear() = mutableListCopy.clear()

        override fun iterator(): MutableIterator<Element> = mutableListCopy.listIterator()

        override fun remove(element: Element): Boolean = mutableListCopy.remove(element)

        override fun remove(): Element = mutableListCopy.removeFirst()!!

        override fun isEmpty(): Boolean = mutableListCopy.isEmpty()

        override fun removeAll(elements: Collection<Element>): Boolean = mutableListCopy.removeAll(elements)

        override fun retainAll(elements: Collection<Element>): Boolean = mutableListCopy.retainAll(elements)

        override fun add(element: Element): Boolean = mutableListCopy.add(element)

        override fun offer(e: Element): Boolean = mutableListCopy.add(e)

        override fun poll(): Element? = mutableListCopy.removeFirst()

        override fun element(): Element = mutableListCopy.first()!!

        override fun peek(): Element? = mutableListCopy.first()
    }
}
