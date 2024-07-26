package presenter;

import model.serice.Service;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private View view;
    private Service service;

    public FamilyTreePresenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPerson(String name, String gender, LocalDate birthDay) {
        service.addPerson(name, gender, String.valueOf(birthDay));
        getInfoTree();
    }

    public String findByName(String name) {
        return service.findByName(name);
    }

    public void getInfoTree() {
        String answer = service.getInfoTree();
        view.printAnswer(answer);
    }

    public List<Integer> foundPersonId(String name) {
        return service.foundPersonId(name);
    }

    public void removePerson(int id) {
        service.removePerson(id);
    }

    public void sortById() {
        service.sortById();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void saveTree() {
        service.save();
    }

    public void readTree() {
        service.read();
    }
}