package view;

import form.forming.Gender;
import presenter.Presenter;
import view.View;
import view.menu.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private List<Boolean> workMenu;
    private Menu startMenu;
    private String filePatch;

    /**
     * Конструктор класса
     * создает новый scanner
     * создает новый presenter и передает текущий view
     * создает новый workMenu
     * создает новое startMenu и передает ему текущий consoleUI
     * инициализирует filePatch (путь сохранения и загрузки дерева)
     */
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        workMenu = new ArrayList<>();
        startMenu = new StartMenu(this);
        filePatch = "src/Tree.txt";
    }

    @Override
    public void start() {
        System.out.println("Запуск программы");
        launchingMenu(startMenu);
    }

    /**
     * Принимает клаас Menu
     * Добавляет в workMenu true в начале работы удаляет при завершении
     * в цикле отображает меню при помощи метода showMenu
     *
     * @param menu
     */
    private void launchingMenu(Menu menu) {
        workMenu.add(true);
        while (workMenu.getLast()) {
            System.out.println(menu.showMenu());
            int choice = chekingCoice(0, menu.getCommands().size() - 1);
            if (choice >= 0) {
                menu.execute(choice);
            }
        }
        workMenu.removeLast();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    /**
     * выводит справку по использованию меню в консоль
     */
    public void callingHelp() {
        System.out.println(
                "******************* Справка ******************\n" +
                        "*               Структура меню               *\n" +
                        "* 0. - Вызывает эту справку *\n" +
                        "* 1. - Загружает дерево из файла по адресу: src/data_save/familyTree.txt *\n" +
                        "* 2. - Сохраняет дерево в файл по адресу: src/data_save/familyTree.txt *\n" +
                        "* 3. - Запрашивает данные для добавления и добавляет человека в дерево *\n" +
                        "* 4. - Запрашивает данные для поиска и вызывает меню действий с результатом поиска *\n" +
                        "*     0. - Вызывает эту справку *\n" +
                        "*     1. - Выводит список людей для выбора родителей и устанавливает указанных родителей, а им устанавливает ребенка *\n" +
                        "*     2. - Выводит на экран возраст *\n" +
                        "*     3. - Выводит на экран родителей *\n" +
                        "*     4. - Выводит на экран детей *\n" +
                        "*     5. - Выводит на экран бабушек и дедушек *\n" +
                        "*     6. - Выводит на экран внуков *\n" +
                        "*     7. - Выходит в предыдущее меню *\n" +
                        "* 5. - Вызывает меню выбора сортировок дерева *\n" +
                        "*     0. - Вызывает эту справку *\n" +
                        "*     1. - Сортирует дерево по имени и показывает его краткую форму *\n" +
                        "*     2. - Сортирует дерево по возрасту и показывает его краткую форму *\n" +
                        "*     3. - Сортирует дерево по количеству детей и показывает его краткую форму *\n" +
                        "*     4. - Выходит в предыдущее меню *\n" +
                        "* 6. - Вызывает меню выбора печати дерева *\n" +
                        "*     0. - Вызывает эту справку *\n" +
                        "*     1. - Печатает  краткую форму джерева ФИО, ворзаст и количество детей *\n" +
                        "*     2. - Печатает полную форму дерева *\n" +
                        "*     3. - Выходит в предыдущее меню *\n" +
                        "* 7. - Выходит из программы *\n"
        );
    }

    /**
     * Вызывает у презентора метод loadingTree передавая ему filePatch
     */
    public void loadingTree() {
        presenter.loadingTree(filePatch);
    }

    /**
     * Вызывает у презентора метод savingTree передавая ему filePatch
     */
    public void savingTree() {
        presenter.savingTree(filePatch);
    }

    /**
     * Запрашивает у пользователя name методом enteringName
     * Запрашивает у пользователя gender методом enteringGender
     * Запрашивает у пользователя dob методом enteringDataStr заперщает возвращать null
     * Запрашивает у пользователя dod методом enteringDataStr разрешает возвращать null
     * Dspsdftn vtnjl addHuman в presenter и передает ему собранные аргументы
     */
    public void addHuman() {
        String name;
        Gender gender;
        String birthDate;
        String deathDate;

        name = enteringName();

        gender = enteringGender();

        System.out.println("Укажите дату рождения");
        birthDate = enteringDataStr(false);

        System.out.println("Укажите дату смерти (Введите пустую строку для пропуска)");
        deathDate = enteringDataStr(true);

        presenter.addHuman(name, gender, birthDate, deathDate);
    }

    /**
     * Запрашивает у пользователя строки
     * Вызывает в presenter метод findHuman с параметром веденным пользователем
     * Если возвращается true запускает меню АctionFindMenu для работы с найденным человеком
     * Если возвращается false печатает сообщение
     */
    public void findHuman() {
        String name;
        System.out.println("Введите ФИО или его часть: ");
        name = scanner.nextLine();
        if (presenter.findHuman(name)) {
            Menu actionFindMenu = new ActionFindMenu(this);
            launchingMenu(actionFindMenu);
        } else {
            System.out.println("Человек не найден");
        }
    }

    /**
     * создает и запускает методом launchingMenu меню SortMenu
     */
    public void choicingSort() {
        Menu sortMenu = new SortMenu(this);
        launchingMenu(sortMenu);
    }

    /**
     * создает и запускает методом launchingMenu меню PrintMenu
     */
    public void choicingPrint() {
        Menu printMenu = new PrintMenu(this);
        launchingMenu(printMenu);
    }

    /**
     * Устанавливает  последний елемент workMenu false
     */
    public void goOut() {
        workMenu.set(workMenu.size() - 1, false);
    }

    /**
     * Принимает строку
     * проверяет состоит ли строка только из цифр
     *
     * @param choiceStr
     * @return boolean
     */
    private boolean checkingIsDigital(String choiceStr) {
        return (choiceStr.matches("\\d+"));
    }

    /**
     * Печатает ошибку с указанием диапазона допустимых значений
     *
     * @param min
     * @param max
     */
    private void printError(int min, int max) {
        System.out.printf("Вы ввели не коретные данные \nВведите число от %d до %d\n", min, max);
    }

    /**
     * Через обращение в presenter shortPrintTree выводит список людей в дереве
     * запрашивает выбор пользователя для мамы
     * Через обращение в presenter shortPrintTree выводит список людей в дереве
     * запрашивает выбор пользователя для папы
     * Если введены значение коректны вызывает через presenter метод setParents передавая индексы мамы и папы в дереве
     * Вслучаее не коректных вводов печатает сообщение
     */
    public void setParents() {
        int indexMother, indexFather;
        System.out.println("Выберите маму: \n");
        System.out.println(presenter.shortPrintTree());
        indexMother = chekingCoice(1, presenter.getSizeTree()) - 1;
        System.out.println("Выберите папу: \n");
        System.out.println(presenter.shortPrintTree());
        indexFather = chekingCoice(1, presenter.getSizeTree()) - 1;
        if (indexMother >= 0 && indexFather >= 0) {
            presenter.setParents(indexMother, indexFather);
        } else {
            System.out.println("Ошибка добавления родителей");
        }
    }

    /**
     * Вызвает в presenter метод getAge
     */
    public void getAge() {
        presenter.getAge();
    }

    /**
     * Вызвает в presenter метод getParents
     */
    public void getParents() {
        presenter.getParents();
    }

    /**
     * Вызвает в presenter метод getChildren
     */
    public void getChildren() {
        presenter.getChildren();
    }

    /**
     * Вызвает в presenter метод getGrandparents
     */
    public void getGrandparents() {
        presenter.getGrandparents();
    }

    /**
     * Вызвает в presenter метод getGrandsons
     */
    public void getGrandsons() {
        presenter.getGrandsons();
    }

    /**
     * Вызвает в presenter метод sortName
     * Печаате краткое дерево через обращение в presenter методом shortPrintTree
     */
    public void sortName() {
        presenter.sortName();
        System.out.println("соритровка по имени");
        System.out.println(presenter.shortPrintTree());
    }

    /**
     * Вызвает в presenter метод sortAge
     * Печаате краткое дерево через обращение в presenter методом shortPrintTree
     */
    public void sortAge() {
        presenter.sortAge();
        System.out.println("соритровка по возрасту");
        System.out.println(presenter.shortPrintTree());
    }

    /**
     * Вызвает в presenter метод sortNumberChildren
     * Печаате краткое дерево через обращение в presenter методом shortPrintTree
     */
    public void sortNumberChildren() {
        presenter.sortNumberChildren();
        System.out.println("соритровка по количеству детей");
        System.out.println(presenter.shortPrintTree());
    }

    /**
     * Печаате краткое дерево через обращение в presenter методом longPrintTree
     */
    public void longPrint() {
        System.out.println(presenter.longPrintTree());
    }

    /**
     * Печаате краткое дерево через обращение в presenter методом shortPrintTree
     */
    public void shortPrint() {
        System.out.println(presenter.shortPrintTree());
    }

    /**
     * принимает два int дипазона доступного выбора включительно
     * принимает от пользователя строку
     * проверяет его checkingIsDigital на толькочисла
     * если да то пребразует в int если нет то печатает ошибку через printError и возращает -1
     * проверчяет число на нахождение в диапазоне
     * сли да то возращает его int если нет то печатает ошибку через printError и возращает -1
     * @param min
     * @param max
     * @return
     */
    private int chekingCoice(int min, int max) {
        String choiceStr = scanner.nextLine();
        if (checkingIsDigital(choiceStr)) {
            int choice = Integer.parseInt(choiceStr);
            if (choice <= max && choice >= min) {
                return choice;
            } else {
                printError(min, max);
            }
        } else {
            printError(min, max);
        }
        return -1;
    }

    /**
     * Запрашивает ФИО проверяет что строка не пустая
     * возвращает если если строка непустая
     * при пустой строке посторяет запрос.
     * @return String
     */
    private String enteringName() {
        String name;
        boolean repeatQuestion;

        do {
            System.out.println("Введите ФИО: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                repeatQuestion = true;
                System.out.println("Вы ничего не ввели");
            } else {
                repeatQuestion = false;
            }
        } while (repeatQuestion);
        return name;
    }

    /**
     * Запрашивает пол у пользователя ввиде строки из одногосимвола м или ж (регистр не важен)
     * воаращает Gender в зависимости от пола, если выбор не соотвествует значения повторяет запрос и выводит подсказку
     * @return Gender
     */
    private Gender enteringGender() {
        String genderStr;
        System.out.println("Укажите пол: М или Ж");
        do {
            genderStr = scanner.nextLine().toLowerCase();
            switch (genderStr) {
                case ("м"):
                    return Gender.Male;
                case ("ж"):
                    return Gender.Female;
                default:
                    System.out.println("Укажите пол: М или Ж (Русская расладка)");
                    break;
            }
        } while (true);
    }

    /**
     * принимает boolean truе разрешает вовращать null, false - запрещает
     * Запрашивает у пользователя дату ввиде строки и вормирует из нее формат ГГГГ-ММ-ДД
     * запрашивает год в промежктке от 1000 до 2100
     * запрашивает месяц в промежутке от 1 до 12 значения меньше 10 дополняются 0 перед числом
     * запрашивает день в промежутке от 1 до 31 значения меньше 10 дополняются 0 перед числом
     * возвращает отформатированную строку или null
     * @param allowNull boolean
     * @return
     */
    private String enteringDataStr(boolean allowNull) {
        StringBuilder date = new StringBuilder();
        String temp;
        boolean repeatQuestion;

        System.out.println("Введите год");
        do {
            temp = scanner.nextLine();
            if (allowNull && temp.isEmpty()) {
                return null;
            }
            if (checkingIsDigital(temp) && Integer.parseInt(temp) > 1000 && Integer.parseInt(temp) < 2100) {
                date.append(temp);
                repeatQuestion = false;
            } else {
                System.out.println("укажите год от 1000 до 2100");
                repeatQuestion = true;
            }
        } while (repeatQuestion);

        System.out.println("Введите месяц");
        do {
            temp = scanner.nextLine();
            if (checkingIsDigital(temp) && Integer.parseInt(temp) < 13 && Integer.parseInt(temp) > 0) {
                date.append("-");
                if (Integer.parseInt(temp) < 10) {
                    date.append(0);
                }
                date.append(temp);
                repeatQuestion = false;
            } else {
                System.out.println("укажите месяц от 1 до 12");
                repeatQuestion = true;
            }
        } while (repeatQuestion);

        System.out.println("Введите число");
        do {
            temp = scanner.nextLine();
            if (checkingIsDigital(temp) && Integer.parseInt(temp) < 32 && Integer.parseInt(temp) > 0) {
                date.append("-");
                if (Integer.parseInt(temp) < 10) {
                    date.append(0);
                }
                date.append(temp);
                repeatQuestion = false;
            } else {
                System.out.println("укажите число от 1 до 31");
                repeatQuestion = true;
            }
        } while (repeatQuestion);
        return date.toString();
    }

}