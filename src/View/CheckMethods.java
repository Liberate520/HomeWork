package View;

import java.time.LocalDate;

public interface CheckMethods {

     String NEW_ATTEMPT_MESSAGE = "Ошибка ввода, попробуйте снова";
     String INPUT_ERROR = "Введено неправильное значение";
     String INPUT_DATE_ERROR = "Указанная дата невозможна";

    static boolean checkIsDeath(String answer) {
        return answer != null && answer.equalsIgnoreCase("Да");
    }


    static boolean checkChoiceGender(String choice) {
        if (choice != null && (choice.equalsIgnoreCase("Мужской") || choice.equalsIgnoreCase("Женский"))) {
            return true;
        }
        System.out.println(NEW_ATTEMPT_MESSAGE);
        return false;
    }

    static boolean checkDate(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate != null && secondDate != null && firstDate.isAfter(secondDate)) {
            return true;
        } else {
            System.out.println(INPUT_DATE_ERROR);
            return false;
        }
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
        if (text != null && CheckMethods.checkStringToInt(text)){
            return true;
        }
        System.out.println(NEW_ATTEMPT_MESSAGE);
        return false;
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




}
