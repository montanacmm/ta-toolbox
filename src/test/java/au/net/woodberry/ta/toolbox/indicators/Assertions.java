/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Marc de Verdelhan & respective authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package au.net.woodberry.ta.toolbox.indicators;

import au.net.woodberry.ta.toolbox.indicators.trend.GuppyMultipleMovingAverage;
import eu.verdelhan.ta4j.TADecimal;
import org.assertj.core.data.Offset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Utility class for {@code TADecimal} tests.
 */
public class Assertions {

    /** Offset for double equality checking */
    public static final Offset<Double> TA_OFFSET = Offset.offset(0.0001);

    /**
     * Verifies that the actual {@code TADecimal} value is equal to the given {@code String} representation.
     * @param actual the actual {@code TADecimal} value
     * @param expected the given {@code String} representation to compare the actual value to
     * @throws AssertionError if the actual value is not equal to the given {@code String} representation
     */
    public static void assertDecimalEquals(TADecimal actual, String expected) {
        if (expected != null) {
            assertNotNull(actual);
            assertThat(actual).isEqualTo(TADecimal.valueOf(expected));
        } else {
            assertNull(actual);
        }
    }

    /**
     * Verifies that the actual {@code TADecimal} value is equal to the given {@code Integer} representation.
     * @param actual the actual {@code TADecimal} value
     * @param expected the given {@code Integer} representation to compare the actual value to
     * @throws AssertionError if the actual value is not equal to the given {@code Integer} representation
     */
    public static void assertDecimalEquals(TADecimal actual, Integer expected) {
        if (expected != null) {
            assertNotNull(actual);
            assertThat(actual).isEqualTo(TADecimal.valueOf(expected));
        } else {
            assertNull(actual);
        }
        
    }

    /**
     * Verifies that the actual {@code TADecimal} value is equal (within a positive offset) to the given {@code Double} representation.
     * @param actual the actual {@code TADecimal} value
     * @param expected the given {@code Double} representation to compare the actual value to
     * @throws AssertionError if the actual value is not equal to the given {@code Double} representation
     */
    public static void assertDecimalEquals(TADecimal actual, Double expected) {
        if (expected != null) {
            assertNotNull(actual);
            assertThat(actual.toDouble()).isEqualTo(expected, TA_OFFSET);
        } else {
            assertNull(actual);
        }
    }

    public static void assertGuppyMultipleMovingAverage(GuppyMultipleMovingAverage.Object gmma, boolean isComplete, Double... expectedValues) {
        assertEquals(isComplete, gmma.isComplete());
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.THREE), expectedValues[0]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.FIVE), expectedValues[1]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.EIGHT), expectedValues[2]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.TEN), expectedValues[3]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.TWELVE), expectedValues[4]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.FIFTEEN), expectedValues[5]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.THIRTY), expectedValues[6]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.THIRTYFIVE), expectedValues[7]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.FORTY), expectedValues[8]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.FORTYFIVE), expectedValues[9]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.FIFTY), expectedValues[10]);
        assertDecimalEquals(gmma.getValue(GuppyMultipleMovingAverage.Period.SIXTY), expectedValues[11]);
    }
}