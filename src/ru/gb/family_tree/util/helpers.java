package ru.gb.family_tree.util;

public class helpers {
    public static String formatDataString(String field, String value) {
        return ConsoleColors.YELLOW + field + ": " + ConsoleColors.WHITE_BOLD + value + ConsoleColors.RESET;
    }
}
