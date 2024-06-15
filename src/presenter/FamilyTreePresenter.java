package presenter;

import model.Person;
import service.FamilyTreeService;
import view.TreeView;
import java.io.IOException;
import java.util.List;

public class FamilyTreePresenter implements TreePresenter {
    private TreeView view;
    private FamilyTreeService service;

    public FamilyTreePresenter(TreeView view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void loadFamilyTree() {
        try {
            List<Person> loadedMembers = service.loadFamilyTree();
            view.displayMembers(loadedMembers);
        } catch (IOException e) {
            view.showMessage("Ошибка загрузки семейного дерева: " + e.getMessage());
        }
    }

    @Override
    public void addMember(String name, int age) {
        Person person = new Person(name, age);
        service.addMember(person);
        view.showMessage("Член добавлен: " + person);
        saveFamilyTree();
    }

    @Override
    public void findMember(String name) {
        Person person = service.findPersonByName(name);
        if (person != null) {
            view.showMessage("Найден: " + person);
        } else {
            view.showMessage("Человек не найден.");
        }
    }

    @Override
    public void getChildrenOf(String name) {
        Person parent = service.findPersonByName(name);
        if (parent != null) {
            List<Person> children = service.getChildrenOf(parent);
            view.displayChildren(children);
        } else {
            view.showMessage("Человек не найден.");
        }
    }

    private void saveFamilyTree() {
        try {
            service.saveFamilyTree();
        } catch (IOException e) {
            view.showMessage("Ошибка сохранения семейного дерева: " + e.getMessage());
        }
    }
}





