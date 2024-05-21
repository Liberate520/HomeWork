import java.io.*;
import java.util.*;

/**
 * Класс для представления генеалогического древа.
 * Управляет членами древа, их отношениями и предоставляет методы для работы с данными.
 */
public class FamilyTree {
    private List<Human> members;
    private RelationshipSearch relationshipSearch;

    public FamilyTree() {
        members = new ArrayList<>();
        relationshipSearch = new RelationshipSearch();
    }

    /**
     * Добавляет нового члена в генеалогическое древо.
     *
     * @param person новый член древа
     */
    public void addMember(Human person) {
        members.add(person);
    }

    /**
     * Устанавливает брачные отношения между двумя членами древа.
     *
     * @param person1 первый член пары
     * @param person2 второй член пары
     */
    public void setSpouse(Human person1, Human person2) {
        person1.setSpouse(person2);
        person2.setSpouse(person1);
    }

    /**
     * Устанавливает родителей для ребенка в древе.
     *
     * @param child  ребенок
     * @param parent1 первый родитель
     * @param parent2 второй родитель
     */
    public void setParents(Human child, Human parent1, Human parent2) {
        child.setParents(parent1, parent2);
        parent1.addChild(child);
        parent2.addChild(child);
    }

    /**
     * Возвращает список всех детей указанного человека.
     *
     * @param person человек, для которого нужно получить детей
     * @return список детей
     */
    public List<Human> getChildren(Human person) {
        return person.getChildren();
    }

    /**
     * Возвращает супруга указанного человека.
     *
     * @param person человек, для которого нужно найти супруга
     * @return супруг человека
     */
    public Human getSpouse(Human person) {
        return relationshipSearch.getSpouse(person);
    }

    /**
     * Возвращает список родителей указанного человека.
     *
     * @param person человек, для которого нужно найти родителей
     * @return список родителей
     */
    public List<Human> getParents(Human person) {
        return relationshipSearch.getParents(person);
    }

    /**
     * Возвращает список братьев и сестер указанного человека.
     *
     * @param person человек, для которого нужно найти братьев и сестер
     * @return список братьев и сестер
     */
    public List<Human> getSiblings(Human person) {
        return relationshipSearch.getSiblings(person);
    }

    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param filename имя файла для сохранения
     */
    public void saveToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла для загрузки
     * @return загруженное генеалогическое древо
     */
    public static FamilyTree loadFromFile(String filename) {
        FamilyTree familyTree = new FamilyTree();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree.members = (List<Human>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return familyTree;
    }
}