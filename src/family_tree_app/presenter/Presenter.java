package family_tree_app.presenter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import family_tree_app.model.Service;
import family_tree_app.model.human.Gender;
import family_tree_app.model.human.Human;
import family_tree_app.model.work_with_files.FileHandler;
import family_tree_app.view.View;

public class Presenter {
    private Service service;
    private View view;
    private Scanner scanner;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        service.setSavable(new FileHandler<>());
        scanner = new Scanner(System.in);
    }

    public void addPerson() {
        System.out.println("Who do you want to add?");
        String name = enterName();
        Gender gender = enterGender();
        LocalDate dateOfBirth;
        System.out.println("Do you know the birth date of this person?");
        System.out.println("Enter 'y' for 'yes' or anything else for 'no'");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            dateOfBirth = enterDate();
            service.addPerson(name, gender, dateOfBirth);
        } else {
            service.addPerson(name, gender, null);
        }
    }

    public void setParents() {
        System.out.println("Who is a child?");
        Human child = chooseHuman();
        System.out.println(child.getName() + " set as a child");
        System.out.println("Who is a parent?");
        Human parent1;
        while (true) {
            parent1 = chooseHuman();
            if (parent1 != child) {
                break;
            }
        }
        System.out.println(parent1.getName() + " set as a parent");
        System.out.println("Do you know the another parent of this person?");
        Human parent2;
        System.out.println("Enter 'y' for 'yes' or anything else for 'no'");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            while (true) {
                parent2 = chooseHuman();
                if (parent2 != child && parent2 != parent1) {
                    break;
                }
            }
            service.setParents(child, parent1, parent2);
        } else {
            service.setParent(child, parent1);
        }
    }

    public void setPeriodOfLife() {
        System.out.println("Whose period of life do you want to set?");
        Human human = chooseHuman();
        System.out.println("Set his/her birth date: ");
        LocalDate dateOfBirth = enterDate();
        System.out.println("Set his/her death date: ");
        LocalDate dateOfDeath = enterDate();
        service.setPeriodOfLife(human, dateOfBirth, dateOfDeath);
    }

    public void showProgenitors() {
        System.out.println("Let's see progenitors of the person:");
        String answer = service.showProgenitors(chooseHuman());
        view.print(answer);
    }

    public void showMen() {
        String answer = service.showMen();
        view.print(answer);
    }

    public void showWomen() {
        String answer = service.showWomen();
        view.print(answer);
    }

    public void getList() {
        String answer = service.getList();
        view.print(answer);
    }

    public void sortByName() {
        service.sortByName();
        getList();
    }

    public void sortByAge() {
        service.sortByAge();
        getList();
    }

    public void sortByAmountOfChildren() {
        service.sortByAmountOfChildren();
        getList();
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }

    private String enterName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        return name;
    }

    private Gender enterGender() {
        System.out.println("Is this person a man or a woman?");
        System.out.println("Enter 'm' for 'man' or enter 'w' for 'woman'");
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

    private boolean checkForInt(String string) {
        if (string.matches("[0-9]*")) {
            return true;
        }
        return false;
    }

    private Human chooseHuman() {
        System.out.println("Enter number to choose person");
        getList();
        String choiceString = scanner.nextLine();
        if (checkForInt(choiceString)) {
            int choice = Integer.parseInt(choiceString);
            Human human = getArrayList().get(choice - 1);
            return human;
        } else {
            System.out.println("Smth went wrong. Try again");
        }
        return null;
    }

    private List<Human> getArrayList() {
        return service.getArrayList();
    }
}