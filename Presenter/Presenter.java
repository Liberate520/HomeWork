package homeWork.Presenter;

import java.time.LocalDate;
import homeWork.Model.Human.Gender;
import homeWork.Model.Service.Service;
import homeWork.View.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        service.addHuman(name, gender, birthDay, deathDay);
        String info = service.getFamilyTree();
        view.printAnswer(info);
    }

    public void removeHuman(int idHuman) {
        service.removeHuman(idHuman);
        String info = service.getFamilyTree();
        view.printAnswer(info);
    }

    public void getFamilyTree() {
        String info = service.getFamilyTree();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        String info = service.getFamilyTree();
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        String info = service.getFamilyTree();
        view.printAnswer(info);
    }

    public void saveToFile() {
        service.saveToFile();
    }

    public void loadFromFile() {
        service.loadFromFile();
    }
}