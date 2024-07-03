package vending_tree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * class InteractionUser для взаимодействия с пользователем
 * предоставление данных пользователю
 * получение валидных данных от пользователя
 */
public class InteractionUser {
    private final Scanner scanner;

    /**
     * Конструктор для инициализации Scanner
     */
    public InteractionUser() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Создание пользователя через терминал
     * @return ввод
     */
    public String enterName() {
        System.out.print("Создадим пользователя, Введите Имя: ");
        return this.scanner.nextLine();
    }

    /**
     * выбор пола
     * @return пол
     */
    public Gender selectGender() {
        System.out.println("Выберите пол:");
        for (Gender gender : Gender.values()) {
            System.out.println(gender.ordinal() + 1 + ". " + gender);
        }
        this.defaultPrintEndRequest();
        int enterNumUser = this.validInputUser(1, Gender.values().length);
        return Gender.values()[enterNumUser - 1];
    }

    /**
     * Получение ответа на сохранение пользователя в базу
     * @return
     */
    public int setNameBase() {
        System.out.println("Внести в базу Имя? Выберите вариант ответа:");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        this.defaultPrintEndRequest();
        return this.validInputUser(1, 2);
    }

    /**
     * Получение даты рождения
     * @return дата в формате YYYY-MM-DD
     */
    public LocalDate getEnterBirthday() {
        LocalDate dob = null;
        while (dob == null) {
            System.out.println("Введите дату рождения (формат: YYYY-MM-DD):");
            String dobStr = scanner.nextLine();
            try {
                dob = LocalDate.parse(dobStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Попробуйте снова.");
            }
        }

        return dob;
    }

    /**
     * Получение даты смерти
     * @return дата в формате YYYY-MM-DD
     */
    public LocalDate getEnterDayOfDeath() {
        System.out.println("Хотите ввести дату смерти? (yes/no):");
        String response = scanner.nextLine();
        LocalDate dod = null;
        if (response.equalsIgnoreCase("yes")) {
            while (dod == null) {
                System.out.println("Введите дату смерти (формат: YYYY-MM-DD):");
                String dodStr = scanner.nextLine();
                try {
                    dod = LocalDate.parse(dodStr, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException e) {
                    System.out.println("Неверный формат даты. Попробуйте снова.");
                }
            }
        }
        return dod;
    }


    /**
     * Валидация введённого значения пользователем на число и
     * в диапзоне:
     * 
     * @param rangeStart нижний диапазон
     * @param rangeEnd   верхний диапазон
     * @return валидная цифра в диапазоне
     */
    private int validInputUser(int rangeStart, int rangeEnd) {
        int inputNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            if (this.scanner.hasNextInt()) {
                inputNumber = this.scanner.nextInt();

                System.out.println("---------");

                if (inputNumber >= rangeStart && inputNumber <= rangeEnd) {
                    validInput = true;
                } else {
                    System.out.println("Ошибка: введите число в диапазоне от " + rangeStart + " до " + rangeEnd + ".");
                }
            } else {
                String input = this.scanner.next();

                if (input.equalsIgnoreCase("q")) {
                    System.out.println("До свидания!");
                    System.exit(0); // Завершает выполнение программы
                } else {
                    System.out.println("Ошибка: введено не число. Пожалуйста, введите число от " + rangeStart + " до "
                            + rangeEnd + ".");
                }
            }
        }
        return inputNumber;
    }

    /**
     * Дефолтный принт в конце запроса на ввод
     */
    private void defaultPrintEndRequest() {
        System.out.println("---");
        System.out.println("q - выйти");
        System.out.println("---");
        System.out.print("Ваш ввод: ");
    }

    /**
     * Закрытие Scanner
     */
    public void closeScanner() {
        this.scanner.close();
    }
}
