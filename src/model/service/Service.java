package model.service;

import model.person.Gender;
import model.person.Person;
import model.tree.FamilyTree;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private int idPerson;
    private FamilyTree<Person> tree;
    private Writable writable;

    public Service(Writable writable) {
        tree = new FamilyTree<Person>();
        this.writable=writable;
    }


    // Добавление человека
    public void addPerson( String fullName, Gender gender, LocalDate birthDate, LocalDate deathDate){
        Person person = new Person(idPerson++, fullName, gender,birthDate, deathDate);
        tree.add(person);
    }

    // Добавление родства
    public void addKinship( String parentName, String childName){
        tree.addKinship(parentName,childName);
    }

    //Вывод семейного древа
    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое древо\n");

        for (Person person: tree){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    //Сортировка по имени
    public void sortByName(){
        tree.sortByName();
        System.out.println("Сортировка в алфавитном порядке выполнена.\n"+tree.getInfo());
    }

    //Сортировка по дате рождения
    public void sortByDateOfBirth(){
        tree.sortByDateOfBirth();
        System.out.println("Сортировка по дате рождения выполнена.\n"+tree.getInfo());
    }

    //Сохрание древа в файл
    public void saveTree(){
        writable.saveToFile(tree);
        System.out.println("Древо сохранено");
        System.out.println();
    }

    //Загрузка древа из файла
    public FamilyTree<Person> upLoadTree() {
        return writable.uploadFromFile();
    }

    // Вывод загруженного из файла дерева на консоль
    public void printLoadedTree(){
        System.out.println(upLoadTree());
    }

}
