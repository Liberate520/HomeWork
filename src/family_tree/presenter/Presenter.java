package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;
import java.util.Scanner;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Gender fromStringToGender(String genderStr) {
        if (genderStr.equals("male"))
            return Gender.male;
        else { return Gender.female; }
    }

    public String getGenderString() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите пол (male/female)");
            String genderString = scanner.nextLine().toLowerCase();
            if (genderString.equals("male")) {
                return "male";
            } else if (genderString.equals("female")) {
                return "female";
            } else { System.out.println("Не соответствует male/female"); }
        }
    }

    public void addHuman(String name, String surname, LocalDate dob, LocalDate dod, Gender gender) {
        service.addHumanNullNodes(name, surname, dob, dod, gender);
        humansInfo();
    }

    public void humansInfo() {
        String info = service.humansInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        humansInfo();
    }

    public void sortByName() {
        service.sortByName();
        humansInfo();
    }

    public void getInfoAboutParents(Human human) {
        service.getInfoAboutParents(human);
    }

    public void getInfoAboutChildren(Human human) {
        service.getInfoAboutChildren(human);
    }

    public void addChild(Human child) {
        service.addChild(child);
    }
}
