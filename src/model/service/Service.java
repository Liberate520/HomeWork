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
        Person person = new Person(setPersonId(), fullName, gender,birthDate, deathDate);
        tree.add(person);
    }

    // Добавляем id члена семьи исходя из размера семейного древа
    private int setPersonId() {
        idPerson=tree.treeSize();
        return idPerson;
    }

    // Добавление родства
    public void addKinship( String parentName, String childName){
        tree.addKinship(parentName,childName);
    }

    //Вывод семейного древа
    public String getTreeInfo() {
        return tree.toString();
    }


    //Сортировка по имени
    public void sortByName(){
        tree.sortByName();
    }

    //Сортировка по дате рождения
    public void sortByDateOfBirth(){
        tree.sortByDateOfBirth();
    }

    //Сохрание древа в файл
    public void saveTree(){
        writable.saveToFile(tree);

    }

    //Загрузка древа из файла
    public FamilyTree<Person> upLoadTree() {
        tree=writable.uploadFromFile();
        return tree;
    }

}
