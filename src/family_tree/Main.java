package family_tree;

import family_tree.handler.FileHandler;
import family_tree.handler.Writable;
import family_tree.human.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.servis.Servis;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Servis servis=new Servis();
        servis.addHuman("Иван", LocalDate.of(1982,11,14), Gender.MALE);
        servis.addHuman("Елена", LocalDate.of(1979,10,10),Gender.FEMALE);
        servis.addHuman("Евгения",LocalDate.of(2010,12,13),Gender.FEMALE);
        servis.addHuman("Валерия",LocalDate.of(2013,12,23),Gender.FEMALE);
        servis.addHuman("Евгений",LocalDate.of(1959,12,13),Gender.MALE);
        servis.addHuman("Валентина",LocalDate.of(1955,6,11),Gender.FEMALE);

        servis.addChild(servis.getById(1),servis.getById(3));
        servis.addChild(servis.getById(1),servis.getById(4));
        servis.addMother(servis.getById(1),servis.getById(6));
        servis.addFather(servis.getById(1),servis.getById(5));
        servis.addSpouse(servis.getById(1),servis.getById(2));
        servis.addSpouse(servis.getById(2),servis.getById(1));
        servis.addChild(servis.getById(2),servis.getById(3));
        servis.addChild(servis.getById(2),servis.getById(4));
        servis.addSpouse(servis.getById(5),servis.getById(6));
        servis.addSpouse(servis.getById(6),servis.getById(5));
        servis.addChild(servis.getById(5),servis.getById(1));
        servis.addChild(servis.getById(6),servis.getById(1));
        servis.addMother(servis.getById(3),servis.getById(2));
        servis.addFather(servis.getById(3),servis.getById(1));
        servis.addMother(servis.getById(4),servis.getById(2));
        servis.addFather(servis.getById(4),servis.getById(1));

        System.out.println(servis.getById(1));
        System.out.println(servis.getAge(servis.getById(1)));
        System.out.println(servis.getAge(servis.getById(1)));
        System.out.println(servis.getById(3));
        System.out.println(servis.getSiblings(3));
        System.out.println("/////////////");

        Writable writable=new FileHandler();
        writable.save(servis.getFamilyTree(),"familyTree.out");

//        FamilyTree familyTreeSave= (FamilyTree) writable.read("familyTree.out");
        Object familyTreeSave=writable.read("familyTree.out");
        System.out.println(familyTreeSave);

        servis.printNameFamiliTree();
        System.out.println("//////////");
        servis.sortByName();
        servis.printNameFamiliTree();
        servis.sortByData();
        System.out.println("///////");
        servis.printNameFamiliTree();


    }
}