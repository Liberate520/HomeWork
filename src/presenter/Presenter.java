package presenter;

import model.Creatures.*;
import model.family_tree.FamilyTree;
import model.save.FileHandler;
import view.View;

import java.util.ArrayList;

public class Presenter {
    private View view;
    private FamilyTree familyTree;
    private Creature lasthuman;

    /**
     * Конструктор класса
     * принимает view
     * создает новое дерево
     * @param view
     */
    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<Human>(new ArrayList<>());
    }

    /**
     * Принимает String путь к файлу
     * Загружает из файла дерево
     * печатает через view загруженное дерево
     * @param filePatch
     */
    public void loadingTree(String filePatch) {
        familyTree = (FamilyTree) new FileHandler().load(filePatch);
        view.printAnswer("Заружено дерево\n" + familyTree);
    }

    /**
     * Принимает String путь к файлу
     * Сохраняет в файл дерево
     * печатает через view путь и сохраненное дерево
     * @param filePatch
     */
    public void savingTree(String filePatch) {
        new FileHandler().save(familyTree, filePatch);
        view.printAnswer("Сохраненно дерево\n в" + filePatch + "\n" + familyTree);
    }

    /**
     * Принимает параметры
     * создает нового человека и добавляет его в дерево
     * @param name String
     * @param gender Gender
     * @param dob String - отформатированный для преобразования в дату гггг-мм-дд
     * @param dod String - отформатированный для преобразования в дату гггг-мм-дд либо null
     */
    public void addHuman(String name, Gender gender, String dob, String dod) {
        lasthuman = new Human(name,gender,dob,dod);
        familyTree.addCreature(lasthuman);
        view.printAnswer(lasthuman.toString());
    }

    /**
     * Принимает имя String
     * вызывает метод поиска по части имени
     * результат поиска присваивается переменой lasthuman типа Human
     * Возвращает true при успешном поиске или false если результат поиска null
     * @param name
     * @return
     */
    public boolean findHuman(String name) {
        lasthuman = familyTree.findFirsIn(name);
        if (lasthuman != null) {
            view.printAnswer(lasthuman.toString());
            return true;
        } else {
            return  false;
        }
    }

    /**
     * Вызывает метод toString у дерева и возвращает строку.
     * @return String
     */
    public String shortPrintTree() {
        return familyTree.toString();
    }

    /**
     * Вызывает метод findFirsAll  с пустой строкой, в результате получает всех людей в дереве ввиде ArrayList
     * Вызывает метод toString к масиву и возвращает строку
     * @return
     */
    public String longPrintTree() {
        return familyTree.findFirsAll("").toString();
    }

    /**
     * Вызывает метод getSize у дерева и возвращает его размер int
     * @return int
     */
    public int getSizeTree() {
        return  familyTree.getSize();
    }

    /**
     * Принимает два int и по ним в масиве вызывает двух людей и устанавливает их родителями у lasthuman
     * Печатает lasthuman через view
     * @param indexMother
     * @param indexFather
     */
    public void setParents(int indexMother, int indexFather) {
        lasthuman.setParents(familyTree.getFamilyList().get(indexMother), familyTree.getFamilyList().get(indexFather));
        view.printAnswer(lasthuman.toString());
    }

    /**
     *Вызывает метод getAge у lasthuman и печатает его через view
     */
    public void getAge() {
        view.printAnswer(Integer.toString(lasthuman.getAge()));
    }

    /**
     * Вызывает метод getParents у lasthuman, у результата вызывается метод toString и печатает его через view
     */
    public void getParents() {
        view.printAnswer(lasthuman.getParents().toString());
    }

    /**
     * Вызывает метод getChildren у lasthuman, у результата вызывается метод toString и печатает его через view
     */
    public void getChildren() {
        view.printAnswer(lasthuman.getChildren().toString());
    }

    /**
     * Вызывает метод getGrandparents у lasthuman, у результата вызывается метод toString и печатает его через view
     */
    public void getGrandparents() {
        view.printAnswer(lasthuman.getGrandparents().toString());
    }

    /**
     * Вызывает метод getGrandsons у lasthuman, у результата вызывается метод toString и печатает его через view
     */
    public void getGrandsons() {
        view.printAnswer(lasthuman.getGrandsons().toString());
    }

    /**
     * Вызывает метод sortByName у familyTree
     */
    public void sortName() {
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

}
