package org.agileindia.mathworks;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class FilterSpecs {
    @Test
    public void itSelectsPrimeNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //When
        List<Integer> primeNumbers = Filter.select(numbers, Filter.PRIME);

        //Then
        assertEquals(primeNumbers.size(), 2);
        assertTrue(primeNumbers.contains(2));
        assertTrue(primeNumbers.contains(3));
        assertFalse(primeNumbers.contains(1));
        assertFalse(primeNumbers.contains(4));
    }

    @Test
    public void itDoesNotSelectNegativePrimeNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4);

        //When
        List<Integer> primeNumbers = Filter.select(numbers, Filter.PRIME);

        //Then
        assertTrue(primeNumbers.contains(2));
        assertFalse(primeNumbers.contains(-1));
        assertFalse(primeNumbers.contains(-3));
        assertFalse(primeNumbers.contains(4));
    }

    @Test
    public void itSelectsOddNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4);

        //When
        List<Integer> oddNumbers = Filter.select(numbers, Filter.ODD);

        //Then
        assertEquals(oddNumbers.size(), 2);
        assertTrue(oddNumbers.contains(-1));
        assertTrue(oddNumbers.contains(3));
        assertFalse(oddNumbers.contains(2));
        assertFalse(oddNumbers.contains(4));
    }

    @Test
    public void itSelectsOddAndPrimeNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4);

        //When
        List<Integer> oddNumbers = Filter.select(numbers, Filter.ODD);

        //Then
        assertEquals(oddNumbers.size(), 2);
        assertTrue(oddNumbers.contains(-1));
        assertTrue(oddNumbers.contains(3));
        assertFalse(oddNumbers.contains(2));
        assertFalse(oddNumbers.contains(4));
    }

}