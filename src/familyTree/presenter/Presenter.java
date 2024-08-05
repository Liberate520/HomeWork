package familyTree.presenter;

import familyTree.model.familyTree.ServiceFamilyTree;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;
import familyTree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private ServiceFamilyTree service;

    public Presenter(View view) {
        this.view = view;
        service = new ServiceFamilyTree();
    }

    public void addHuman(String lastName, String firstname, String patronymic,
                         Gender gender, LocalDate dayBirth, LocalDate dayDeath,
                         Human father, Human mother, List<Human> children, String placeBorn) {
        service.addHuman(lastName, firstname, patronymic,
                gender, dayBirth, dayDeath,
                null, null, null, placeBorn);
        getFamilyTree();
    }

    public void sortByID() {
        service.sortByID();
        getFamilyTree();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTree();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTree();
    }

    public void getFamilyTree() {
        String answer = service.getFamilyTreeList();
        view.PrintAnwser(answer);
    }

    public void saveFile() {
        try {
            service.saveFile("src/familyTree/file.txt");
            System.out.println("Программа успешно сохранена");
        } catch (Exception e) {
            System.out.println("Ошибка сохранения");
        } finally {
            getFamilyTree();
        }
    }

    public void addParent(int idHuman,int idParent){
        service.addParent(idHuman, idParent);
        getFamilyTree();
    }

    public void addChild(int idHuman,int idChild){
        service.addChild(idHuman, idChild);
        getFamilyTree();
    }


    public void loadFile() {
        try {
            service.openFile("src/familyTree/file.txt");
            service.setMaxID();
            System.out.println("Семейное древо успешно загружено");
            getFamilyTree();
        } catch (Exception e) {
            System.out.println("Ошибка открытия");
        }
    }

}
