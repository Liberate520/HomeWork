package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.menus.Menu;
import ru.gb.family_tree.view.menus.MainMenu;
import ru.gb.family_tree.view.menus.SortMenu;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Класс {@code ConsoleUI} представляет собой пользовательский интерфейс консольного приложения.
 * Он взаимодействует с пользователем, принимая команды и обрабатывая их с помощью {@code Presenter}.
 */
public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Было введено некорректное значение!";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu main_menu;
    private SortMenu sort_menu;

    /**
     * Конструктор класса {@code ConsoleUI}.
     * Инициализирует интерфейс, создаёт экземпляры {@code Scanner}, {@code Presenter},
     * {@code MainMenu} и {@code SortMenu}.
     */
    public ConsoleUI() {
        toGreet();
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        main_menu = new MainMenu(this);
        sort_menu = new SortMenu(this);
    }

    /**
     * Выводит текст на консоль.
     *
     * @param text текст для вывода.
     */
    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    /**
     * Запускает основной цикл работы приложения,
     * отображает главное меню и выполняет выбранные команды.
     */
    @Override
    public void start() {
        while (work) {
            System.out.println("\nДоступные команды:\n------------------ ");
            printMenu(main_menu);
            execute(main_menu);
        }
    }

    /**
     * Завершает работу приложения и выводит сообщение о завершении.
     */
    public void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }

    /**
     * Отображает меню дополнительных опций для вывода членов семьи
     * и выполняет выбранные команды.
     */
    public void getAboutFamily() {
        System.out.println("\nДополнительные опции к выбранной команде\nпо выводу всех членов семьи из древа:\n------------------ ");
        printMenu(sort_menu);
        execute(sort_menu);
    }

    /**
     * Запрашивает информацию у {@code Presenter} для получения неотсортированного дерева.
     */
    public void getNoSortTree() {
        presenter.getAboutFamily();
    }

    /**
     * Запрашивает информацию у {@code Presenter} для сортировки дерева по возрасту.
     */
    public void sortTreeByAge() {
        presenter.sortTreeByAge();
    }

    /**
     * Запрашивает информацию у {@code Presenter} для сортировки дерева по имени.
     */
    public void sortTreeByName() {
        presenter.sortTreeByName();
    }

    /**
     * Запрашивает у пользователя информацию для добавления нового члена семьи
     * и передаёт её {@code Presenter}.
     */
    public void addMember() {
        System.out.println("Введите ФИО: ");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате гггг-мм-дд): ");
        String dateString = scanner.nextLine();
        System.out.println("Введите пол (female/male): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        presenter.addMember(name, gender, dateString);
    }

    /**
     * Запрашивает у пользователя id члена семьи и дату смерти,
     * затем передаёт информацию {@code Presenter}.
     */
    public void setDeathDate() {
        this.getNoSortTree();
        System.out.println("----------------");
        System.out.println("Введите id члена семьи, для которого надо указать дату смерти. Id можно увидеть в списке выше.");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите дату смерти (в формате гггг-мм-дд): ");
        LocalDate dod = LocalDate.parse(scanner.nextLine());
        presenter.setDeathDate(personId, dod);
    }

    /**
     * Запрашивает у пользователя id члена семьи и родителя,
     * затем передаёт информацию {@code Presenter}.
     */
    public void setParent() {
        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать родителя. Id можно увидеть в списке выше");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id родителя. Id можно увидеть в списке выше");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(memberId, parentId);
    }

    /**
     * Запрашивает у пользователя id члена семьи, супруга и статус супругов,
     * затем передаёт информацию {@code Presenter}.
     */
    public void setSpouse() {
        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать супруга(у). Id можно увидеть в списке выше");
        int firstMemberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id супруга(и). Id можно увидеть в списке выше");
        int secondMemberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите статус супругов (ex/actual): ");
        SpouseStatus spouseStatus = SpouseStatus.valueOf(scanner.nextLine());
        presenter.setSpouse(firstMemberId, secondMemberId, spouseStatus);
    }

    /**
     * Запрашивает у пользователя путь к файлу для чтения информации по дереву
     * и передаёт его {@code Presenter}.
     */
    public void read() {
        System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
        String path = scanner.nextLine();
        while (!presenter.read(path)) {
            System.out.println("Не удалось загрузить файл. Будете пробовать снова? y/n: ");
            if (scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
            path = scanner.nextLine();
        }
    }

    /**
     * Запрашивает у пользователя путь к файлу для сохранения информации по дереву
     * и передаёт его {@code Presenter}.
     */
    public void write() {
        System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
        String path = scanner.nextLine();
        while (!presenter.write(path)) {
            System.out.println("Не удалось сохранить файл. Будете пробовать снова? y/n");
            if (scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
            path = scanner.nextLine();
        }
    }

    /**
     * Выводит приветственное сообщение при запуске приложения.
     */
    private void toGreet() {
        System.out.println("\nДобро пожаловать в приложение по составлению семейного древа!");
        System.out.println("-------------------------\n-------------------------\n");
    }

    /**
     * Выполняет команду из меню в зависимости от ввода пользователя.
     *
     * @param menu экземпляр {@code Menu}, в котором содержатся команды для выполнения.
     */
    private void execute(Menu menu) {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }

    /**
     * Проверяет, является ли текст числом.
     *
     * @param text текст для проверки.
     * @return {@code true}, если текст является числом, иначе {@code false}.
     */
    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    /**
     * Проверяет, является ли команда допустимой в заданном меню.
     *
     * @param numCommand номер команды.
     * @param menu экземпляр {@code Menu} для проверки.
     * @return {@code true}, если команда допустима, иначе {@code false}.
     */
    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    /**
     * Выводит меню на консоль.
     *
     * @param menu экземпляр {@code Menu} для вывода.
     */
    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    /**
     * Выводит сообщение об ошибке ввода.
     */
    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
