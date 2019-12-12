package org.agileindia.mathworks;

public class Odd implements Condition {
    public boolean isSatisfiedBy(int number) {
       return (number % 2) != 0;
    }
}
