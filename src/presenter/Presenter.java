package presenter;

import model.FamilyTree.FamilyTree;
import model.Human.Gender;
import view.View;

import java.security.Provider;
import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String secondName, String gender, LocalDate birthDate) {
        service.addHuman(name, secondName, gender, birthDate);
        getHumanListInfo();
    }

    public String getHumanListInfo(){
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
}
