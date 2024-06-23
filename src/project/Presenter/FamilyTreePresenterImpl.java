package project.Presenter;
import java.io.IOException;
import java.util.List;

import project.Members.Human;
import project.Members.TreeMember;
import project.View.FamilyTreeView;
import project.servis.FamilyTreeService;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTreeService service;

    public FamilyTreePresenterImpl(FamilyTreeView view) {
        this.view = view;
        this.service = new FamilyTreeService();
    }

    @Override
    public void loadFamilyTree(String filename) {
        try {
            service.loadFamilyTree(filename);
            view.displayMessage("Семейное древо успешно загружено из " + filename);
            view.displayMemberDescriptions(service.getMemberDescriptions());
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Не удалось загрузить семейное дерево: " + e.getMessage());
        }
    }

    @Override
    public void saveFamilyTree(String filename) {
        try {
            service.saveFamilyTree(filename);
            view.displayMessage("Семейное дерево успешно сохранено в " + filename);
        } catch (IOException e) {
            view.displayMessage("Не удалось сохранить семейное дерево: " + e.getMessage());
        }
    }

    @Override
    public void addMember(Human member) {
        if (service.addMember(member)) {
            view.displayMessage("Добавлен(а) в древо " + member);
        } else {
            view.displayMessage("Не удалось добавить " + member);
        }
    }

    @Override
    public void displayChildrenOf(String name) {
        TreeMember member = service.getHumanByName(name);
        if (member != null) {
            List<TreeMember> children = service.getChildrenOf((Human) member);
            view.displayMessage("Дети " + name + ":");
            view.displayChildren(children);
        } else {
            view.displayMessage(name + " не найден");
        }
    }

    @Override
    public void sortByName() {
        view.displayMessage("Сортировка по имени:");
        service.sortByName();
        view.displayMemberDescriptions(service.getMemberDescriptions());
    }

    @Override
    public void sortByBirthDate() {
        view.displayMessage("Сортировка по дате рождения:");
        service.sortByBirthDate();
        view.displayMemberDescriptions(service.getMemberDescriptions());
    }
}