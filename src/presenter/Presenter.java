package presenter;


import model.human.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public int addHuman(String name, LocalDate dateOfBirthday, Gender gender) {
        return service.addHuman(name, dateOfBirthday, gender);
    }

    public void addParent(int child, int parent) {
        service.addParent(child, parent);
    }

    public void addChild(int child, int parent) {
        service.addChild(child, parent);
    }

    public boolean availability(int id) {
        return service.availability(id);
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByID() {
        service.sortByID();
        getFamilyTreeInfo();
    }

    public void loadTree() {
        service.loadTreeSerialize();
    }

    public void saveTree() {
        service.saveTreeSerialize();
    }
}
