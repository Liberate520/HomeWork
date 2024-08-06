package presenter;

import model.familiTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        service.addHuman(name, gender, dateOfBirth);
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

}
