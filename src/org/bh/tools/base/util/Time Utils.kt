package org.bh.tools.base.util

import org.bh.tools.base.math.fractionValue
import org.bh.tools.base.util.TimeConversion.nanosecondsPerMillisecond
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
 * The number of seconds since the Java epoch: January 1st, 1970 at 00:00:00.0000
 */
val Instant.timeIntervalSinceJavaEpoch: TimeInterval get() {
    val millisecondsSinceJavaEpoch = toEpochMilli().fractionValue
    val nanosecondsSinceLastSecond = nano.fractionValue

    val nanosecondsSinceJavaEpoch = (millisecondsSinceJavaEpoch * nanosecondsPerMillisecond) + nanosecondsSinceLastSecond

    val secondsSinceJavaEpoch = TimeConversion.nanosecondsToTimeInterval(nanosecondsSinceJavaEpoch)

    arrayOf<String>().map { it }

    return secondsSinceJavaEpoch
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