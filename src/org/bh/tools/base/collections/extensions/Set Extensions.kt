package org.bh.tools.base.collections.extensions

import org.bh.tools.base.abstraction.Int32

/*
 * @author Kyli Rouge
 * @since 2017-06-11
 */

fun <E> HashSet(size: Int32, init: (Int32) -> E): HashSet<E> {
    return HashSet(List(size = size, init = init))
}
