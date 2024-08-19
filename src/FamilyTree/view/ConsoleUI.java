package FamilyTree.view;

import FamilyTree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    public Presenter presenter;

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Приветствую Вас в программе 'Семейное дерево'");
        while (work) {
            System.out.println("1.  Добавить нового члена семейного дерева");
            System.out.println("2.  Вывести полный список дерева");
            System.out.println("3.  Сортировка членов семьи по имени");
            System.out.println("4.  Сортировка членов семьи по дате рождения");
            System.out.println("5.  Сортировка членов семьи по возрасту");
            System.out.println("6.  Удалить члена из дерева");
            System.out.println("7.  Сохранить дерево");
            //TODO Еще можно дописать разных методов, вывода информации и пр.
//            System.out.println("8.  ");
//            System.out.println("9.  ");
//            System.out.println("10. ");
//            System.out.println("11. ");
//            System.out.println("12. ");

            System.out.println("33.  Завершение работы");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHumanToFT();
                    break;
                case "2":
                    printFamilyTreeInfo();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByBirthDate();
                    break;
                case "5":
                    sortByAge();
                    break;
                case "6":
                    deleteHumanfromFT();
                    break;
                case "7":
                    saveFT();
                    break;
                case "33":
                    finish();
                    break;
                default:
                    System.out.println("Неверно введено значение. Попробуйте снова");
            }
        }
    }

    private void saveFT() {
        presenter.saveFamilyTree();
    }

    private void deleteHumanfromFT() {
        presenter.deleteHuman();
    }

    @Override
    public void printAnswer(StringBuilder answer) {
        System.out.println(answer);
    }

    private void sortByAge() {
        System.out.println("До сортировки");
        printFamilyTreeInfo();
        presenter.sortByAge();
        System.out.println("После сортировки");
        printFamilyTreeInfo();
    }

    private void sortByBirthDate() {
        System.out.println("До сортировки");
        printFamilyTreeInfo();
        presenter.sortByBirthDate();
        System.out.println("После сортировки");
        printFamilyTreeInfo();
    }

    private void sortByName() {
        System.out.println("До сортировки");
        printFamilyTreeInfo();
        presenter.sortByName();
        System.out.println("После сортировки");
        printFamilyTreeInfo();
    }

    private void printFamilyTreeInfo() {
        presenter.printFamilyTreeInfo();
    }

    private void addHumanToFT() {
        System.out.println("Выберите вариант записи информации о члене семьи:");
        System.out.println("1. Ввод краткой инормации (Имя, Дата рождения, Пол)");
        System.out.println("2. Ввод: Имя, Дата рождения, Пол, Отец, Мать");
        System.out.println("3. Ввод: Имя, Дата рождения, Пол, Образование, Национальность, Место рождения, Отец, Мать");
        System.out.println("4. Вернуться в главное меню");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                addShortHumanInfo();
                break;
            case "2":
                addMidHumanInfo();
                break;
            case "3":
                addFullHumanInfo();
                break;
            case "4":
                start();
                break;
            default:
                System.out.println("Неверно введено значение. Попробуйте снова");
        }
    }

    private void addFullHumanInfo() {
        //TODO Позже дописать полный метод
    }

    private void addMidHumanInfo() {
        System.out.println("Укажите имя члена семьи:");
        String name = scanner.nextLine();

        // Проверяем и разбираем дату рождения
        LocalDate birthDate;
        while (true) {
            System.out.println("Укажите дату рождения (гггг-мм-дд):");
            String birthDateString = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                birthDate = LocalDate.parse(birthDateString, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Пожалуйста, попробуйте снова");
            }
        }
        presenter.addHuman(name, birthDate, presenter.chooseGender(), presenter.chooseFather(), presenter.chooseMother());
    }

    private void addShortHumanInfo() {
        System.out.println("Укажите имя члена семьи:");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения:");
        System.out.println("Год рождения:");
        String birthYear = scanner.nextLine();
        int year = Integer.parseInt(birthYear);
        System.out.println("Месяц рождения:");
        String birthMonth = scanner.nextLine();
        int month = Integer.parseInt(birthMonth);
        System.out.println("День рождения:");
        String birthDay = scanner.nextLine();
        int day = Integer.parseInt(birthDay);
        LocalDate birthDate = LocalDate.of(year, month, day);
        presenter.addHuman(name, birthDate, presenter.chooseGender());
        presenter.saveFamilyTree();
    }

    private void finish() {
        work = false;
        scanner.close();
        System.out.println("До скорой встречи!");
    }
}
