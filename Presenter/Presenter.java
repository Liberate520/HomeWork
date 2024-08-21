package homeWork.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import homeWork.Model.Human.Gender;
import homeWork.Model.Service.Service;
import homeWork.View.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    private void updateView() {
        String info = service.getFamilyTree();
        view.printAnswer(info);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        service.addHuman(name, gender, birthDay, deathDay);
        updateView();
    }

    public void removeHuman(int idHuman) {
        service.removeHuman(idHuman);
        updateView();
    }

    public void getFamilyTree() {
        updateView();
    }

    public void sortByAge() {
        service.sortByAge();
        updateView();
    }

    public void sortByName() {
        service.sortByName();
        updateView();
    }

    public void saveToFile(String fileName) {
        try {
            service.saveToFile(fileName);
            view.printAnswer("Family tree has been saved to file: " + fileName);
        } catch (IOException e) {
            view.printAnswer("Error saving family tree: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try {
            service.loadFromFile(fileName);
            view.printAnswer("Family tree has been loaded from file: " + fileName);
            updateView();
        } catch (IOException | ClassNotFoundException e) {
            view.printAnswer("Error loading family tree: " + e.getMessage());
        }
    }


}