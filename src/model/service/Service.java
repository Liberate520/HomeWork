package model.service;

import model.FamilyTree.FamilyTree;
import model.human.Human;
import model.human.TreeNode;
import model.writer.FileHandler;

import java.io.Serializable;

public class Service {

    private FamilyTree<Human> tree;
    final static String filePath = "src/model/writer/tree.txt";

    public <E extends TreeNode<E>> Service(){
        FamilyTree<E> tree = new FamilyTree<E>();
        tree = new FamilyTree<>();
    }


    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler(filePath);

        return (FamilyTree) fileHandler.read();


    }

    private void save(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler(filePath);

        Serializable familyTree;
        fileHandler.save(tree);

    }

    public boolean addHuman() {

        Human human = new Human(null, null, null, null, null, null, null);

       tree.addHuman(human);
       return true;
//       FamilyTree tree = new FamilyTree();
//
//        Human grisha = new Human("Гриша", Gender.Male, LocalDate.of(1952, 12, 12), null, null, null, null);
//        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1951, 1, 2), null, null, null, null);
//
//        tree.add(grisha);
//        tree.add(masha);
//        Human gena = new Human("Геннадий",Gender.Male, LocalDate.of(1971, 4, 29),null,null, masha, grisha);
//        tree.add(gena);
//        Human sveta = new Human("Светлана", Gender.Female, LocalDate.of(1976, 2, 17), null, null, masha, grisha);
//        tree.add(sveta);
//
//        return tree;

    }


    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи\n");
       for (Human human: tree){
           stringBuilder.append(human);
           stringBuilder.append("\n");
       }
       return stringBuilder.toString();
    }

    public void sortByAge() {
       tree.sortByAge();
    }

    public void sortByName() {
        tree.sortByName();
    }
}



