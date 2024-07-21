package presenter;

import model.Humans.Gender;
import model.Service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBorn, LocalDate dateOfDeath) {
        service.addHuman(name, dateOfBorn, dateOfDeath, gender);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumansInfo();
        view.printAnswer(answer);
    }

    public void sortByGender() {
        service.sortByGender();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
}
