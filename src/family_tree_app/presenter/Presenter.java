package family_tree_app.presenter;

import java.time.LocalDate;
import java.util.List;

import family_tree_app.model.Service;
import family_tree_app.model.human.Gender;
import family_tree_app.model.human.Human;
import family_tree_app.view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPersonToTree(String name, Gender gender, LocalDate dateOfBirth) {
        service.addPerson(name, gender, dateOfBirth);
        getList();
    }

    public void addPersonToTree(String name, Gender gender) {
        service.addPerson(name, gender);
        getList();
    }

    public void setParents(Human child, Human parent1, Human parent2) {
        service.setParents(child, parent1, parent2);
    }

    public void setParent(Human child, Human parent) {
        service.setParent(child, parent);
    }

    // public void setChildren(Human parent, Human child) {
    //     service.setChildren(parent, child);
    // }

    public void setPeriodOfLife(Human human, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        service.setPeriodOfLife(human, dateOfBirth, dateOfDeath);
    }

    public void showProgenitors(Human human) {
        String answer = service.showProgenitors(human);
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

    public List<Human> getArrayList() {
        return service.getArrayList();
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
}
