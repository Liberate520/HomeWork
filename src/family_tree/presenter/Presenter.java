package family_tree.presenter;

import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, List<String> children, String strMother, String strFather){
        List<Human> child = convertNamesToHumans(children);
        Human mother = convertNamesParentsToHumans(strMother);
        Human father = convertNamesParentsToHumans(strFather);

        service.addHuman(name, dob, dod, gender, child, mother, father);
    }

    public Human convertNamesParentsToHumans(String name){
        return new Human(name);
    }
    public List<Human> convertNamesToHumans(List<String> names) {
        List<Human> humans = new ArrayList<>();

        for (String name : names) {

            Human human = new Human(name);
            humans.add(human);
        }
        return humans;
    }



    public void addChild(String nameMother, List<String> nameChild) {
        List<Human> child = convertNamesToHumans(nameChild);

        service.addChild(nameMother, child);
    }

    public void setMother(String name, String nameMother) {
        Human mother = convertNamesParentsToHumans(nameMother);
        service.setMother(name, mother);
    }

    public void setFather(String name, String nameFather) {
        Human mother = convertNamesParentsToHumans(nameFather);
        service.setFather(name, mother);
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

