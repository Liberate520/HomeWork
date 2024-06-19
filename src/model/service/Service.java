package model.service;


import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.tree.FileHandler;
import model.tree.Writable;

import java.io.Serializable;
import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    public Service(FamilyTree familyTree){
        this.familyTree = familyTree;


    }
    public static void save(FamilyTree tree, String fileName) {
        Writable writable = new FileHandler();
        writable.save((Serializable) tree, fileName);

        //System.out.println(model.tree.getAllInfo());
        //save(model.tree, "Gluhov_ft.dat");
    }
    public static FamilyTree read(String fileName) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read((fileName));

        //model.tree.FamilyTree model.tree = (model.tree.FamilyTree) rw.readTree("Gluhov_ft.dat");
    }
    public static FamilyTree createTree(){
        FamilyTree tree = new FamilyTree();
        /*
        model.human.Human polina = new model.human.Human("Полина", "Андроникова", LocalDate.of(1914, 12, 31),LocalDate.of(1972, 5, 15), model.human.Gender.Female);
        model.human.Human anton = new model.human.Human("Антон", "Пиантковский", LocalDate.of(1910, 6, 15),LocalDate.of(1943, 2, 3), model.human.Gender.Male);
        model.human.Human dariya = new model.human.Human("Людмила", "Пиантковская", LocalDate.of(1926, 8, 1), model.human.Gender.Female, polina, anton);

         */
        TreeGenerator tg = new TreeGenerator(tree, 3436);
        tree = tg.treeGenerator();
        //model.tree.add(polina);
        //model.tree.add(anton);
        //model.tree.add(dariya);
        return tree;
    }



    public String getHumanListInfo(){
        return  familyTree.getAllInfo();
    }

    public void addHuman(String name, String lastName, LocalDate dateOfBirth, Gender gender) {

        familyTree.add(new Human(name, lastName, dateOfBirth, gender));
    }

    public void sortByName() {
        familyTree.sortByName();

    }
    public void sortByLastName() {
        familyTree.sortByLastName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }


}
