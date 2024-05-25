import java.util.ArrayList;
import java.util.List;

/**
 * Класс для поиска родственных связей в генеалогическом древе.
 * Предоставляет методы для поиска родителей, супруга, братьев/сестер выбранного человека.
 */
public class RelationshipSearch {

    private FamilyTree familyTree; // Генеалогическое древо

    public RelationshipSearch(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    // Метод для поиска всех детей указанного человека
    public List<Human> findChildren(String personName) {
        List<Human> children = new ArrayList<>();

        // Проходим по каждому члену семьи в генеалогическом древе
        for (Human member : familyTree.getMembers()) {
            // Проверяем, является ли данный член родителем
            if (member.hasChild(personName)) {
                // Если да, добавляем его в список детей
                children.add(member);
            }
        }

        return children;
    }

    // Метод для поиска всех родителей указанного человека
    public List<Human> findParents(String personName) {
        List<Human> parents = new ArrayList<>();

        // Проходим по каждому члену семьи в генеалогическом древе
        for (Human member : familyTree.getMembers()) {
            // Проверяем, является ли данный член ребенком
            if (member.hasChild(personName)) {
                // Если да, добавляем его родителей в список родителей
                parents.add(member.getSpouse());
                parents.add(member);
            }
        }

        return parents;
    }

    public static void main(String[] args) {
        // Создаем генеалогическое древо и добавляем членов семьи
        FamilyTree familyTree = new FamilyTree();
        Human father = new Human("Иван Петров", Gender.MALE, "01.01.1960", "");
        Human mother = new Human("Мария Петрова", Gender.FEMALE, "01.01.1965", "");
        Human child1 = new Human("Анна Петрова", Gender.FEMALE, "01.01.1990", "");
        Human child2 = new Human("Павел Петров", Gender.MALE, "01.01.1995", "");
        father.setSpouse(mother);
        mother.setSpouse(father);
        father.addChild(child1);
        father.addChild(child2);
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        // Создаем объект RelationshipSearch и выполняем поиск детей и родителей
        RelationshipSearch relationshipSearch = new RelationshipSearch(familyTree);
        List<Human> children = relationshipSearch.findChildren("Иван Петров");
        List<Human> parents = relationshipSearch.findParents("Анна Петрова");

        // Выводим результаты поиска
        System.out.println("Дети Ивана Петрова:");
        for (Human child : children) {
            System.out.println(child.getName());
        }

        System.out.println("Родители Анны Петровой:");
        for (Human parent : parents) {
            System.out.println(parent.getName());
        }
    }
}
