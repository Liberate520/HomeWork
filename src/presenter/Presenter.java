package presenter;

import model.human.Gender;
import model.human.Human;
import model.service.Service;
import model.writable.FileHandler;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private final View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dateOfBirthday, Gender gender) {
        service.addHuman(name, dateOfBirthday, gender);
    }

    public void addParent(String name, LocalDate dateOfBirthday, Gender gender, int id) {
        service.addParent(name, dateOfBirthday, gender, id);
    }
    public void addChild(String name, LocalDate dateOfBirthday, Gender gender, int id) {
        service.addChild(name, dateOfBirthday, gender, id);
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
        service.loadTree();
    }

    public void saveTree() {
        service.saveTree();
    }

    public Service getService() {
        return service;
    }

    static void saveTree(Service service) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(service);
    }
}
