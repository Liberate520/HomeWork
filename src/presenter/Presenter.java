package presenter;


import model.Human.*;
import model.FamilyTree.*;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String secondName, Gender gender, LocalDate birthDate, LocalDate deathDate,
                         String motherName, String fatherName) {
        service.addHuman(name, secondName, gender, birthDate, deathDate, motherName, fatherName);
        getHumanListInfo();
    }

    public void getHumanListInfo(){
        String answer =  service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void loadFamilyTree() {
        service.loadFamilyTree();
        getHumanListInfo();
    }

    public void saveFamilyTree() {
        service.saveFamilyTree();
        getHumanListInfo();
    }
}
