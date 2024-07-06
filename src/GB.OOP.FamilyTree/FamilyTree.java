import OOP.Family_Tree.Human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    // ПОЛЯ
    private List<Human> humans; // список для хранения "лист-людей"

    public FamilyTree(){
        humans = new ArrayList<>();
    } // инициолизация листа-людей в конструкторе

// метод нахождение человека по имени
    public Human getHumanName(String name){
        for (Human human: humans){
            if (human.getName().equalsIgnoreCase(name)){ //сравниваем строки не зависимо от регистра
                return human;
            }
        }
        return null;
    }
    //метод добавление людей
    public void addHuman(Human human){
        humans.add(human);
    }
    //
    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (Human human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}