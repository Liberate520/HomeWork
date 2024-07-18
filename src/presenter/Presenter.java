package presenter;

import model.service.Service;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String genderStr, LocalDate birthDate) {
        service.addHuman(name, genderStr, birthDate);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortById() {
        service.sortById();
    }

    public void saveTree() {
        service.saveTree();
    }

    public void readTree() {
        service.readTree();
    }

    public String findByName(String name) {
        return service.findByName(name);
    }

    public List<Integer> foundHumansId(String name) {
        return service.foundHumansId(name);
    }

    public void removeHuman(int id) {
        service.removeHuman(id);
    }
}
