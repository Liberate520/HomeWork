package presenter;

import model.human.Gender;
import model.service.Service;
import model.tree.FamilyTree;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view){
        this.view = view;
        service = new Service(new FamilyTree());
    }

    public void addHuman(String name, String lastName, LocalDate dateOfBirth, Gender gender) {
        service.addHuman(name, lastName, dateOfBirth,gender);
        getHumanListInfo();
    }
    public void getHumanListInfo() {
        String answer =  service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
    public void sortByLastName() {
        service.sortByLastName();
        getHumanListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }
}
