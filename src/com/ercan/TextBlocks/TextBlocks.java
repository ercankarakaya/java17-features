package com.ercan.TextBlocks;

public class TextBlocks {

    public static void main(String[] args) {

        System.out.println(getStrValue());

        System.out.println(getStrValueOld());

    }

    public static String getStrValue(){
        return  """
                Learning Java.
                  Version :
                  "JDK 17"
                """;
    }

    public static String getStrValueOld(){
        return "Learning Java\n" +
                "  Version :\n" +
                "  \"JDK 17\"";
    }
}
