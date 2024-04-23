package view.util;

public class Helpers {

    public static String formatDataString(String field, String value, boolean linebreak) {
        return ConsoleColors.YELLOW + field + ": " + ConsoleColors.WHITE_BOLD + value + ConsoleColors.RESET + (
                linebreak ? "" : "\n");
    }

    public static String formatDataString(String field, String value) {
        return ConsoleColors.YELLOW + field + ": " + ConsoleColors.WHITE_BOLD + value + ConsoleColors.RESET + "\n";
    }
}
