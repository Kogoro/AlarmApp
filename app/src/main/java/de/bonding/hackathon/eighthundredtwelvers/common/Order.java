package de.bonding.hackathon.eighthundredtwelvers.common;

public enum Order {
    LESS_THAN, LESS_THAN_OR_EQUAL, EQUAL, MORE_THAN_OR_EQUAL, MORE_THAN, NOT_EQUAL;

    public boolean compare(int a, int b) {
        switch (this) {
            case LESS_THAN:
                return a < b;
            case LESS_THAN_OR_EQUAL:
                return a <= b;
            case EQUAL:
                return a == b;
            case MORE_THAN_OR_EQUAL:
                return a >= b;
            case MORE_THAN:
                return a > b;
            case NOT_EQUAL:
                return a != b;
        }
        return false;
    }
}
