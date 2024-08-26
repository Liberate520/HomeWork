package presenter;

import model.familyTree.ServiceFamilyTree;
import model.human.Gender;
import model.human.Human;
import view.View;

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
                gender, dayBirth, dayDeath, placeBorn);
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
            view.PrintAnwser("Программа успешно сохранена");
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
            service.openFile("src/file.txt");
            service.setMaxID();
            System.out.println("Семейное древо успешно загружено");
            getFamilyTree();
        } catch (Exception e) {
            System.out.println("Ошибка открытия");
        }
    }

}
