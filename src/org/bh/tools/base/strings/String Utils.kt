package org.bh.tools.base.strings

/*
 * Helps you with strings in the JVM
 *
 * @author Ben Leggiero
 * @since 2017-08-19
 */


/**
 * Allows `+=` to be used as shorthand for [StringBuilder.append]
 */
infix operator fun StringBuilder.plusAssign(rhs: Any) {
    this.append(rhs)
}


/**
 * Concatenates the [CharSequence] value of `lhs` before `rhs` and returns the result. The exact type of the returned
 * value is not guaranteed.
 */
fun concat(lhs: Any, rhs: CharSequence): CharSequence = when (lhs) {
    is String -> lhs + rhs
    is StringBuilder -> lhs.append(rhs)
    else -> StringBuilder().append(lhs).append(rhs)
}
