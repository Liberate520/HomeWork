package familytree.presenter;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.view.FamilyTreeView;
import familytree.io.FamilyTreeFileIO;
import familytree.io.FamilyTreeIO;

import java.io.IOException;
import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView<Person> view;
    private FamilyTreeIO<FamilyTree<Person>> familyTreeIO;

    public FamilyTreePresenter(FamilyTreeView<Person> view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.familyTreeIO = new FamilyTreeFileIO<>();
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMenu();
            String command = view.getInput();

            switch (command) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    displayTree();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByBirthDate();
                    break;
                case "5":
                    saveTree();
                    break;
                case "6":
                    loadTree();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    view.showError("Неверная команда. Попробуйте снова.");
            }
        }
    }

    private void addPerson() {
        view.promptForPersonDetails();
        Person person = new Person(view.getName(), view.getGender(), LocalDate.parse(view.getBirthDate()), view.getDeathDate().isEmpty() ? null : LocalDate.parse(view.getDeathDate()));
        familyTree.addNode(person);
    }

    private void displayTree() {
        view.displayTree(familyTree.getNodes());
    }

    private void sortByName() {
        familyTree.sortBy(Person.sortByName());
    }

    private void sortByBirthDate() {
        familyTree.sortBy(Person.sortByBirthDate());
    }

    private void saveTree() {
        String fileName = view.getFileName();
        try {
            familyTreeIO.writeToFile(familyTree, fileName);
            view.showSaveSuccess(fileName);
        } catch (IOException e) {
            view.showError("Ошибка при сохранении дерева: " + e.getMessage());
        }
    }

    private void loadTree() {
        String fileName = view.getFileName();
        try {
            familyTree = familyTreeIO.readFromFile(fileName);
            view.showLoadSuccess(fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.showError("Ошибка при загрузке дерева: " + e.getMessage());
        }
    }
}
