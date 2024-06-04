/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class Presenter
 * @version v1.0
 */

package family_true.presenter;

import family_true.model.family_tree.Service;
import family_true.model.human.Gender;
import family_true.model.human.Human;
import family_true.view.View;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private Service service;

    public Presenter (View view) {
        this.view = view;
        this.service = new Service();
    }

    public void addEntity(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        service.addHumanToLastTree(name, patronymic, lastName, gender, birthDay, deathDay);
    }

    public void addParent(long idChild, long idParent) {
        service.addParent(idChild, idParent);
    }

    public Human findHumanById(long id) {
        return (Human) service.findEntityById(id);
    }

    public void sortByLastName() {
        service.sortFamilyTreesEntitiesByLastName();
    }

    public void sortByBirthDay() {
        service.sortFamilyTreesEntitiesByBirthDay();
    }

    public void sortById() {
        service.sortFamilyTreesEntitiesById();
    }

    public void getEntityListInfo() {
        view.printAnswer(service.getFamilyTreeGroup().getInfo());
    }

    public void exportList() {
        service.exportList();
    }

    public void importList() {
        service.importList();
    }
}
