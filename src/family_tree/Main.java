package family_tree;

import family_tree.handler.FileHandler;
import family_tree.handler.Writable;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//      Human humanIvan=new Human("Ivan", LocalDate.of(1982,11,14),Gender.MALE);
//        Human humanElena=new Human("Elena", LocalDate.of(1979,10,10),Gender.FEMALE);
//      Human humanEvgeniya=new Human("Евгения",LocalDate.of(2010,12,13),Gender.FEMALE);
//        Human humanValeriya=new Human("Валерия",LocalDate.of(2013,12,23),Gender.FEMALE);
//        Human humanEvgen=new Human("Евгений",LocalDate.of(1959,12,13),Gender.MALE);
//        Human humanValentina=new Human("Валентина",LocalDate.of(1955,6,11),Gender.FEMALE);
//
//
//        humanIvan.addChild(humanEvgeniya);
//        humanIvan.addChild(humanValeriya);
//        humanIvan.addMother(humanValentina);
//        humanIvan.addFather(humanEvgen);
//        humanIvan.addSpouse(humanElena);
//
//        humanElena.addSpouse(humanIvan);
//        humanElena.addChild(humanEvgeniya);
//        humanElena.addChild(humanValeriya);
//
//      humanEvgen.addSpouse(humanValentina);
//      humanEvgen.addChild(humanIvan);
//
//      humanValentina.addSpouse(humanEvgen);
//      humanValentina.addChild(humanIvan);
//
//      System.out.println(humanIvan);
//      System.out.println(humanIvan.getAge(humanIvan));
//      System.out.println(humanElena.getAge(humanElena));
//
//      FamilyTree familyTree=new FamilyTree();
//      familyTree.addHuman(humanElena);
//      familyTree.addHuman(humanEvgen);
//      familyTree.addHuman(humanIvan);
//      familyTree.addHuman(humanEvgeniya);
//      familyTree.addHuman(humanValentina);
//      familyTree.addHuman(humanValeriya);
//
//      System.out.println(familyTree.getById(4));
//      System.out.println(familyTree.getSiblings(4));
//
      Writable writable=new FileHandler();
//      writable.writeClass(familyTree);
      FamilyTree familyTree=writable.readClass();
      System.out.println(familyTree.getById(4));
      System.out.println(familyTree.getSiblings(4));
    }
}