package homeWork.Model.Service;

import java.io.IOException;
import java.time.LocalDate;

import homeWork.Model.Human.Gender;
import homeWork.Model.Human.Human;
import homeWork.Model.Tree.FamilyTree;
import homeWork.Model.Writer.FileHandler;

public class Service {
    private int idHuman;
    private FamilyTree<Human> service;

    public Service(){
        service = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(idHuman++, name, gender, birthDate, deathDate);
        addId(service);
        service.addHuman(human);
    }


    public void removeHuman(int idHuman) {
        service.removeHuman(getHumanById(idHuman));
    }

    public void addChildren(Human human){
        Human mother = getHumanById(human.getMother().getId());
        Human father = getHumanById(human.getFather().getId());
        mother.addChild(human);
        father.addChild(human);
    }

    private Human getHumanById(int idHuman) {
        for (Human human : service) {
            if (human.getId() == idHuman) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : service){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addId(FamilyTree<Human> humans){
        for (Human human : humans){
            human.setId(idHuman++);
        }
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }

    FileHandler fileHandler = new FileHandler();
    String fileName = "familyTree.java";

    public void saveToFile(){
        try {
            fileHandler.writeToFile(service, fileName);
            System.out.println("Family tree сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения family tree: " + e.getMessage());
        }
    }

    public void loadFromFile(){
        try {
            FamilyTree loadedTree = fileHandler.readFromFile(fileName);
            System.out.println("Family tree загружен из файла:");
            System.out.println(loadedTree);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки family tree: " + e.getMessage());
        }
    }



}