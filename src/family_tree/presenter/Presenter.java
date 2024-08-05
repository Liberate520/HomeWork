package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String surname, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, List<Human> children) {
        service.addHuman(name, surname, dob, dod, gender, father, mother, children);
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
