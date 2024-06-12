import java.io.IOException;
import java.util.List;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree<TreeMember> familyTree;
    private FileHandler fileHandler;

    public FamilyTreePresenterImpl(FamilyTreeView view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    @Override
    public void loadFamilyTree(String filename) {
        try {
            familyTree = (FamilyTree<TreeMember>) fileHandler.readFromFile(filename);
            view.displayMessage("Семейное древо успешно загружено из " + filename);
            view.displayMemberDescriptions(familyTree.getMemberDescriptions());
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Не удалось загрузить семейное дерево: " + e.getMessage());
        }
    }

    @Override
    public void saveFamilyTree(String filename) {
        try {
            fileHandler.writeToFile(filename, familyTree);
            view.displayMessage("Семейное дерево успешно сохранено в " + filename);
        } catch (IOException e) {
            view.displayMessage("Не удалось сохранить семейное дерево: " + e.getMessage());
        }
    }

    @Override
    public void addMember(Human member) {
        if (familyTree.addMember(member)) {
            view.displayMessage("Добавлен(а) в древо " + member);
        } else {
            view.displayMessage("Не удалось добавить " + member);
        }
    }

    @Override
    public void displayChildrenOf(String name) {
        TreeMember member = familyTree.getHumanByName(name);
        if (member != null) {
            List<TreeMember> children = familyTree.getChildrenOf((Human) member);
            view.displayMessage("Дети " + name + ":");
            view.displayChildren(children);
        } else {
            view.displayMessage(name + " не найден");
        }
    }

    @Override
    public void sortByName() {
        view.displayMessage("Сортировка по имени:");
        familyTree.sortByName();
        view.displayMemberDescriptions(familyTree.getMemberDescriptions());
    }

    @Override
    public void sortByBirthDate() {
        view.displayMessage("Сортировка по дате рождения:");
        familyTree.sortByBirthDate();
        view.displayMemberDescriptions(familyTree.getMemberDescriptions());
    }

    public void setView(FamilyTreeView view) {
        this.view = view;
    }
}

