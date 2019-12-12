package org.agileindia.mathworks;

public class Prime implements Condition {
    @Override
    public boolean isSatisfiedBy(int number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
