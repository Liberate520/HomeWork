package presenter;

import familyTreeApi.Service;
import ui.View;

import java.util.Calendar;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addFamilyTree(String member, String name) {
        return service.addFamilyTree(member, name);
    }

    public boolean addMember(String name, String kind, boolean isMale, Calendar bornDate) {
        return service.addMember(name, kind, isMale, bornDate);
    }

    public boolean addMember(String newName, String nameSimple) {
        return service.addMember(newName, nameSimple);
    }

    public boolean addChild(String parentName, String childName) {
        return service.addChild(parentName, childName);
    }

    public boolean addMarried(String married1Name, String married2Name, boolean isMarried) {
        return service.addMarried(married1Name, married2Name, isMarried);
    }

    public boolean isFindFamilyTree(String nameFTree) {
        return service.isFindFamilyTree(nameFTree);
    }

    public boolean load(String fileName) {
        service = new Service(service.read(fileName));
        return true;
    }

    public boolean save(String fileName) {
        service.save(fileName);
        return true;
    }

    public boolean printInfo() {
        view.print(service.printInfo());
        return true;
    }

    public boolean printFTrees() {
        view.print(service.printTrees());
        return true;
    }

    public boolean printTree() {
        view.print(service.printTree());
        return true;
    }

    public boolean printMember(String name) {
        view.print(service.printMemberInfo(name));
        return true;
    }

    public boolean sortByFirstName() {
        return service.sortByFirstName();
    }

    public boolean sortByLastName() {
        return service.sortByLastName();
    }

    public boolean sortByGender() {
        return service.sortByGender();
    }

    public boolean sortByBornDate() {
        return service.sortByBornDate();
    }

    public boolean quit() {
        return service.quit();
    }
}
