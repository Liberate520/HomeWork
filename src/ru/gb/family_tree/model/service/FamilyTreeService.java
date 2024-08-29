package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class FamilyTreeService<T extends FamilyTreeItem<T>> {
    private int Id;
    private FamilyTree<T> familyTree;
    FileHandler<T> fileHandler;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
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

    public String getChildrenInfo(int id) {
        return familyTree.getChildrenInfo(id);
    }

    //public String addItem(String name, Gender gender, LocalDate birthDay) {
    public String addItem(T item) {
        //T human = new Human(name, gender, birthDay);
        item.setId(++Id);
        familyTree.addItem(item);
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

    public String remove(int id) {
        familyTree.remove(id);
        Id--;
        return familyTree.getTreeInfo();
    }

    public void saveTree() {
        fileHandler.saveToFile(familyTree,"FamilyTree.txt");
        //System.out.println("Семейное древо сохранено в файл.");
    }

    public void restoreTree() {
        familyTree = fileHandler.restoreFromFileFT("FamilyTree.txt");
        //System.out.println("Семейное древо востановленно из файла.");
    }

    /*
    public void createFamilyTree() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human());
        //Human hum1 = new Human();
        //humans.getLast().setId(1);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Михaил Федopoвич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1596-07-12"));
        humans.getLast().setDeathDate(LocalDate.parse("1645-07-13"));
        humans.getLast().setGender(Gender.MALE);
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum2 = new Human();
        //humans.getLast().setId(2);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Алекcей Михaйлoвич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1629-03-09"));
        humans.getLast().setDeathDate(LocalDate.parse("1676-01-29"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.getFirst());
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum2 = new Human();
        //humans.getLast().setId(3);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Татьяна Михайловна Рoмaнoва");
        humans.getLast().setBirthDay(LocalDate.parse("1636-01-15"));
        humans.getLast().setDeathDate(LocalDate.parse("1706-09-04"));
        humans.getLast().setGender(Gender.FEMALE);
        humans.getLast().setFather(humans.getFirst());
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum3 = new Human();
        //humans.getLast().setId(4);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Федop III Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1661-05-30"));
        humans.getLast().setDeathDate(LocalDate.parse("1682-04-27"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum4 = new Human();
        //humans.getLast().setId(5);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Ивaн V Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1666-08-27"));
        humans.getLast().setDeathDate(LocalDate.parse("1696-01-29"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum5 = new Human();
        //humans.getLast().setId(6);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Петp I Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1672-05-30"));
        humans.getLast().setDeathDate(LocalDate.parse("1725-01-28"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        familyTree.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum6 = new Human();
        //humans.getLast().setId(7);
        humans.getLast().setId(++Id);
        humans.getLast().setName("Елизaветa Петpoвнa Рoмaнoвa");
        humans.getLast().setBirthDay(LocalDate.parse("1709-12-18"));
        humans.getLast().setDeathDate(LocalDate.parse("1761-12-25"));
        humans.getLast().setGender(Gender.FEMALE);
        humans.getLast().setFather(humans.get(4));
        familyTree.addItem(humans.getLast());

        humans.add(new Human.HumanBuilder("Евдокия Лукъяновна Стрешнева",
                Gender.FEMALE, LocalDate.parse("1626-02-15"), null, null)
                .setHumanDeathDate(LocalDate.parse("1645-07-23"))
                .setHumanId(++Id)
                .build());
        familyTree.addItem(humans.getLast());

        humans.add(new Human.HumanBuilder("Василий Михайлович Рoмaнoв",
                Gender.MALE, LocalDate.parse("1639-03-24"), humans.getFirst(), humans.get(7))
                .setHumanDeathDate(LocalDate.parse("1639-04-04"))
                .setHumanId(++Id)
                .build());
        familyTree.addItem(humans.getLast());
    }

     */
}
