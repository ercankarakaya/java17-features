package com.ercan.PatternMatchingForSwitch;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PatternMatchingForSwitch {

    public static void main(String[] args) {

        System.out.println("*** Example1 ****");
        var result1 = getResult(List.of("Java", "Pyhton"));
        System.out.println(result1);

        System.out.println("*** Example2 ****");
        var result2 = parseDoublePatternMatching("21");
        System.out.println(result2);

    }

    public static String getResult(Object obj) {
        return switch (obj) {
            case String s -> "A string of length : " + s.length();
            case List list -> "List of size : " + list.size();
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
}
