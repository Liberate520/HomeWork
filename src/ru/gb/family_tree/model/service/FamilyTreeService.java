package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeService {
    private int humansId;
    private List<Human> humans;
    private FamilyTree<Human> familyTree;
    FileHandler<Human> fileHandler;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.humans = new ArrayList<>();
        fileHandler = new FileHandler<>();
    }

    public String getTreeInfo() {
        return familyTree.getTreeInfo();
    }

    public String sortById() {
        familyTree.sortById();
        return familyTree.getTreeInfo();
    }

    public String sortByName() {
        familyTree.sortByName();
        return familyTree.getTreeInfo();
    }

    public String sortByAge() {
        familyTree.sortByAge();
        return familyTree.getTreeInfo();
    }

    public String sortByBirthDay() {
        familyTree.sortByBirthDay();
        return familyTree.getTreeInfo();
    }

    public String getChildrenInfo(int selectId) {
        return familyTree.getChildrenInfo(selectId);
    }

    public String addHuman(String name, Gender gender, LocalDate birthDay) {
        humans.add(new Human(name, gender, birthDay));
        humans.getLast().setId(++humansId);
        familyTree.addItem(humans.getLast());
        return familyTree.getTreeInfo();
    }

    public String setHumanDeathDay(int id, LocalDate deathDay) {
        familyTree.setDeathDay(id, deathDay);
        return familyTree.getTreeInfo();
    }

    public String setHumanFather(int idChildren, int idFather) {
        familyTree.setFather(idChildren, idFather);
        return familyTree.getTreeInfo();
    }

    public String setHumanMother(int idChildren, int idMother) {
        familyTree.setMother(idChildren, idMother);
        return familyTree.getTreeInfo();
    }

    public String wedding(int idHusband, int idWife) {
        familyTree.setWedding(idHusband, idWife);
        return familyTree.getTreeInfo();
    }

    public String divorce(int idHusband, int idWife) {
        familyTree.setDivorce(idHusband, idWife);
        return familyTree.getTreeInfo();
    }

    /*
    public String remove() {
        familyTree.setDivorce(idHusband, idWife);
        return familyTree.getTreeInfo();
    }

     */

    public void saveTree() {
        fileHandler.saveToFile(humans,"Human.txt");
        fileHandler.saveToFile(familyTree,"FamilyTree.txt");
        //System.out.println("Семейное древо сохранено в файл.");
    }

    public void restoreTree() {
        humans = fileHandler.restoreFromFileH("Human.txt");
        familyTree = fileHandler.restoreFromFileFT("FamilyTree.txt");
        //System.out.println("Семейное древо востановленно из файла.");
    }

    public void createFamilyTree() {
        humans.add(new Human());
        //Human hum1 = new Human();
        //humans.getLast().setId(1);
        humans.getLast().setId(++humansId);
        humans.getLast().setName("Михaил Федopoвич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.of(1596,7,12));
        humans.getLast().setDeathDate(LocalDate.of(1645,7,13));
        humans.getLast().setGender(Gender.MALE);
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum2 = new Human();
        //humans.getLast().setId(2);
        humans.getLast().setId(++humansId);
        humans.getLast().setName("Алекcей Михaйлoвич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.of(1629,3,9));
        humans.getLast().setDeathDate(LocalDate.of(1676,1,29));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.getFirst());
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum3 = new Human();
        //humans.getLast().setId(3);
        humans.getLast().setId(++humansId);
        humans.getLast().setName("Федop III Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.of(1661,5,30));
        humans.getLast().setDeathDate(LocalDate.of(1682,4,27));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum4 = new Human();
        //humans.getLast().setId(4);
        humans.getLast().setId(++humansId);
        humans.getLast().setName("Ивaн V Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.of(1666,8,27));
        humans.getLast().setDeathDate(LocalDate.of(1696,1,29));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum5 = new Human();
        //humans.getLast().setId(5);
        humans.getLast().setId(++humansId);
        humans.getLast().setName("Петp I Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.of(1672,5,30));
        humans.getLast().setDeathDate(LocalDate.of(1725,1,28));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum6 = new Human();
        //humans.getLast().setId(6);
        humans.getLast().setId(++humansId);
        humans.getLast().setName("Елизaветa Петpoвнa Рoмaнoвa");
        humans.getLast().setBirthDay(LocalDate.of(1709,12,18));
        humans.getLast().setDeathDate(LocalDate.of(1761,12,25));
        humans.getLast().setGender(Gender.FEMALE);
        humans.getLast().setFather(humans.get(4));
        familyTree.addItem(humans.getLast());

        humans.add(new Human.HumanBuilder("Евдокия Лукъяновна Стрешнева",
                Gender.FEMALE, LocalDate.of(1626,2,15), null, null)
                .setHumanDeathDate(LocalDate.of(1645,7,23))
                .setHumanId(++humansId)
                .build());
        familyTree.addItem(humans.getLast());

        humans.add(new Human.HumanBuilder("Василий Михайлович Рoмaнoв",
                Gender.MALE, LocalDate.of(1639,3,24), humans.getFirst(), humans.get(6))
                .setHumanDeathDate(LocalDate.of(1639,4,4))
                .setHumanId(++humansId)
                .build());
        familyTree.addItem(humans.getLast());
    }
}
