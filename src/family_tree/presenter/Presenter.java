package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
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

    public Gender fromStringToGender(String genderStr) {
        if (genderStr.equals("male"))
            return Gender.male;
        else { return Gender.female; }
    }

    public void addHuman(String name, String surname, LocalDate dob, LocalDate dod, Gender gender) {
        service.addHumanNullNodes(name, surname, dob, dod, gender);
        humansInfo();
    }

    public void humansInfo() {
        String info = service.humansInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        humansInfo();
    }

    public void sortByName() {
        service.sortByName();
        humansInfo();
    }

    public void getInfoAboutParents(Human human) {
        service.getInfoAboutParents(human);
    }

    public void getInfoAboutChildren(Human human) {
        service.getInfoAboutChildren(human);
    }

    public void addChild(int idParent, int idChild) {
        service.addChild(idParent, idChild);
    }
}
