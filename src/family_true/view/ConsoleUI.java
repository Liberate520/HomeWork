/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class ConsoleUI
 * @version v1.0
 */

package family_true.view;

import family_true.model.commands.CommandMenu;
import family_true.model.human.Gender;
import family_true.model.human.Human;
import family_true.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static family_true.model.api.Constants.*;
import static family_true.model.human.Gender.FEMALE;
import static family_true.model.human.Gender.MALE;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private CommandMenu commandMenu;
    private boolean isWork;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.commandMenu = new CommandMenu(this);
        isWork = true;
    }

    public void getEntityListInfo() {
        presenter.getEntityListInfo();
    }

    public void addEntity() {
        System.out.println("Укажите данные для нового человека.");
        System.out.println("Укажите имя:");
        String name = scanner.nextLine();
        System.out.println("Укажите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Укажите отчество:");
        String patronymic = scanner.nextLine();
        boolean isGender = true;
        Gender gender = null;
        while (isGender) {
            System.out.println("Укажите пол (муж/жен):");
            String genderStr = scanner.nextLine();
            gender = Gender.getGenderByValue(genderStr);
            if (gender == null) {
                alertValue();
            } else {
                isGender = false;
            }
        }
        LocalDate birthDay = getLocalDate("Укажите дату рождения (в формате ДД.ММ.ГГГГ):", false);
        LocalDate deathDay = getLocalDate("Укажите дату смерти (в формате ДД.ММ.ГГГГ, если нет - пробел):", true);
        Human human = new Human(name, patronymic, lastName, gender, birthDay, deathDay);
        presenter.addEntity(human);
    }

    public void addParent() {
        long idChild = getCheckId("Укажите id человека которому нужно добавить родителя. Отмена действия - r");

        if (idChild == -1) {
            return;
        }
        Human child = presenter.findHumanById(idChild);
        long idParent = getCheckId("Укажите id родителя. Отмена действия - r");

        if (idParent == -1) {
            return;
        }
        Human parent = presenter.findHumanById(idParent);

        if (MALE.equals(parent.getGender())) {
            child.setFather(parent);
        } else if (FEMALE.equals(parent.getGender())){
            child.setMother(parent);
        }
    }

    public long getCheckId(String text) {
        String idStr;
        while (true) {
            getEntityListInfo();
            System.out.println(text);
            idStr = scanner.nextLine();
            if (idStr.trim().equals("r")) {
                return -1;
            }
            if (idStr == null || idStr.isBlank() || !idStr.matches(D_MATCHER)) {
                alertValue();
                continue;
            }
            return Integer.parseInt(idStr);
        }
    }

    public LocalDate getLocalDate(String text, boolean isEsc) {
        boolean isRepeat = true;
        while (isRepeat) {
            System.out.println(text);
            String dateStr = scanner.nextLine();
            if (isEsc && (dateStr == null || dateStr.isEmpty())) {
                return null;
            }
            if (dateStr.matches(DD_MM_YYYY_MATCHER)) {
                return LocalDate.parse(dateStr, DD_MM_YYYY_FORMATTER);
            } else {
                alertValue();
            }
        }
       return null;
    }

    public void sortByLastName() {
        presenter.sortByLastName();
        getEntityListInfo();
    }

    public void sortByBirthDay() {
        presenter.sortByBirthDay();
        getEntityListInfo();
    }

    public void sortById() {
        presenter.sortById();
        getEntityListInfo();
    }

    public void exportList() {
        presenter.exportList();
    }

    public void importList() {
        presenter.importList();
    }

    public void finish() {
        System.out.println("Завершение программы");
        isWork = false;
    }

    private void alertValue() {
        System.out.println("Не верно указанно значение! Для завершения работы нажмите q иначе enter");
        String exit = scanner.nextLine();
        if (exit.equals("q")) {
            System.exit(1);
        }
    }

    @Override
    public void start() {
        while (isWork) {
            System.out.println(commandMenu.getCommands());
            String checkStr = scanner.nextLine();
            if (checkStr == null || checkStr.isBlank() || !checkStr.matches(D_MATCHER)) {
                alertValue();
                continue;
            }
            int check = Integer.parseInt(checkStr);
            if (check < 1 || check > commandMenu.getSize()) {
                alertValue();
                continue;
            }
            commandMenu.execute(check);
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
