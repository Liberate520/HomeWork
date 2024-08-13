package module.lesson2.service;

import module.lesson2.familytree.FamilyTree;
import module.lesson2.human.FamilyStatus;
import module.lesson2.human.Gender;
import module.lesson2.human.Human;
import module.lesson2.writer.WriteReadHuman;

import java.time.LocalDate;

public class Service {
    private final FamilyTree<Human> familyTree;
    private final WriteReadHuman<Human> writeReadHuman;
    private Human human;

    public Service(FamilyTree<Human> f, WriteReadHuman<Human> w) {
        familyTree = f;
        writeReadHuman = w;
    }

    public void createObject(int serialNumber, String someName, LocalDate birth, LocalDate death, Gender gender, FamilyStatus familyStatus){
        human = familyTree.createHuman(serialNumber, someName, birth, death, gender, familyStatus);
        System.out.println(human);
    }

    public void allAboutMan(){
        System.out.println(human);
    }


    public void printPeopleList(){
        familyTree.printPeopleList();
    }

    public void addHuman(){
        familyTree.addPeople(human);
        System.out.println("Успешно добавлен!!!");
        System.out.println(familyTree.getPeopleList());
    }

    public void sortByAge(){
        familyTree.sortByAge(familyTree.getPeopleList());
        System.out.println(familyTree.getPeopleList());
    }

    public void sortByName(){
        familyTree.sortByName(familyTree.getPeopleList());
        System.out.println(familyTree.getPeopleList());
    }

    public void writeHuman(){
        writeReadHuman.writeHuman(human);
    }

    public void readHuman(){
        System.out.println(writeReadHuman.readHuman().getInfo());
    }
}
