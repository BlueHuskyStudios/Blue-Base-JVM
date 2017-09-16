package org.bh.tools.base.collections.extensions

import java.util.*

/**
 * Makes using arrays in the JVM easier
 *
 * @author Ben Leggiero
 * @since 2017-08-06
 */



fun <T> Array<T>.deepEquals(other: Array<T>): Boolean {
    return Arrays.deepEquals(this, other)
}
