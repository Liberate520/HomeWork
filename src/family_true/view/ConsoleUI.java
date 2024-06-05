/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class ConsoleUI
 * @version v1.0
 */

package family_true.view;

import family_true.view.commands.CommandMenu;
import family_true.model.human.Gender;
import family_true.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static family_true.model.api.Constants.*;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private CommandMenu commandMenu;
    private Validator validator;
    private boolean isWork;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.commandMenu = new CommandMenu(this);
        this.validator = new Validator();
        isWork = true;
    }

    public void getEntityListInfo() {
        presenter.getEntityListInfo();
    }

    public void addEntity() {
        System.out.println("Укажите данные для нового человека.");
        String lastName = getValueFromConsole("Укажите фамилию:");
        String name = getValueFromConsole("Укажите имя:");
        String patronymic = getValueFromConsole("Укажите отчество:");
        boolean isGender = true;
        Gender gender = null;
        while (isGender) {
            String genderStr = getValueFromConsole("Укажите пол (муж/жен):");
            gender = Gender.getGenderByValue(genderStr);
            if (gender == null) {
                alertValue();
            } else {
                isGender = false;
            }
        }
        LocalDate birthDay = getLocalDate("Укажите дату рождения (в формате ДД.ММ.ГГГГ):", false);
        LocalDate deathDay = getLocalDate("Укажите дату смерти (в формате ДД.ММ.ГГГГ, если нет - пробел):", true);
        presenter.addEntity(name, patronymic, lastName, gender, birthDay, deathDay);
    }

    public void addParent() {
        long idChild = getCheckId("Укажите id человека которому нужно добавить родителя. Отмена действия - r");
        if (idChild == -1) {
            return;
        }
        long idParent = getCheckId("Укажите id родителя. Отмена действия - r");
        if (idParent == -1) {
            return;
        }
        presenter.addParent(idChild, idParent);
    }

    public long getCheckId(String text) {
        String idStr;
        while (true) {
            getEntityListInfo();
            idStr = getValueFromConsole(text);
            if (idStr.trim().equals("r")) {
                return -1;
            }
            if (validator.isNotValidDigit(idStr)) {
                alertValue();
                continue;
            }
            return Integer.parseInt(idStr);
        }
    }

    public LocalDate getLocalDate(String text, boolean isEsc) {
        boolean isRepeat = true;
        while (isRepeat) {
            String dateStr = getValueFromConsole(text);
            if (isEsc && (dateStr == null || dateStr.isEmpty())) {
                return null;
            }
            if (validator.isValidLocalData(dateStr)) {
                return LocalDate.parse(dateStr, DD_MM_YYYY_FORMATTER);
            } else {
                alertValue();
            }
        }
        return null;
    }

    public String getValueFromConsole(String text) {
        System.out.println(text);
        return scanner.nextLine();
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
        String exit = getValueFromConsole("Не верно указанно значение! Для завершения работы нажмите q иначе enter");
        if (exit.trim().equals("q")) {
            System.exit(1);
        }
    }

    @Override
    public void start() {
        while (isWork) {
            System.out.println(commandMenu.getCommands());
            String checkIndexStr = scanner.nextLine();

            if (validator.isNotValidDigit(checkIndexStr)) {
                alertValue();
                continue;
            }
            int checkIndex = Integer.parseInt(checkIndexStr);
            if (validator.isNotValidIndex(checkIndex, commandMenu.getSize())) {
                alertValue();
                continue;
            }
            commandMenu.execute(checkIndex);
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
