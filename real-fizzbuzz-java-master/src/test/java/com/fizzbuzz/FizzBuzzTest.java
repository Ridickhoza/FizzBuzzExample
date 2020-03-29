package com.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.fizzbuzz.FizzBuzz.fizzBuzz;
import static com.fizzbuzz.FizzBuzz.frequencies;
import static com.fizzbuzz.FizzBuzz.realFizzBuzz;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    private static final String EXPECTED_OUTPUT = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";

    @Test
    @DisplayName("when testing fizz")
    public void fizzTest() {
        assertAll("multiples Of 3 should Return ->Fizz",
                ()->assertEquals("fizz",fizzBuzz.apply(9)),
                ()->assertEquals("fizz",fizzBuzz.apply(12)),
                ()->assertEquals("fizz",fizzBuzz.apply(18)),
                ()->assertEquals("fizz",fizzBuzz.apply(21)));
    }

    @Test
    @DisplayName("when testing buzz")
    public void buzzTest() {
        assertAll("multiples Of 5 should Return ->buzz",
                ()->assertEquals("buzz",fizzBuzz.apply(5)),
                ()->assertEquals("buzz",fizzBuzz.apply(10)),
                ()->assertEquals("buzz",fizzBuzz.apply(20)),
                ()->assertEquals("buzz",fizzBuzz.apply(25)));
    }

    @Test
    @DisplayName("when testing fizzbuzz")
    public void fizzBuzzTest() {
        assertAll("multiples Of 15 should Return ->fizzbuzz",
                ()->assertEquals("fizzbuzz",fizzBuzz.apply(15)),
                ()->assertEquals("fizzbuzz",fizzBuzz.apply(45)),
                ()->assertEquals("fizzbuzz",fizzBuzz.apply(60)),
                ()->assertEquals("fizzbuzz",fizzBuzz.apply(75)));
    }

    @Test
    @DisplayName("when testing lucky")
    public void luckyTest() {
        assertAll("number with digit 3 should Return ->Lucky",
                ()->assertEquals("lucky",fizzBuzz.apply(3)),
                ()->assertEquals("lucky",fizzBuzz.apply(13)),
                ()->assertEquals("lucky",fizzBuzz.apply(23)),
                ()->assertEquals("lucky",fizzBuzz.apply(30)));
    }

    @Test
    @DisplayName("when testing frequensies")
    public void realFizzBuzzfrequenciesTest() {
        Map<String, Long> freq = frequencies(EXPECTED_OUTPUT);
        assertAll("realFizzBuzzfrequencies ->shouldBeSummedUp",
                ()->assertEquals(4L,freq.get("fizz")),
                ()->assertEquals(3L,freq.get("buzz")),
                ()->assertEquals(1L,freq.get("fizzbuzz")),
                ()->assertEquals(2L,freq.get("lucky")),
                ()->assertEquals(10L,freq.get("integer")));
    }

    @Test
    @DisplayName("when testing realFizz buzz")
    public void realFizzBuzzTest() {
        List<Integer> list = IntStream.range(1,21).distinct().boxed().collect(Collectors.toList());
        assertEquals(EXPECTED_OUTPUT, realFizzBuzz(list));
    }

}
