package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.family_tree.TreeNoda;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        String filePath = "scr/family_tree/writer/tree.txt";

        FamilyTree tree = read(filePath);

//        FamilyTree tree = testTree();
        System.out.println(tree);

        save(tree, filePath);
    }

    static FamilyTree read(String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    static void  save(FamilyTree familyTree, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save((Serializable) familyTree, filePath);
    }

    static <E> FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human ivan = new Human ("Ivan", Gender.Male, LocalDate.of(2000, 3, 3));
        Human iana = new Human ("Iana", Gender.Female, LocalDate.of(2000, 8,9));
        Human child1 = new Human ("Elena", Gender.Female, LocalDate.of(2022,3,7));
        Human child2 = new Human ("Igor", Gender.Male, LocalDate.of(2024, 5,4));
        tree.add((TreeNoda<E>) ivan);
        tree.add((TreeNoda<E>) iana);
        tree.add((TreeNoda<E>) child1);
        tree.add((TreeNoda<E>) child2);

        return tree;
    }
}
