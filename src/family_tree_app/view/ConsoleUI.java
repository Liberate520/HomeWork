package family_tree_app.view;

import java.time.LocalDate;
import java.util.Scanner;

import family_tree_app.model.human.Gender;
import family_tree_app.model.human.Human;
import family_tree_app.presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Let's begin");
        while (work) {
            System.out.println(mainMenu.showMenu());
            String choiceString = scanner.nextLine();
            if (checkChoice(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                mainMenu.makeAction(choice);
            } else
                continue;
        }
    }

    private boolean checkChoice(String choiceString) {
        if (choiceString.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceString);
            return choice >= 1 && choice <= mainMenu.size();
        }
        return false;
    }

    private boolean checkForInt(String string) {
        if (string.matches("[0-9]*")) {
            return true;
        }
        return false;
    }

    public void finish() {
        System.out.println("See you later!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAmountOfChildren() {
        presenter.sortByAmountOfChildren();
    }

    public void getList() {
        presenter.getList();
    }

    public void showMen() {
        presenter.showMen();
    }

    public void showWomen() {
        presenter.showWomen();
    }

    private Human chooseHuman() {
        System.out.println("Enter number to choose person");
        presenter.getList();
        String choiceString = scanner.nextLine();
        if (checkForInt(choiceString)) {
            int choice = Integer.parseInt(choiceString);
            Human human = presenter.getArrayList().get(choice - 1);
            return human;
        } else {
            System.out.println("Smth went wrong. Try again");
        }
        return null;
    }

    public void showProgenitors() {
        System.out.println("Let's see progenitors of the person:");
        presenter.showProgenitors(chooseHuman());
    }

    private String enterName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        return name;
    }

    private Gender enterGender() {
        System.out.println("Is this person a man or a woman?");
        System.out.println("Enter 'm' for MAN or enter 'w' for WOMAN");
        Gender gender;
        while (true) {
            String genderString = scanner.nextLine();
            if (genderString.equals("m")) {
                gender = Gender.Male;
                break;
            } else if (genderString.equals("w")) {
                gender = Gender.Female;
                break;
            } else {
                System.out.println("Try again! Just push 'm' or 'w' button");
            }
        }
        return gender;
    }

    private LocalDate enterDate() {
        try {
            System.out.println("Enter date as YYYY-MM-DD");
            String dateString = scanner.nextLine();
            String[] dateArr = dateString.split("-");
            int year = 1900;
            int month = 1;
            int day = 1;
            if (checkForInt(dateArr[0])) {
                year = Integer.parseInt(dateArr[0]);
            }
            if (checkForInt(dateArr[1])) {
                month = Integer.parseInt(dateArr[1]);
            }
            if (checkForInt(dateArr[2])) {
                day = Integer.parseInt(dateArr[2]);
            }
            LocalDate date_to_send = LocalDate.of(year, month, day);
            return date_to_send;
        } catch (Exception e) {
            return null;
        }
    }

    public void addPerson() {
        System.out.println("Who do you want to add?");
        String name = enterName();
        Gender gender = enterGender();
        LocalDate dateOfBirth;
        System.out.println("Do you know the birth date of this person?");
        System.out.println("Enter 'y' for YES or anything else for NO");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            dateOfBirth = enterDate();
            presenter.addPersonToTree(name, gender, dateOfBirth);
        } else {
            presenter.addPersonToTree(name, gender);
        }
        getList();
    }

    public void setParents() {
        System.out.println("Who is a child?");
        Human child = chooseHuman();
        System.out.println("Who is a parent?");
        Human parent1 = chooseHuman();
        System.out.println("Do you know the another parent of this person?");
        Human parent2;
        System.out.println("Enter 'y' for YES or anything else for NO");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            parent2 = chooseHuman();
            presenter.setParents(child, parent1, parent2);
        } else {
            presenter.setParent(child, parent1);
        }
    }

    // public void setChildren() {
    // System.out.println("Who is a parent?");
    // Human parent = chooseHuman();
    // System.out.println("Who is a child?");
    // Human child = chooseHuman();
    // presenter.setChildren(parent, child);
    // }

    public void setPeriodOfLife() {
        System.out.println("Whose period of life do you want to set?");
        Human human = chooseHuman();
        System.out.println("Set his/her birth date: ");
        LocalDate dateOfBirth = enterDate();
        System.out.println("Set his/her death date: ");
        LocalDate dateOfDeath = enterDate();
        presenter.setPeriodOfLife(human, dateOfBirth, dateOfDeath);
    }

    @Override
    public void print(String answer) {
        System.out.println(answer);
    }
}