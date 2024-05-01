package presenter;

import model.human.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dateOfBirthday, Gender gender) {
        service.addHuman(name, dateOfBirthday, gender);
    }

    public void getFamalyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamalyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamalyTreeInfo();
    }
}
