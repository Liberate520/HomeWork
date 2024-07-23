package presenter;

import model.Human.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addPerson(String name, LocalDate dateOfBirth, Gender gender){
        service.addFamilyMember(name, dateOfBirth, gender);
        getPersonListInfo();
    }

    public void getPersonListInfo() {
        String answer = service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getPersonListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getPersonListInfo();
    }
}
