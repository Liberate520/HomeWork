package presenter;

import model.human.Gender;
import model.service.Service;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {

    private View view;
    private Service service;



    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        service.addHuman(name, birthDate, gender);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByBirthDate() {
        service.sortByName();
        getHumanListInfo();
    }


    public void saveTree() {
        service.saveTree(service);
    }

    public void readTree() {
        Service loadedService = service.readTree();
        if (loadedService != null) {
            this.service = loadedService;
            view.printAnswer("Семейное дерево успешно загружено.\n");
        } else {
            view.printAnswer("Ошибка при загрузке семейного дерева.\n");
        }
    }

    public void setParentId(long childId, long parentId) {
        service.setParentId(childId,parentId);
    }

    public int familyTreeSize() {
        return service.familyTreeSize();
    }
}
