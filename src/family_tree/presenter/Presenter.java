package family_tree.presenter;

import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, List<Human> children, Human mother, Human father){

        service.addHuman(name, dob, dod, gender, children, mother, father);
    }

    public void addChild(Human child, Human human) {

        service.addChild(child, human);
    }

    public void setMother(Human mother, Human human) {
        service.setMother(mother, human);
    }

    public void setFather(Human father, Human human) {
        service.setFather(father, human);
    }

    public void getHumanListInfo(){
        String humanListInfo = service.getHumanListInfo();
        view.printAnswer(humanListInfo);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthday(){
        service.sortByBirthday();
    }
}
