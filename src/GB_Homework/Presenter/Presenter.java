package GB_Homework.Presenter;

import GB_Homework.Model.Family_Tree.FamilyTree;
import GB_Homework.Model.Gender.Gender;
import GB_Homework.Model.Service.FamilyTreeService;
import GB_Homework.Model.Service.FileService;
import GB_Homework.Model.Human.Human;
import GB_Homework.View.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Presenter {
    private FamilyTreeService familyTreeService;
    private FileService fileService;
    private View view;

    public Presenter(FamilyTreeService familyTreeService, FileService fileService) {
        this.view = view;
        this.familyTreeService = familyTreeService;
        this.fileService = fileService;
    }

    public void sortByData() {
        familyTreeService.sortByData();
    }

    public void sortByName() {
        familyTreeService.sortByName();
    }

    public String getFamilyTree() {
        return familyTreeService.getFamilyTree().toString();
    }

    public void printNameFamilyTree() {
        familyTreeService.printNameFamilyTree();
    }

    public String getAgeInfo(int id) {
        Human human = familyTreeService.getById(id);
        if (human != null) {
            return "Возраст: " + familyTreeService.getAge(human);
        } else {
            return "Человек с id " + id + " не найден.";
        }
    }

    public String getSiblingsInfo(int id) {
        List<Human> siblings = familyTreeService.getSiblings(id);
        if (siblings != null && !siblings.isEmpty()) {
            return "Братья и сёстры: " + siblings.stream().map(Human::getName).collect(Collectors.joining(", "));
        } else {
            return "Братья и сёстры не найдены.";
        }
    }

    public void addChild(int humanId, int childId) {
        Human human = familyTreeService.getById(humanId);
        Human child = familyTreeService.getById(childId);
        familyTreeService.addChild(human, child);
    }

    public void addParent(int childId, int parentId, String parentType) {
        Human child = familyTreeService.getById(childId);
        Human parent = familyTreeService.getById(parentId);

        if (child != null && parent != null) {
            if (parentType.equalsIgnoreCase("father")) {
                familyTreeService.addFather(child, parent);
            } else if (parentType.equalsIgnoreCase("mother")) {
                familyTreeService.addMother(child, parent);
            }
        } else {
            System.out.println("Ошибка: не удалось найти ребенка или родителя по указанным id.");
        }
    }

    public String addSpouseInfo(int humanId, int spouseId) {
        Human human = familyTreeService.getById(humanId);
        Human spouse = familyTreeService.getById(spouseId);

        if (human != null && spouse != null) {
            familyTreeService.addSpouse(human, spouse);
            return "Супруг(а) добавлен(а) успешно.";
        } else {
            return "Ошибка: один или оба человека с указанными id не найдены.";
        }
    }

    public void saveFamilyTree(String file) throws IOException {
        fileService.saveFamilyTree(familyTreeService.getFamilyTree(), file);
    }

    public void readFamilyTree(String file) throws IOException, ClassNotFoundException {
        FamilyTree<Human> loadedTree = fileService.readFamilyTree(file);
        familyTreeService = new FamilyTreeService(); // Создаем новый экземпляр FamilyTreeService с загруженными данными
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        familyTreeService.addHuman(name, birthDate, gender);
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        familyTreeService.addHuman(name, birthDate, deathDate, gender);
    }
}
