package org.bh.tools.base.util

import java.time.Instant
import java.util.*

/**
 * Makes JVM time easier
 *
 * Depends on Blue Base/Core's `Time Utils.kt`
 *
 * @author Ben Leggiero
 * @since 2017-08-06
 */




/**
 * The number of seconds since the Java epoch: January 1st, 1970 at 00:00:00.0000 ±0000.00
 */
val Instant.timeIntervalSinceJavaEpoch: TimeInterval get() {
    val millisecondsSinceJavaEpoch = toEpochMilli().timeIntervalValue.asMilliseconds
    val nanosecondsSinceLastSecond = nano.timeIntervalValue.asNanoseconds

    return millisecondsSinceJavaEpoch.timeIntervalValue + nanosecondsSinceLastSecond.timeIntervalValue
}


/**
 * The number of seconds since the Java epoch: January 1st, 1970 at 00:00:00.0000
 */
val Date.timeIntervalSinceJavaEpoch: TimeInterval get() = toInstant().timeIntervalSinceJavaEpoch



/** Determines the time interval (in SI seconds) that has passed from the other date to this one */
fun Date.timeIntervalSince(other: Date): TimeInterval {
    val thisIntervalSinceJavaEpoch = this.timeIntervalSinceJavaEpoch
    val otherIntervalSinceJavaEpoch = other.timeIntervalSinceJavaEpoch

    return thisIntervalSinceJavaEpoch - otherIntervalSinceJavaEpoch
}


val Date.timeIntervalSinceNow: TimeInterval get() = timeIntervalSince(Date())
