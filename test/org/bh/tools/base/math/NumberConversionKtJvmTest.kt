package org.bh.tools.base.math


import org.bh.tools.base.collections.extensions.*
import org.bh.tools.base.strings.*
import org.junit.*
import java.math.*


/**
 * Includes JVM-specific tests mirroring those in Blue Base/Core
 *
 * @author Ben Leggiero
 * @since 2017-03-22
 */
class NumberConversionKtJvmTest: NumberConversionKtTest() {

    val sampleBigDecimals: List<BigDecimal> = sampleFloat64s.map { BigDecimal(it.toString()) }
    val sampleBigIntegers: List<BigInteger> = sampleBigDecimals.map { it.toBigInteger() }

    override val allSamples: List<Number> = super.allSamples +
            sampleBigIntegers + sampleBigDecimals

    init {
        println("Evaluating ${allSamples.length.toString(separator = ",")} sample numbers...")
    }


    @Test
    override fun Number_float32Value() {
        allSamples.forEach {
            assertNumbersClose("Original number should equal float 32 value",
                               it, it.float32Value
            )
        }
    }


    @Test
    override fun Number_float64Value() {
        allSamples.forEach {
            assertNumbersClose("Original number should equal float 64 value",
                               it, it.float64Value
            )
        }
    }

    // TODO: All these:

    @Test
    override fun Number_fractionValue() {

    }


    @Test
    override fun toByteChecked() {

    }


    @Test
    override fun toShortChecked() {

    }


    @Test
    override fun toIntChecked() {

    }


    @Test
    override fun toLongChecked() {

    }


    @Test
    override fun getInt8Value() {

    }


    @Test
    override fun getInt16Value() {

    }


    @Test
    override fun getInt32Value() {

    }


    @Test
    override fun getInt64Value() {

    }


    @Test
    override fun getIntegerValue() {

    }


    @Test
    override fun integerValue() {

    }


    @Test
    override fun isNativeInteger() {

    }


    @Test
    override fun isNativeFraction() {

    }


    @Test
    override fun getClampedIntegerValue() {

    }


    @Test
    override fun getClampedInt64Value() {

    }


    @Test
    override fun getClampedInt32Value() {

    }


    @Test
    override fun getClampedInt162Value() {

    }


    @Test
    override fun getClampedInt8Value() {

    }


    @Test
    override fun getClampedInt32Value1() {

    }


    @Test
    override fun getClampedInt16Value() {

    }


    @Test
    override fun getClampedInt8Value1() {

    }


    @Test
    override fun getClampToPositive() {

    }


    @Test
    override fun getClampToPositive1() {

    }


    @Test
    override fun getClampToPositive2() {

    }


    @Test
    override fun getClampToPositive3() {

    }


    @Test
    override fun getClampToPositive4() {

    }


    @Test
    override fun getClampToPositive5() {

    }


    @Test
    override fun int8ArrayOf() {

    }


    @Test
    override fun int16ArrayOf() {

    }


    @Test
    override fun int32ArrayOf() {

    }


    @Test
    override fun int64ArrayOf() {

    }


    @Test
    override fun integerArrayOf() {

    }


    @Test
    override fun float32ArrayOf() {

    }


    @Test
    override fun float64ArrayOf() {

    }


    @Test
    override fun fractionArrayOf() {

    }


    @Test
    override fun toInt8Array() {

    }


    @Test
    override fun toInt16Array() {

    }


    @Test
    override fun toInt32Array() {

    }


    @Test
    override fun toInt64Array() {

    }


    @Test
    override fun toIntegerArray() {

    }


    @Test
    override fun toFloat32Array() {

    }


    @Test
    override fun toFloat64Array() {

    }


    @Test
    override fun toFractionArray() {

    }


    @Test
    override fun getInt8Value1() {

    }


    @Test
    override fun getInt8Value2() {

    }


    @Test
    override fun getInt8Value3() {

    }


    @Test
    override fun getInt8Value4() {

    }


    @Test
    override fun getInt16Value1() {

    }


    @Test
    override fun getInt16Value2() {

    }


    @Test
    override fun getInt16Value3() {

    }


    @Test
    override fun getInt16Value4() {

    }


    @Test
    override fun getInt32Value1() {

    }


    @Test
    override fun getInt32Value2() {

    }


    @Test
    override fun getInt32Value3() {

    }


    @Test
    override fun getInt32Value4() {

    }


    @Test
    override fun getInt64Value1() {

    }


    @Test
    override fun getInt64Value2() {

    }


    @Test
    override fun getInt64Value3() {

    }


    @Test
    override fun getInt64Value4() {

    }


    @Test
    override fun getIntegerValue1() {

    }


    @Test
    override fun getIntegerValue2() {

    }


    @Test
    override fun getIntegerValue3() {

    }


    @Test
    override fun getIntegerValue4() {

    }


    @Test
    override fun getFloat32Value1() {

    }


    @Test
    override fun getFloat32Value2() {

    }


    @Test
    override fun getFloat64Value1() {

    }


    @Test
    override fun getFloat64Value2() {

    }


    @Test
    override fun getFractionValue1() {

    }


    @Test
    override fun getFractionValue2() {

    }
}
