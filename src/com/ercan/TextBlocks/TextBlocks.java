package com.ercan.TextBlocks;

public class TextBlocks {

    public static void main(String[] args) {

        System.out.println(getStrValue());

        System.out.println(getStrValueOld());

    }

    public static String getStrValue(){
        return  """
                Learning Java
                    with JDK 17
                """;
    }

    public static String getStrValueOld(){
        return "Learning Java\n" +
                "    with JDK 17";
    }
}
