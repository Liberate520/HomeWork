package Model.Service;

import Model.Builder.HumanBuilder;
import Model.FamilyTree.FamilyTree;
import Model.Human.Human;
import Model.Human.Gender;
import Model.Writer.Writer;
import Model.Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanService {
    private FamilyTree<Human> familyTree;
    private HumanBuilder builder;

    public HumanService() {
        familyTree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human human = builder.setName(name)
                .setGender(gender)
                .setBirthDate(birthDate)
                .setDeathDate(deathDate)
                .build();
        familyTree.addHuman(human);
    }

    public void addSpouse(int humanID, int spouseID) {
        for (Human human : familyTree) {
            if (human.getId() == humanID){
                for (Human spouse : familyTree) {
                    if (spouse.getId() == spouseID){
                        familyTree.setMarried(human, spouse);
                    }
                }
            }
        }
    }

    public void deleteSpouse(int humanID) {

        for (Human human : familyTree) {
            if (human.getId() == humanID){
                Human spouse = human.getSpouse();
                familyTree.setDivorsed(human, spouse);
            }
        }
    }

    public void addParent(int humanID, int parentID){
        for (Human human : familyTree) {
            if (human.getId() == humanID){
                for (Human parent : familyTree) {
                    if (parent.getId() == parentID){
                        if (parent.getGender() == Gender.Male){
                            human.setFather(parent);
                        }
                        if (parent.getGender() == Gender.Female){
                            human.setMother(parent);
                        }
                        parent.setChildren(human);
                    }
                }
            }
        }
    }

    public void addChild(int humanID, int childID){
        for (Human human : familyTree) {
            if (human.getId() == humanID){
                for (Human child : familyTree) {
                    if (child.getId() == childID){
                        human.setChildren(child);
                        if (human.getGender() == Gender.Male){
                            child.setFather(human);
                        }
                        if (human.getGender() == Gender.Female){
                            child.setMother(human);
                        }
                    }
                }
            }
        }
    }

    public void deleteHuman(int ID) {
        familyTree.deleteHuman(ID);
    }

    public void saveToFile(String filename) throws IOException {
        Writer fileWriter = new FileHandler(familyTree);
        fileWriter.saveToFile(filename, familyTree);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        Writer fileWriter = new FileHandler(familyTree);
        familyTree = fileWriter.readFromFile(filename);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        Iterator<Human> iterator = familyTree.iterator();
        while (iterator.hasNext()){
            Human human = iterator.next();
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        stringBuilder.append("Всего " + familyTree.showFamilyTreeSize() + " элементов.\n");
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.SortByName();
    }

    public void sortByAge(){
        familyTree.SortByAge();
    }

    public void sortByChildrenNum(){
        familyTree.SortByChildrenNum();
    }

    public void sortByBirthdate(){
        familyTree.SortByBirthdate();
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    public FamilyTree<Human> getFamilyTree(){
        return familyTree;
    }
/*
    public void testTree(){
        List<Human> parents = new ArrayList<>();

        Human mother = new Human("Nadezda", Gender.Female, LocalDate.of(1956, 11, 16), null);
        Human father = new Human("Yakov", Gender.Male, LocalDate.of(1950, 9, 11), null);

        familyTree.addHuman(mother);
        familyTree.addHuman(father);
        familyTree.setMarried(mother, father);

        parents.clear();
        parents.add(mother);
        parents.add(father);

        Human son = new Human("Dima", Gender.Male, LocalDate.of(1990, 04, 9), null, parents);
        Human dauther = new Human("Jenia", Gender.Female, LocalDate.of(1992, 9, 27), null, parents);

        familyTree.addHuman(son);
        familyTree.addHuman(dauther);

        Human grandmother = new Human("Nina", Gender.Female, LocalDate.of(1942, 8, 12), null);
        Human grandfather = new Human("Egor", Gender.Male, LocalDate.of(1937, 7, 14), LocalDate.of(1994, 5, 13));

        familyTree.addHuman(grandmother);
        familyTree.addHuman(grandfather);
        familyTree.setMarried(grandmother, grandfather);

        grandmother.setChildren(mother);
        grandfather.setChildren(mother);
        mother.setParents(grandmother, grandfather);

        //parents.clear();
        parents = new ArrayList<>();
        parents.add(null);
        parents.add(son);

        Human grandson = new Human("Ilia", Gender.Male, LocalDate.of(2017, 7, 4), null, parents);
        familyTree.addHuman(grandson);
    }
*/
}
