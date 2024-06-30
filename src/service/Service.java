package service;

import model.Creatures.Gender;
import model.Creatures.Human;
import model.family_tree.FamilyTree;
import model.save.FileHandler;
import model.save.Writable;

public class Service {
    private FamilyTree<Human> familyTree;
    private Human lasthuman;

    /**
     * Конструктор
     */
    public Service() {
        familyTree = new FamilyTree<>();
    }
    /**
     * Загружает дерево из файла по указанному пути
     * @param filePatch путь к файлу
     */
    public void loadFamilyTree(String filePatch) {
        Writable writable = new FileHandler();
        this.familyTree = (FamilyTree<Human>) writable.load(filePatch);
    }

    /**
     * Сохраняет дерево в файл по указанному пути
     * @param filePatch путь к файлу
     */
    public void saveFamilyTree(String filePatch) {
        Writable writable = new FileHandler();
        writable.save(this.familyTree, filePatch);
    }
    /**
     * Принимает параметры
     * @param name   String
     * @param gender Gender
     * @param dob    String - отформатированный для преобразования в дату гггг-мм-дд
     * @param dod    String - отформатированный для преобразования в дату гггг-мм-дд либо null
     * Вызывает конструктор Human с параметрами присваивает в lasthuman
     * lasthuman добавляет familyTree
     *
     */
    public void addHuman(String name, Gender gender, String dob, String dod) {
        lasthuman = new Human(name, gender, dob, dod);
        familyTree.addCreature(lasthuman);
    }

    /**
     * Принимает имя String
     * вызывает метод поиска по части имени
     * Возвращает true при успешном поиске или false если результат поиска null
     * Присваивает результат поиска lasthuman
     *
     */
    public boolean findHuman(String name) {
        lasthuman = familyTree.findFirsIn(name);
        return lasthuman != null;
    }

    /**
     * Принимает два int и по ним в массиве вызывает двух людей и устанавливает их родителями у lasthuman
     *
     */
    public void setParents(int indexMother, int indexFather) {
        lasthuman.setParents(familyTree.getFamilyList().get(indexMother), familyTree.getFamilyList().get(indexFather));
    }

    /**
     * Вызывает метод toString у familyTree
     */
    public String shortPrintTree() {
        return familyTree.toString();
    }

    /**
     * Вызывает метод getAge у lasthuman
     */
    public Integer getAge() {
        return lasthuman.getAge();
    }

    /**
     * Вызывает метод getParents у lasthuman результат преобразует в строку
     */
    public String getParents() {
        return lasthuman.getParents().toString();
    }

    /**
     * Вызывает метод getChildren у lasthuman результат преобразует в строку
     */
    public String getChildren() {
        return lasthuman.getChildren().toString();
    }

    /**
     * Вызывает метод getGrandparents у lasthuman результат преобразует в строку
     */
    public String getGrandparents() {
        return lasthuman.getGrandparents().toString();
    }

    /**
     * Вызывает метод getGrandsons у lasthuman результат преобразует в строку
     */
    public String getGrandsons() {
        return lasthuman.getGrandsons().toString();
    }

    /**
     * Вызывает метод sortByName у familyTree
     */
    public void sortByName() {
        familyTree.sortByName();
    }

    /**
     * Вызывает метод sortByAge у familyTree
     */
    public void sortAge() {
        familyTree.sortByAge();
    }

    /**
     * Вызывает метод sortNumberChildren у familyTree
     */
    public void sortNumberChildren() {
        familyTree.sortByNumberChildren();
    }

    /**
     * Вызывает метод findFirsAll с пустой строкой, в результате получает всех людей в дереве ввиде ArrayList
     * Вызывает метод toString к массиву и возвращает строку
     *
     */
    public String longPrintTree() {
        return familyTree.findFirsAll("").toString();
    }

    public Human getLasthuman() {
        return lasthuman;
    }

    /**
     * Возвращает количество людей в дереве
     */
    public int getSizeTree() {
        return familyTree.getSize();
    }
}
