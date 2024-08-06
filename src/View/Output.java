package View;

public class Output implements OutputView{
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage() {
        printMessage("Вы ввели неверное значение.");
    }

    @Override
    public void printGreetingMessage() {
        printMessage("Добро пожаловать!\n" +
                "Начинаем работу с семейным деревом.");
    }

    @Override
    public void printExitMessage() {
        printMessage("Работа с семейным деревом завершена.\n" +
                "До новых встреч!");
    }

    @Override
    public void printDateFormatError() {
        printMessage("Ошибка. Неверный формат даты.");
    }

    @Override
    public void printDateError() {
        printMessage("Ошибка. Дата смерти должна идти раньше даты рождения.");
    }

    @Override
    public void printGenderError() {
        printMessage("Ошибка пола");
    }
}
