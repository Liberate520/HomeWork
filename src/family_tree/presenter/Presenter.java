package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void addHuman (String name, LocalDate dob, Gender gender) {
        service.addHuman(name, dob, gender);
        getHumanListInfo();
    }

    public void setParents(int childId, Integer fatherId, Integer motherId) {
        service.setParents(childId, fatherId, motherId);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName () {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByDateBirth () {
        service.sortByDateBirth();
        getHumanListInfo();
    }

    public Human findHumanById(int id) {
        return service.findHumanById(id);
    }

    public List<Human> findHumansByName(String name) {
        return service.findHumansByName(name);
    }

    public void finish() {
        service.finish();
    }
}
