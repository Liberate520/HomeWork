package presenter;

import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, int genderChoice, int year, int month, int day) {
        service.addHuman(name, genderChoice, year, month, day);
        getFamilyTreeInfo();
    }

    public void setDateOfDeath(int id, int year, int month, int day) {
        service.setHumanDateOfDeath(id, year, month, day);
        getFamilyTreeInfo();
    }

    public void setHumanParents(int humanId, int fatherId, int motherId) {
        service.setHumanParents(humanId, fatherId, motherId);
        getFamilyTreeInfo();
    }

    public void setHumanSpouse(int humanId, int spouseId) {
        service.setHumanSpouse(humanId, spouseId);
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void saveFamilyTree() {
        service.saveFamilyTree();
        String info = "Данные сохранены";
        view.printAnswer(info);
    }

    public void loadFamilyTree() throws ClassNotFoundException {
        service.loadFamilyTree();
        String info = "Данные загружены";
        view.printAnswer(info);
    }

    public boolean isInFamilyTree(int id) {
        return service.isInFamilyTree(id);
    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTreeInfo();
        view.printAnswer(info);
    }

}