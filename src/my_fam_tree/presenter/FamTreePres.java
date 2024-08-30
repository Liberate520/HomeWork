package my_fam_tree.presenter;

import my_fam_tree.model.FamTreeOper;
import my_fam_tree.model.Human;
import my_fam_tree.service.FamTreeMan;
import my_fam_tree.service.FamTreeSer;
import my_fam_tree.view.FamTreeView;

import java.util.List;


public class FamTreePres {
    private FamTreeSer service;
    private FamTreeView view;
    private FamTreeMan fileMan;

    public FamTreePres(FamTreeSer service, FamTreeView view, FamTreeMan fileMan) {
        this.service = service;
        this.view = view;
        this.fileMan = fileMan;
    }

    public void run() {
        while (true) {
            view.menu();
            int choice = view.menuChoice();

            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    findHuman();
                    break;
                case 3:
                    showRelatives();
                    break;
                case 4:
                    service.sortName();
                    view.screenMess("Отсортировано по имени");
                    break;
                case 5:
                    service.sortBirthDate();
                    view.screenMess("Отсортировано по дате рождения");
                    break;
                case 6:
                    saveFile();
                    break;
                case 7:
                    loadFile();
                    break;
                case 8:
                    addParentChild();
                    break;
                case 9:
                    showChildren();
                    break;
                case 10:
                    showParents();
                    break;
                case 11:
                    showSiblings();
                    break;
                case 12:
                    showAncestors();
                    break;
                case 13:
                    showDescendants();
                    break;
                case 14:
                    showGenerationCount();
                    break;
                case 0:
                    return;
                default:
                    view.screenMess("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    private void addHuman() {
        String name = view.getInput("Введите имя: ");
        String gender = view.getInput("Введите пол (М/Ж): ");
        String birthDateInput = view.getInput("Введите дату рождения (ГГГГ-ММ-ДД): ");


        service.addHuman(name, gender, birthDateInput);
        view.screenMess("Человек добавлен в семейное дерево.");
    }

    private void findHuman() {
        String name = view.getInput("Введите имя для поиска: ");
        Human human = service.findHuman(name);
        if (human != null) {
            view.screenMess("Найдено:");
            view.screenHuman(human);
        } else {
            view.screenMess("Человек не найден.");
        }
    }

    private void showRelatives() {
        view.screenMess("Все члены семьи:");
        view.screenHumanList(service.getRelatives());
    }

    private void saveFile() {
        String fileName = view.getInput("Введите имя файла для сохранения: ");
        try {
            fileMan.saveFile(fileName, service.getFamilyTree());
            view.screenMess("Семейное дерево сохранено в файл.");
        } catch (Exception e) {
            view.screenMess("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private void loadFile() {
        String fileName = view.getInput("Введите имя файла для загрузки: ");
        try {
            FamTreeOper<Human> loadedTree = (FamTreeOper<Human>) fileMan.loadFromFile(fileName);
            service.setFamilyTree(loadedTree);
            view.screenMess("Семейное дерево загружено из файла.");
        } catch (Exception e) {
            view.screenMess("Ошибка при загрузке: " + e.getMessage());
        }
    }
    private void addParentChild() {
        String parentName = view.getInput("Введите имя родителя: ");
        String childName = view.getInput("Введите имя ребенка: ");
        service.addParentChild(parentName, childName);
        view.screenMess("Отношение родитель-ребенок добавлено.");
    }

    private void showChildren() {
        String name = view.getInput("Введите имя человека: ");
        List<Human> children = service.getChildren(name);
        if (children != null && !children.isEmpty()) {
            view.screenMess("Дети:");
            view.screenHumanList(children);
        } else {
            view.screenMess("У этого человека нет детей или человек не найден.");
        }
    }

    private void showParents() {
        String name = view.getInput("Введите имя человека: ");
        Human[] parents = service.getParents(name);
        if (parents != null) {
            view.screenMess("Родители:");
            if (parents[0] != null) view.screenHuman(parents[0]);
            if (parents[1] != null) view.screenHuman(parents[1]);
        } else {
            view.screenMess("У этого человека нет родителей или человек не найден.");
        }
    }

    private void showSiblings() {
        String name = view.getInput("Введите имя человека: ");
        List<Human> siblings = service.getSiblings(name);
        if (siblings != null && !siblings.isEmpty()) {
            view.screenMess("Братья/сестры:");
            view.screenHumanList(siblings);
        } else {
            view.screenMess("У этого человека нет братьев/сестер или человек не найден.");
        }
    }

    private void showAncestors() {
        String name = view.getInput("Введите имя человека: ");
        List<Human> ancestors = service.getAncestors(name);
        if (!ancestors.isEmpty()) {
            view.screenMess("Предки:");
            view.screenHumanList(ancestors);
        } else {
            view.screenMess("У этого человека нет предков или человек не найден.");
        }
    }

    private void showDescendants() {
        String name = view.getInput("Введите имя человека: ");
        List<Human> descendants = service.getDescendants(name);
        if (!descendants.isEmpty()) {
            view.screenMess("Потомки:");
            view.screenHumanList(descendants);
        } else {
            view.screenMess("У этого человека нет потомков или человек не найден.");
        }
    }

    private void showGenerationCount() {
        int count = service.getGenerationCount();
        view.screenMess("Количество поколений в семейном дереве: " + count);
    }
}


