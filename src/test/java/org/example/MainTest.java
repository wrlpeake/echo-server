package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyFirstJUnitJupiterTests {

    public Main testing = new Main();

    @Test
    public void test() {
        String test = testing.helloWorld();
        assertEquals(("Hello world!"), test);
    }

    @Test
    public void fizzbuzzTest() {
        assertEquals("1", testing.fizzbuzz(1));
        assertEquals("2", testing.fizzbuzz(2));
        assertEquals("fizz", testing.fizzbuzz(3));
        assertEquals("4", testing.fizzbuzz(4));
        assertEquals("buzz", testing.fizzbuzz(5));
        assertEquals("fizz", testing.fizzbuzz(6));
        assertEquals("fizz", testing.fizzbuzz(9));
        assertEquals("buzz", testing.fizzbuzz(10));
        assertEquals("fizz", testing.fizzbuzz(12));
        assertEquals("fizzbuzz", testing.fizzbuzz(15));
        assertEquals("fizzbuzz", testing.fizzbuzz(90));
        assertEquals("122", testing.fizzbuzz(122));
        assertEquals("fizz", testing.fizzbuzz(123));
    }

}



