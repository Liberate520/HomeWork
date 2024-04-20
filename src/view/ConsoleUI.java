package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu menu;

    private boolean check;
    private LocalDate date;
    private Gender gender;
    private String str;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        check = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswerLn(String answer) {
        System.out.println(answer);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.print(answer);
    }

    @Override
    public void start() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        this.printAnswerLn("\nДобрый день!\nВыберите пункт меню:\n");
        while (check) {
            printMenu();
            check = choice();
        }
    }

    private boolean choice() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        if (choice > 0 && choice < menu.size() + 1) {
            menu.execute(choice);
        }
        if (choice == menu.size()) {
            return false;
        } else return true;
    }

    private void printMenu() {
        printAnswerLn(menu.menu());
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    } // Показать семейное древо

    public void addFirst() {
        presenter.addFirst();
    } // Добавление "прородителей" в семейное древо

    public void loadSaveTree() {
        presenter.loadTree();
    } // Загрузить семейное древо из файла

    public void addHuman() {
        printAnswer("Введите имя: ");
        String name = scanner.nextLine();
        gender = askGender("Введите число, соответствующее полу (1-Male, 2-Female): ");
        date = askDate("Введите дату рождения в формате 'YYYY-MM-DD': ");

        presenter.addHuman(name, gender, date);
    } // Добавить человека в семейное древо

    public void wedding() {
        str = "Введите id жениха: ";
        int id1 = checkId(str);
        str = "Введите id невесты: ";
        int id2 = checkId(str);

        if (id1 == id2) {
            this.printAnswerLn("Id одинаковы. Данные не добавлены.\n");
        } else {
            presenter.setWedding(id1, id2);
        }
    } // Регистрация брака

    public void divorce() {
        str = "Введите id мужа: ";
        int id1 = checkId(str);
        str = "Введите id жены: ";
        int id2 = checkId(str);

        if (id1 == id2) {
            this.printAnswerLn("Id одинаковы. Данные не добавлены.\n");
        } else {
            presenter.setDivorce(id1, id2);
        }
    } // Расторжение брака

    public void addChild() {
        str = "Введите ID родителя: ";
        int parentId = checkId(str);
        str = "Введите ID ребенка: ";
        int childId = checkId(str);

        if (parentId == childId) {
            this.printAnswerLn("Id одинаковы. Данные не добавлены.\n\n");
        } else {
            presenter.addChild(parentId, childId);
        }
    } // Добавить связь Родитель <-> Ребенок

    public void addBirthDate() {
        str = "Введите Id: ";
        int id = checkId(str);
        askDate("Введите дату рождения в формате 'YYYY-MM-DD': ");

        presenter.setBirthDate(id, date);
    } // Добавить дату рождения

    public void addDeathDate() {
        str = "Введите Id: ";
        int id = checkId(str);
        askDate("Введите дату смерти в формате 'YYYY-MM-DD': ");

        presenter.setDeathDate(id, date);
    } // Добавить дату смерти

    public void sortByName() {
        presenter.sortByName();
    } // Сортировка семейного древа по именам

    public void sortById() {
        presenter.sortById();
    } // Сортировка семейного древа по Id

    public void sortByAge() {
        presenter.sortByAge();
    } // Сортировка семейного древа по возрасту

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    } // Сортировка семейного древа по дате рождения

    public void saveTree() {
        presenter.saveTree();
    } // Сохранить семейное древо в файл

    public void finish() {
        this.printAnswerLn("До свидания!");
    } // Завершить работу

    private Gender askGender(String s) {
        while (true) {
            printAnswer(s);
            String str = scanner.nextLine();
            if (str.matches("[0-9]{1}")) {
                int numGender = Integer.parseInt(str);
                if (numGender == 1) return Gender.Male;
                if (numGender == 2) return Gender.Female;
            }
        }
    }

    private LocalDate askDate(String s) {
        while (true) {
            printAnswer(s);
            String str = scanner.nextLine();
            if (str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
                int year = Integer.parseInt(str.split("-")[0]);
                int month = Integer.parseInt(str.split("-")[1]);
                int day = Integer.parseInt(str.split("-")[2]);

                try {
                    date = LocalDate.of(year, month, day);
                    return date;
                } catch (DateTimeException _) {
                }
            }
        }
    }

    private int checkInt(String s) {
        while (true) {
            printAnswer(s);
            String text = scanner.nextLine();
            if (text.matches("[0-9]+")) {
                return Integer.parseInt(text);
            } else {
                printAnswer("Неверное значение! Введите целое число: ");
            }
        }
    }

    private int checkId(String s) {
        while (true) {
            int id = checkInt(s);
            if (presenter.checkId(id)) {
                return id;
            } else printAnswer("Человек с таким id не найден. Введите другое значение id: ");
        }
    }
}