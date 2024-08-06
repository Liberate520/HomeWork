package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view ){
     this.view = view;
     service = new Service();
    }

    public void addHuman(String firstName, String patronymic, String lastName, String gender, LocalDate birthDate) {

        service.addHuman(firstName,patronymic,lastName,null, birthDate);
        getFamilyTreeInfo();
    }
    public void getFamilyTreeInfo(){
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }
    public void sortByName(){
        service.sortByName();
        getFamilyTreeInfo();
    }
    public void sortByBirthday(){
        service.sortByBirthday();
        getFamilyTreeInfo();
    }


}
