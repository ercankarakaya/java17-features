package com.ercan.TextBlocks;

public class TextBlocks {

    public static void main(String[] args) {

        System.out.println("*** Example1 ***");
        System.out.println(getStrValue());
        System.out.println(getStrValueOld());

        System.out.println("\n*** Example2 ***");
        System.out.println(getHtmlUsingTextBlock("Java"));
        System.out.println(getHtmlOld("Java"));

    }

    public static String getStrValue() {
        return """
                Learning Java.
                  Version :
                  "JDK 17"
                """;
    }

    public static String getStrValueOld() {
        return "Learning Java\n" +
                "  Version :\n" +
                "  \"JDK 17\"";
    }

    public static String getHtmlUsingTextBlock(String title) {
        return """
                <html>
                    <body>
                        <h1>%s</h1>
                    </body>
                </html>        
                """.formatted(title);
    }

    public static String getHtmlOld(String title) {
        return "<html>\n" +
                "    <body>\n" +
                "        <h1>" + title + "</h1>\n" +
                "    </body>\n" +
                "</html>\n";
    }
}
