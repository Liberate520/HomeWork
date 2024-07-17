package family__tree.presenter;

import family__tree.model.family_tree_service.FamilyTreeService;
import family__tree.model.human.Gender;
import family__tree.model.human.Human;
import family__tree.model.writer.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Presenter implements TreePresenter {
    private FamilyTreeService<Human> familyTreeService;
    private Writer writer;
    private Scanner scanner;

    public Presenter(FamilyTreeService<Human> familyTreeService, Writer writer) {
        this.familyTreeService = familyTreeService;
        this.writer = writer;
        this.scanner = new Scanner(System.in);
    }

    public void addHuman(String name, LocalDate birthDate, String gender) {
        String formattedGender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();

        try {
            Human human = new Human(name, birthDate, Gender.valueOf(formattedGender));
            familyTreeService.addHuman(human);
            System.out.println("Человек добавлен.");
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректно указан пол. Введите Male или Female.");
        }
    }

    public void addChild(String parentName, String childName) {
        Human parent = findHumanByName(parentName);
        Human child = findHumanByName(childName);
        if (parent != null && child != null) {
            familyTreeService.addChild(parent, child);
            System.out.println("Ребенок добавлен к родителю.");
        } else {
            System.out.println("Родитель или ребенок не найден.");
        }
    }

    public void removeHuman(String name) {
        Human human = findHumanByName(name);
        if (human != null) {
            familyTreeService.removeHuman(human);
            System.out.println("Человек удален.");
        } else {
            System.out.println("Человек не найден.");
        }
    }

    public void findHuman(String name) {
        Human human = findHumanByName(name);
        if (human != null) {
            System.out.println("Найден человек: " + human);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    public void listHumans() {
        for (Human human : familyTreeService.getAllHumans()) {
            System.out.println(human);
        }
    }

    public void showChildren(String parentName) {
        Human parent = findHumanByName(parentName);
        if (parent != null) {
            List<Human> children = familyTreeService.getChildren(parent);
            if (children != null && !children.isEmpty()) {
                for (Human child : children) {
                    System.out.println(child);
                }
            } else {
                System.out.println(parentName + " не имеет известных детей.");
            }
        } else {
            System.out.println("Родитель не найден.");
        }
    }

    public void showParents(String childName) {
        Human child = findHumanByName(childName);
        if (child != null) {
            String parentsInfo = familyTreeService.getParents(child);
            if (parentsInfo != null && !parentsInfo.isEmpty()) {
                System.out.println("Родители " + childName + ": " + parentsInfo);
            } else {
                System.out.println(childName + " не имеет известных родителей.");
            }
        } else {
            System.out.println("Ребенок не найден.");
        }
    }

    public void sortByName() {
        familyTreeService.sortByName();
        listHumans();
    }

    public void sortByAge() {
        familyTreeService.sortByAge();
        listHumans();
    }

    public void saveTree() {
        try {
            writer.writeToFile(familyTreeService, "familyTree.dat");
            System.out.println("Семейное древо успешно сохранено в файл familyTree.dat");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении семейного древа: " + e.getMessage());
        }
    }

    public void loadTree() {
        try {
            familyTreeService = writer.readFromFile("familyTree.dat");
            System.out.println("Семейное древо успешно загружено из файла familyTree.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке семейного древа: " + e.getMessage());
        }
    }

    private Human findHumanByName(String name) {
        for (Human human : familyTreeService.getAllHumans()) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }
}
