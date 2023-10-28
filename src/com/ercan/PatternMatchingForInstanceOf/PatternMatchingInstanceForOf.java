package com.ercan.PatternMatchingForInstanceOf;

public class PatternMatchingInstanceForOf {
    public static void main(String[] args) {

        var result = checkTypePatternMatching("Java");
        System.out.println(result);

    }

    public static String checkTypePatternMatching(Object obj) {
        if (obj instanceof String s) {
            return String.format("Object is a string: %s", s);
        } else if (obj instanceof Number n) {
            return String.format("Object is a number: %s", n);
        } else {
            return String.format("Object is not recognized");
        }
    }

    public static String checkTypeOld(Object obj) {
        if (obj instanceof String) {
            String s = (String) obj;
            return String.format("Object is a string: %s", s);
        } else if (obj instanceof Number) {
            Number n = (Number) obj;
            return String.format("Object is a number: %s", n);
        } else {
            return String.format("Object is not recognized");
        }
    }
}
