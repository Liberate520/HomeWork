package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, String fatherID, String matherID) {

        service.addHuman(name, dob, dod, gender, fatherID, matherID);


    }
    public void sortHumansByName(){
        service.sortByName();
    }
    public void getHumanInfo(int sortId){
        System.out.println(service.getHumansInfo(sortId));
    }

    public void sortHumansByDOB() {
        service.sortByDOB();
    }

    public void searhHumansByName(String name) {
        service.searhHumansByName(name);
    }
}
