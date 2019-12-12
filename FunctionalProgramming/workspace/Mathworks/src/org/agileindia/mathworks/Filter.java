package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    public static Predicate<Integer> ODD = number -> number%2!=0;
    //public static Predicate PRIME = ();
    //public static Predicate<Integer> ODD_AND_PRIME = new Prime();


    public static List<Integer> select(List<Integer> numbers, Predicate condition) {
        List<Integer> selected = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (condition.test(number)) {
                selected.add(number);
            }
        }
        return selected;
    }

    public static boolean isSatisfiedBy(int number) {

        if (number < 2 ) {
            return false;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0 ) {
                return false;
            }
        }
        return true;
    }

}