package presenter;

import model.FamilyTree.Service;
import model.Gender.Gender;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();

    }

    public void addFamilyItem(String name, Gender gender, LocalDate birthdate) {
        service.addFamilyItem(name,gender,birthdate);
        showFamilyTree();
    }

    public void showFamilyTree() {
        String answer = service.showFamilyTree();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        showFamilyTree();
    }

    public void sortByAge() {
        service.sortByAge();
        showFamilyTree();
    }

    public void findFamilyItemByName(String name) {
        String answer = service.findFamilyItemByName(name);
        view.printAnswer(answer);

    }

    public void AddParentOrChild(int idChild, int idParent) {
        service.AddParentOrChild(idChild, idParent);
        showFamilyTree();
    }

    public void Save() {
        service.Save();
    }

    public void ReadFamilyTree() {
        service.ReadFamilyTree();
        showFamilyTree();
    }
}
