package View;

import Presenter.Presenter;
import model.familyTree.Gender;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleWork implements View {

    private static final String ERROR = "Неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleWork(Presenter presenter) {
        this.scanner = new Scanner(System.in);
        this.presenter = presenter;
        this.work = true;
        this.menu = new Menu(this);
    }

    public String getId() {
        System.out.print("Присвойте id: ");
        return scanner.nextLine();
    }

    public void addFamilyLink() {
        System.out.print("Введите ID ребенка: ");
        String childId = scanner.nextLine();
        System.out.print("Введите ID родителя: ");
        String parentId = scanner.nextLine();
        presenter.createFamilyLink(childId, parentId);
        printAnswer("Родственная связь установлена.");
    }

    public String getNameInput() {
        System.out.print("Введите имя на английском: ");
        return scanner.nextLine();
    }

    public Gender getGenderInput() {
        while (true) {
            System.out.print("Введите пол (Male or Female): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Male")) {
                return Gender.Мужской;
            } else if (input.equalsIgnoreCase("Female")) {
                return Gender.Женский;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public LocalDate getBirthDateInput() {
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        return LocalDate.parse(scanner.nextLine());
    }

    public LocalDate getDeathDateInput() {
        System.out.print("Введите дату смерти (ГГГГ-ММ-ДД) или оставьте пустым, если жив: ");
        String input = scanner.nextLine();
        return input.isEmpty() ? null : LocalDate.parse(input);
    }

    public void addMember() {
        String id = getId();
        String name = getNameInput();
        Gender gender = getGenderInput();
        LocalDate birthDate = getBirthDateInput();
        LocalDate deathDate = getDeathDateInput();
        presenter.addMember(id, name, gender, birthDate, deathDate);
        printAnswer("Член семьи добавлен.");
    }

    public void loadFamilyTree() {
        String fileName = getFileNameInput();
        presenter.loadFamilyTree(fileName);
        printAnswer("Семейное дерево загружено.");
    }

    public void saveFamilyTree() {
        String fileName = getFileNameInput();
        presenter.saveFamilyTree(fileName);
        printAnswer("Семейное дерево сохранено.");
    }

    public void showFamilyTree() {
        printAnswer("Семейное дерево:\n" + presenter.getFamilyTree());
    }

    public void sortByAge() {
        presenter.sortByAge();
        printAnswer("Семейное дерево отсортировано по дате рождения.");
    }

    public void sortByName() {
        presenter.sortByName();
        printAnswer("Семейное дерево отсортировано по имени.");
    }

    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        printAnswer("До скорой встречи");
        work = false;
    }

    private void hello() {
        printAnswer("Я вас категорически приветствую!");
        System.out.println();
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            error();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            error();
            return false;
        }
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    private void error() {
        printAnswer(ERROR);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public String getFileNameInput() {
        System.out.print("Введите название файла: ");
        return scanner.nextLine();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }    
}
