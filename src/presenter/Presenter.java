package presenter;

import model.Creatures.*;
import service.Service;
import view.View;


public class Presenter {
    private View view;
    private Service service;


    /**
     * Конструктор класса
     * принимает view
     * создает новый Service
     */
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    /**
     * Принимает String путь к файлу
     * Вызывает loadFamilyTree у service
     * печатает через view загруженное дерево
     */
    public void loadingTree(String filePatch) {
        service.loadFamilyTree(filePatch);
        view.printAnswer("Заружено дерево\n" + service.shortPrintTree());
    }

    /**
     * Принимает String путь к файлу
     * Вызывает saveFamilyTree у service
     * печатает через view путь и сохраненное дерево
     */
    public void savingTree(String filePatch) {
        service.saveFamilyTree(filePatch);
        view.printAnswer("Сохраненно дерево\n в " + filePatch + "\n" + service.shortPrintTree());
    }

    /**
     * Принимает параметры
     * вызывает метод addHuman в Service
     * @param name   String
     * @param gender Gender
     * @param dob    String - отформатированный для преобразования в дату гггг-мм-дд
     * @param dod    String - отформатированный для преобразования в дату гггг-мм-дд либо null
     */
    public void addHuman(String name, Gender gender, String dob, String dod) {
        service.addHuman(name, gender, dob, dod);
        view.printAnswer(service.getLasthuman().toString());
    }

    /**
     * Принимает имя String
     * вызывает метод поиска по части имени
     * Возвращает true при успешном поиске или false если результат поиска null
     * печатает через view найденного Human
     */
    public boolean findHuman(String name) {
        boolean result;
        result = service.findHuman(name);
        if (result) {
            view.printAnswer(service.getLasthuman().toString());
            return true;
        }
        return false;
//
    }

    /**
     * Вызывает метод shortPrintTree у Service и возвращает строку.
     *
     */
    public String shortPrintTree() {
        return service.shortPrintTree();
    }

    /**
     * Вызывает метод longPrintTree в service
     */
    public String longPrintTree() {
        return service.longPrintTree();
    }

    /**
     * Вызывает метод getSize у service и возвращает int
     *
     */
    public int getSizeTree() {
        return service.getSizeTree();
    }

    /**
     * Принимает два int и вызывает с ними методт setParents у service печатает
     * Печатает service.Lasthuman через view
     */
    public void setParents(int indexMother, int indexFather) {
        service.setParents(indexMother, indexFather);
        view.printAnswer(service.getLasthuman().toString());
    }

    /**
     * Вызывает метод getAge у service и печатает его через view
     */
    public void getAge() {
        view.printAnswer(Integer.toString(service.getAge()));
    }

    /**
     * Вызывает метод getParents у service, печатает его через view
     */
    public void printParents() {
        view.printAnswer(service.getParents());
    }

    /**
     * Вызывает метод getChildren у service, печатает его через view
     */
    public void getChildren() {
        view.printAnswer(service.getChildren());
    }

    /**
     * Вызывает метод getGrandparents у service, печатает его через view
     */
    public void getGrandparents() {
        view.printAnswer(service.getGrandparents());
    }

    /**
     * Вызывает метод getGrandsons у service, печатает его через view
     */
    public void getGrandsons() {
        view.printAnswer(service.getGrandsons());
    }

    /**
     * Вызывает метод sortByName у service
     */
    public void sortName() {
        service.sortByName();
    }

    /**
     * Вызывает метод sortByAge у service
     */
    public void sortByAge() {
        service.sortAge();
    }

    /**
     * Вызывает метод sortNumberChildren у service
     */
    public void sortNumberChildren() {
        service.sortNumberChildren();
    }

}
