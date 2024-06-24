package View;

import java.time.LocalDate;

public interface CheckMethods {

    String NEW_ATTEMPT_MESSAGE = "Ошибка ввода, попробуйте снова";
    String INPUT_ERROR = "Введено неправильное значение";
    String INPUT_DATE_ERROR = "Указанная дата невозможна";
    String EMPTY_STRING_ERROR = "Введена пустая строка";


    static boolean checkIsDeath(String answer) {
        return answer != null && answer.equalsIgnoreCase("Да");
    }


    static boolean checkChoiceGender(String choice) {
        if (choice.equalsIgnoreCase("Мужской") || choice.equalsIgnoreCase("Женский")) {
            return true;
        }
        System.out.println(EMPTY_STRING_ERROR);
        return false;
    }

    static boolean checkDate(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate != null && secondDate != null) {
            if (firstDate.isAfter(secondDate)) {
                return false;
            }
        }
        System.out.println(INPUT_DATE_ERROR);
        return true;
    }

    static boolean checkStringToInt(String text) {
        try {
            Integer.valueOf(text);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    static boolean checkInt(String text) {
        if (text.matches("[0-9]+")) {
            return false;
        }
        System.out.println(NEW_ATTEMPT_MESSAGE);
        return true;
    }

    static boolean checkLine(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            System.out.println(INPUT_ERROR);
            return false;
        }
    }

    static boolean checkCommand(MainMenu menu, int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            System.out.println(INPUT_ERROR);
            return false;
        }
    }


    static boolean checkQuestionIsDeath(String answer) {
        return (answer.equalsIgnoreCase("Да")) || answer.equalsIgnoreCase("Нет");
    }

    static boolean checkEmptyString(String name) {
        if (name.isEmpty()) {
            System.out.println(EMPTY_STRING_ERROR);
            return true;
        } else {
            return false;
        }

    }

    static boolean checkLeapYear(String yearStr) {
        int year = Integer.parseInt(yearStr);
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    static boolean checkFullDate(String yearStr, String monthStr, String dayStr) {
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);

        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println(INPUT_DATE_ERROR);
            return false;
        }

        if (checkLeapYear(yearStr)) {
            if ((month == 2 && day <= 29) ||
                    ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31) ||  // Месяцы с 31 днем
                    ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30)) {  // Месяцы с 30 днями
                return true;
            }
        } else {
            if ((month == 2 && day <= 28) ||
                    ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31) ||  // Месяцы с 31 днем
                    ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30)) {
                return true;
            }
        }

        System.out.println(INPUT_DATE_ERROR);
        return false;
    }
}





