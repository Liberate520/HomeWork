package presenter;

import model.Human.Gender;
import model.Human.Human;
import model.service.Service;
import view.View;

import java.io.IOException;
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

    public void writeTree(String filename) throws IOException {
        service.writeTree(filename);
    }

    public void readTree(String filename) throws IOException, ClassNotFoundException {
        service.readTree(filename);
    }

    public void SetMother(String personName, String motherName){
        service.setMother(personName, motherName);
    }


    public void SetFather(String personName, String fatherName) {
        service.setFather(personName, fatherName);
    }

    public void addChild(String personName, String childName) {
        service.addChild(personName, childName);
    }
}
