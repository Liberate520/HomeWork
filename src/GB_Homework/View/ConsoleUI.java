package GB_Homework.View;

import GB_Homework.Model.Gender.Gender;
import GB_Homework.Presenter.Presenter;
import GB_Homework.View.Commands.MainMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Boolean flag;
    private MainMenu mainMenu;

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
        this.flag = true;
        this.mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Программа Семейное древо.");
        while (flag) {
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            if (checkChoice(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                mainMenu.execute(choice);
            }
        }
    }

    public boolean checkChoice(String choiceStr) {
        if (choiceStr.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceStr);
            return choice >= 0 && choice <= mainMenu.size();
        } else return false;
    }

    public void end() {
        flag = false;
    }

    public void sortByData() {
        presenter.sortByData();
        presenter.printNameFamilyTree();
    }

    public void sortByName() {
        presenter.sortByName();
        presenter.printNameFamilyTree();
    }

    public void getFamiliTree() {
        System.out.println(presenter.getFamilyTree());
    }

    public void printNameFamilyTree() {
        presenter.printNameFamilyTree();
    }

    public void getSiblings() {
        System.out.println("Введите id , кого нужны братья и сёстры:");
        String nameId = scanner.nextLine();
        String siblingsInfo = presenter.getSiblingsInfo(Integer.parseInt(nameId));
        System.out.println(siblingsInfo);
    }

    public void getAge() {
        System.out.println("Введите id, чей нужен возраст:");
        String nameAge = scanner.nextLine();
        String ageInfo = presenter.getAgeInfo(Integer.parseInt(nameAge));
        System.out.println(ageInfo);
    }

    public void addSpouse() {
        System.out.println("Введите id, кому добавить супруга(супругу):");
        String nameHuman = scanner.nextLine();
        System.out.println("Введите id супруга(супруги):");
        String nameSpouse = scanner.nextLine();
        String result = presenter.addSpouseInfo(Integer.parseInt(nameHuman), Integer.parseInt(nameSpouse)); // Presenter обрабатывает логику
        System.out.println(result);
    }

    public void addParent(String parentType) {
        System.out.println("Введите id, кому добавить родителя:");
        String childIdStr = scanner.nextLine();
        System.out.println("Введите id родителя:");
        String parentIdStr = scanner.nextLine();
        System.out.println("Введите '1', если это отец, или '2', если это мать:");
        String parentTypeStr = scanner.nextLine();

        parentType = parentTypeStr.equals("1") ? "father" : "mother";

        presenter.addParent(Integer.parseInt(childIdStr), Integer.parseInt(parentIdStr), parentType);
    }

    public void addHuman() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате (год-месяц-дата):");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        System.out.println("Если человек живой, введите 'YES', если нет, введите 'NO':");
        String ziv = scanner.nextLine();
        LocalDate deathDate = null;
        if (ziv.equals("NO")) {
            System.out.println("Введите дату смерти в формате (год-месяц-дата):");
            String deathDateStr = scanner.nextLine();
            deathDate = LocalDate.parse(deathDateStr);
        }
        System.out.println("Введите '1', если мужчина, или '2', если женщина:");
        String genderStr = scanner.nextLine();
        Gender gender = genderStr.equals("1") ? Gender.MALE : Gender.FEMALE;

        if (deathDate == null) {
            presenter.addHuman(name, birthDate, gender);
        } else {
            presenter.addHuman(name, birthDate, deathDate, gender);
        }

        System.out.println("Человек успешно добавлен.");
    }

    public void addChild() {  // добавить ребёнка
        System.out.println("Введите id , кому добавить ребёнка:");
        String nameHuman = scanner.nextLine();
        System.out.println("Введите id ребёнка:");
        String nameChild = scanner.nextLine();

        presenter.addChild(Integer.parseInt(nameHuman), Integer.parseInt(nameChild));
    }

    @Override
    public void printAnswer(int answer) {
        System.out.println(answer);
    }

    public void saveFamilyTree() throws IOException {
        System.out.println("Введите имя файла: ");
        String nameFile = scanner.nextLine();
        presenter.saveFamilyTree(nameFile);
    }

    public void readFamilyTree() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла: ");
        String nameFile = scanner.nextLine();
        presenter.readFamilyTree(nameFile);
    }
}
