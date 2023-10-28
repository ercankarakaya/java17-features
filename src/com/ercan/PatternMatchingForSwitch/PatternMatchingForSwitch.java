package com.ercan.PatternMatchingForSwitch;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PatternMatchingForSwitch {

    public static void main(String[] args) {

        System.out.println("*** Example1 ****");
        var result1 = getObjectSize(List.of("Java", "Pyhton"));
        System.out.println(result1);

        System.out.println("*** Example2 ****");
        var result2 = getObjectSize2(Map.of("1", "a", "2", "b", "3", "c"));
        System.out.println(result2);

        System.out.println("*** Example3 ****");
        var result3 = parseDoublePatternMatching("21");
        System.out.println(result3);

        System.out.println("*** Example4 ****");
        var result4 = numberOfLettersSwitch(Day.FRIDAY);
        System.out.println(result4);

    }

    /**
     * This method has Type Pattern. There is a Type Pattern in all 4 cases.
     */

    public static String getObjectSize(Object obj) {
        return switch (obj) {
            case String s -> "A string of length : " + s.length(); // Type Pattern
            case List list -> "List of size : " + list.size();
            case Map map -> "Map of entry size : " + map.size();
            case Set set -> "Set of element size : " + set.size();
            default -> throw new IllegalStateException("Unexpected value: " + obj);
        };
    }

    /**
     * In this method, there are both Type Pattern and Guarded Pattern. There is Guarded in only 1 case.
     */

    public static String getObjectSize2(Object obj) {
        return switch (obj) {
            case String s -> "A string of length : " + s.length();
            case List list -> "List of size : " + list.size();
            case Map map && map.size() > 2 -> "Map is too large"; // Guarded Pattern
            case Map map -> "Map of entry size : " + map.size();
            case Set set -> "Set of element size : " + set.size();
            default -> throw new IllegalStateException("Unexpected value: " + obj);
        };
    }

    public static double parseDoublePatternMatching(Object obj) {
        return switch (obj) {
            case String s && s.length() > 0 -> Double.parseDouble(s);
            case Number n -> n.doubleValue();
            default -> 0d;
        };
    }

    public static int numberOfLettersSwitch(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }


    /*** OLD APPROACHES **/

    // Using if
    public static String getObjectSizeOld(Object obj) {
        if (obj instanceof String) {
            return "A string of length : " + ((String) obj).length();
        } else if (obj instanceof List) {
            return "List of size : " + ((List) obj).size();
        } else if (obj instanceof Map) {
            return "Map of entry size : " + ((Map) obj).size();
        } else if (obj instanceof Set) {
            return "Size of element size : " + ((Set) obj).size();
        } else {
            throw new IllegalStateException("Unexpected value : " + obj);
        }
    }

    public static double parseDoublePatternMatchingOld(Object obj) {
        if (obj instanceof String && ((String) obj).length() > 0) {
            return Double.parseDouble((String) obj);
        } else if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return 0d;
    }

    public static int numberOfLettersOld(Day day) {
        int letters = 0;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                letters = 6;
                break;
            case TUESDAY:
                letters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                letters = 8;
                break;
            case WEDNESDAY:
                letters = 9;
                break;
        }
        return letters;
    }

    /** Enum */
    enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
