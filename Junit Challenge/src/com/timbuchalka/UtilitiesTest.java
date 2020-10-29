package com.timbuchalka;

import static org.junit.Assert.*;

public class UtilitiesTest {

//    private static Utilities util;
//
//    @org.junit.BeforeClass
//    public static void setup(){
//        util = new Utilities();
//    }

    private Utilities util;

    @org.junit.Before
    public void setup(){
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        char[] expHello = new char[] {'e', 'l'};
        char[] hello = new char[] {'h', 'e', 'l', 'l', 'o'};

        assertArrayEquals(expHello, util.everyNthChar(hello, 2));
        assertArrayEquals(hello, util.everyNthChar(hello, 7));
    }

    @org.junit.Test
    public void removePairs() {
        String testString1 = "AABCDDEFF";
        String testString2 = "ABCCABDEEF";
        assertEquals("ABCDEF", util.removePairs(testString1));
        assertEquals("ABCABDEF", util.removePairs(testString2));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_divideByZero() {
        util.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNull(util.nullIfOddLength("afsdk"));
        assertNotNull(util.nullIfOddLength("krak"));
    }
}