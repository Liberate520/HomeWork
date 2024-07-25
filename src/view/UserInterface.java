package view;

import presenter.FamilyTreePresenter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface implements View {
    private final FamilyTreePresenter presenter;
    private final UserInputHandler userInputHandler;
    private UserMenuHandler userMenuHandler;
    public boolean isRunning;

    public UserInterface() {
        Scanner scanner = new Scanner(System.in);
        userInputHandler = new UserInputHandler(scanner);
        userMenuHandler = new UserMenuHandler(this);
        presenter = new FamilyTreePresenter(this);
        isRunning = true;
    }

     @Override
    public void start() {
        welcomeMsg();
        presenter.readTree();
        while (isRunning) {
            selectMenuPoint();
        }
    }

    private void welcomeMsg() {
        System.out.println("Добро пожаловать в программу семейного древа!");
    }

    public void selectMenuPoint() {
        while (isRunning) {
            System.out.println(userMenuHandler.getMenu());
            String userInput = userInputHandler.getUserInput();
            if (userInputHandler.isValidMenuChoice(userInput, userMenuHandler.size())) {
                int commandNumber = Integer.parseInt(userInput);
                userMenuHandler.executeCommand(commandNumber);
            } else {
                System.out.println("Введена некорректная команда. Попробуйте еще раз.");
            }
        }
    }

    public void addPerson() {
        System.out.println("Введите, пожалуйста, имя человека: ");
        String name = userInputHandler.getUserInput();

        System.out.println("Введите, пожалуйста, пол человека: ");
        String gender = userInputHandler.getGenderInput();

        System.out.println("Введите, пожалуйста, дату рождения человека в формате ДД ММ ГГГГ: ");
        LocalDate birthDate = userInputHandler.getBirthDateInput();
        presenter.addPerson(name, gender, birthDate);
    }

    public void findByName() {
        System.out.println("Укажите имя человека, которого хотите найти:");
        String name = userInputHandler.getUserInput();
        printFoundPersons(name);
    }

    public void sortById() {
        presenter.sortById();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void printFoundPersons(String name) {
        String FoundPersons = presenter.findByName(name);
        if (FoundPersons.isEmpty()) {
            System.out.println("Человек с таким именем не найден.");
        } else {
            System.out.println("Список людей, удовлетворяющие запросу: ");
            System.out.println(FoundPersons);
        }
    }

    public void removePerson() {
        System.out.println("Укажите имя человека, которого хотите удалить: ");
        String name = userInputHandler.getUserInput();
        printFoundPersons(name);
        List<Integer> foundPersonId = presenter.foundPersonId(name);
        removePersonById(name, foundPersonId);
    }

    public void removePersonById(String name, List<Integer> foundPersonId) {
        System.out.println("Укажите id человека, которого хотите удалить: ");
        boolean flag = true;
        while (flag) {
            String idInt = userInputHandler.getUserInput();
            if (userInputHandler.isValidIdChoice(idInt, foundPersonId)) {
                int id = Integer.parseInt(idInt);
                presenter.removePerson(id);
                System.out.println("Человек с id: " + id + " " + name + " удален. ");
                flag = false;
            } else {
                System.out.println("Некорректно введен id. \nПопробуйте еще раз ввести id человека из списка: " + foundPersonId);
            }
        }
    }

    public void getInfoTree() {
        presenter.getInfoTree();
    }

    public void exit() {
        isRunning = false;
        System.out.println("Программа завершена.");
        System.out.println("До свидания!");
        presenter.sortById();
        presenter.saveTree();
    }

    @Override
    public void printAnswer(String answer) {

    }
}
