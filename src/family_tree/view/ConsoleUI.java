package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.model.writer.FileHandler;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.menu());
            String strChoice = scanner.nextLine();
            // метод проверки на валидность
            int choice = Integer.parseInt(strChoice);
            menu.execute(choice);
        }
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void loadTree() {
        presenter.loadTree();
        presenter.getFamilyTreeInfo();
    }

    public void saveTree() {
        System.out.println("Семейное древо сохранено!");
        presenter.saveTree();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void addSpouse() {
        System.out.println("Введите ID мужа");
        String strHumanId1 = scanner.nextLine();
        long humanId1 = Long.parseLong(strHumanId1);

        System.out.println("Введите ID жены");
        String strHumanId2 = scanner.nextLine();
        long humanId2 = Long.parseLong(strHumanId2);

        presenter.addSpouse(humanId1, humanId2);
    }

    public void deleteSpouse() {
        System.out.println("Введите ID мужа");
        String strHumanId1 = scanner.nextLine();
        long humanId1 = Long.parseLong(strHumanId1);

        System.out.println("Введите ID жены");
        String strHumanId2 = scanner.nextLine();
        long humanId2 = Long.parseLong(strHumanId2);

        presenter.deleteSpouse(humanId1, humanId2);
    }

    public void setRelationship() {
        System.out.println("Введите ID ребёнка");
        String strChildId = scanner.nextLine();
        long childId = Long.parseLong(strChildId);

        System.out.println("Введите ID родителя");
        String strParentId = scanner.nextLine();
        long parentId = Long.parseLong(strParentId);

        presenter.setRelationship(childId, parentId);
    }

    public void addHuman() {
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();

        System.out.println("Введите имя");
        String name = scanner.nextLine();

        System.out.println("Введите отчество");
        String middleName = scanner.nextLine();

        Gender gender = null;

        while (true) {
            System.out.println("Укажите пол (М/Ж)");
            String strGender = scanner.nextLine();

            try {
                gender = Gender.valueOf(strGender);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите М или Ж.");
            }
        }

        LocalDate birthDate = null;

        while (true) {
            System.out.println("Введите дату рождения в формате yyyy-MM-dd");
            String strBirthDate = scanner.nextLine();

            try {
                birthDate = LocalDate.parse(strBirthDate, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате yyyy-MM-dd.");
            }
        }

        LocalDate deathDate = null;

        while (true) {
            System.out.println("Введите дату смерти в формате yyyy-MM-dd (если человек жив, то введите null)");
            String strDeathDate = scanner.nextLine();

            if (strDeathDate.equals("null")){
                break;
            }
            try {
                deathDate = LocalDate.parse(strDeathDate, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате yyyy-MM-dd.");
            }
        }

        presenter.addHuman(surname, name, middleName, gender, birthDate, deathDate);
    }

    private void error() {
        System.out.println("Неверно введены данные");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
