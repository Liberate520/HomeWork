import java.util.ArrayList;
import java.util.List;

/**
 * Класс для представления генеалогического древа.
 * Управляет членами древа, их отношениями и предоставляет методы для работы с данными.
 */
public class FamilyTree {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    /**
     * Добавляет нового члена в генеалогическое древо.
     */
    public void addMember(Human member) {
        members.add(member);
    }

    /**
     * Метод для вывода информации о всех членах семьи
     */
    public void displayFamilyTree() {
        for (Human member : members) {
            System.out.println(member.toString());
        }
    }

    public static void main(String[] args) {
        // Пример использования класса FamilyTree
        FamilyTree familyTree = new FamilyTree();

        // Создаем объекты Human для представления членов семьи
        Human father = new Human("Иван Петров", Gender.MALE, "01.01.1960", "");
        Human mother = new Human("Мария Петрова", Gender.FEMALE, "01.01.1965", "");
        Human child1 = new Human("Анна Петрова", Gender.FEMALE, "01.01.1990", "");
        Human child2 = new Human("Павел Петров", Gender.MALE, "01.01.1995", "");

        // Устанавливаем родительские связи и добавляем детей
        father.setSpouse(mother);
        mother.setSpouse(father);
        father.addChild(child1);
        father.addChild(child2);

        // Добавляем членов семьи в генеалогическое древо
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        // Выводим информацию о членах семьи
        familyTree.displayFamilyTree();
    }

    public Human[] getMembers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMembers'");
    }
}