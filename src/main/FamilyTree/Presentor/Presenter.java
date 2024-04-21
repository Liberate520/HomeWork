package FamilyTree.Presentor;


import FamilyTree.Model.FileHandler;
import FamilyTree.Model.Human;
import FamilyTree.Model.ItemTree.Gender;
import FamilyTree.Model.ItemTree.Person;
import FamilyTree.Model.Service.Service;
import FamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler());
    }

    public void beginTree(String fName, String lName, Gender gender, LocalDate dataB) {

        service.beginTree(Human.create(fName, lName, gender, dataB));
        getTree();
    }

    /**
     * метод для установления связи родитель-ребенок между уже существующими в дереве персонами
     *
     * @param innParent
     * @param innChildren
     */
    public void establishPaternity(int innParent, int innChildren) {
        service.establishPaternity(innParent, innChildren);
        getTree();
    }

    /**
     * Метод для добавления нового персона-родителя
     *
     * @param fName
     * @param lName
     * @param gender
     * @param dataB
     * @param innChildren
     */
    public void establishPaternity(String fName, String lName, Gender gender, LocalDate dataB, int innChildren) {
        service.establishPaternity(fName, lName, gender, dataB, innChildren);
        getTree();
    }

    /**
     * Метод для добавления нового персона - ребенка в дерево
     *
     * @param innParent
     * @param fName
     * @param lName
     * @param gender
     * @param dataB
     */
    public void establishPaternity(int innParent, String fName, String lName, Gender gender, LocalDate dataB) {
        service.establishPaternity(innParent, fName, lName, gender, dataB);
        getTree();
    }


    public void establishMarriage(int firstPartner, int secondPartner) {
        service.establishMarriage(firstPartner, secondPartner);
        getTree();
    }

    public void establishMarriage(int innPartner, String fName, String lName, Gender gender, LocalDate dataB) {
        service.establishPaternity(innPartner, fName, lName, gender, dataB);
        getTree();
    }


    public void getTree() {
        List<String> tree = service.getListInfo();
        StringBuilder response = new StringBuilder("Список родственников:\n");

        for (String item : tree) {
            response.append(item);
            response.append("\n");
        }
        view.printResponse(response.toString());
    }


    public void sortByName() {
        service.sortByName();
        getTree();
    }

    public void sortByAge() {
        service.sortByAge();
        getTree();
    }

    public void readToFile(String namefile) throws IOException {
        service.readToFile(namefile); //сохранить в файл
        getTree();
    }

    public void saveToFile(String namefile) throws IOException {
        service.saveToFile(namefile); // извлечь из файла
    }


}
