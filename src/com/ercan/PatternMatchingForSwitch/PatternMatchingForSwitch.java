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

    }

    public static String getObjectSize(Object obj) {
        return switch (obj) {
            case String s -> "A string of length : " + s.length();
            case List list -> "List of size : " + list.size();
            case Map map -> "Map of entry size : " + map.size();
            case Set set -> "Set of element size : " + set.size();
            default -> throw new IllegalStateException("Unexpected value: " + obj);
        };
    }

    public static String getObjectSize2(Object obj) {
        return switch (obj) {
            case String s -> "A string of length : " + s.length();
            case List list -> "List of size : " + list.size();
            case Map map && map.size() > 2 -> "Map is too large";
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
}
