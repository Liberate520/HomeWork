import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FamilyTreePresenterImpl<T extends FamilyMember> implements FamilyTreePresenter {
    private FamilyTreeView<T> view;
    private FamilyTree<T> familyTree;
    private FileHandler<T> fileHandler;

    public FamilyTreePresenterImpl(FamilyTreeView<T> view, FamilyTree<T> familyTree, FileHandler<T> fileHandler) {
        this.view = view;
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    @Override
    public void onSearchById(String id) {
        T member = familyTree.getMemberById(id);
        if (member != null) {
            view.displayMember(member);
        } else {
            view.displayMessage("Человек с таким ID не найден.");
        }
    }

    @Override
    public void onSearchByName(String name) {
        List<T> members = familyTree.getMemberByName(name);
        if (!members.isEmpty()) {
            view.displayMembers(members);
        } else {
            view.displayMessage("Человек с таким именем не найден.");
        }
    }

    @Override
    public void onSearchBySurname(String surname) {
        List<T> members = familyTree.getMemberByName(surname);
        if (!members.isEmpty()) {
            view.displayMembers(members);
        } else {
            view.displayMessage("Человек с такой фамилией не найден.");
        }
    }

    @Override
    public void onShowChildren(String id) {
        List<T> children = familyTree.getAllChildren(id);
        if (!children.isEmpty()) {
            view.displayMembers(children);
        } else {
            view.displayMessage("У этого человека нет детей или ID неверен.");
        }
    }

    @Override
    public void onSaveTree(String filename) {
        try {
            fileHandler.saveFamilyTree(familyTree, filename);
            view.displayMessage("Семейное древо сохранено.");
        } catch (IOException e) {
            view.displayMessage("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    @Override
    public void onLoadTree(String filename) {
        try {
            familyTree = fileHandler.loadFamilyTree(filename);
            view.displayMessage("Семейное древо загружено.");
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    @Override
    public void onSortByAge() {
        List<T> sortedByAge = familyTree.sortByAge((Comparator<T>) Comparator.comparingInt(Human::getAge));
        view.displayMembers(sortedByAge);
    }

    @Override
    public void onSortByGender() {
        List<T> sortedByGender = familyTree.sortByGender((Comparator<T>) Comparator.comparing(Human::getGender));
        view.displayMembers(sortedByGender);
    }

    @Override
    public void onExit() {
        view.displayMessage("Выход.");
    }

    @Override
    public void showMenu() {
        view.showMenu();
    }
}