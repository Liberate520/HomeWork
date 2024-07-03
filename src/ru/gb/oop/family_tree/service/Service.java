package ru.gb.oop.family_tree.service;

import ru.gb.oop.family_tree.FamilyTree;
import ru.gb.oop.family_tree.human.Human;
import ru.gb.oop.family_tree.human.HumanBuilder;
import ru.gb.oop.family_tree.human.Sex;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Service {
    private FamilyTree tree;
    private HumanBuilder humanBuilder;

    public Service() {
        humanBuilder  = new HumanBuilder();
        tree = getTestedTree();
    }
    public void run() {
        showFinding();
        showGetAncestors();
        showFindSiblings();
        System.out.println(tree);
    }

    private void showFinding() {
        System.out.println("Демонстраций поиска: ищем Vika\n" + tree.findHumanByName("Vika"));
    }

    private void showGetAncestors() {
        System.out.println("Демонстрация работы поиска всех предков Petr");
        for (Map.Entry<Human, Integer> entry : tree.getAllGenerationsBefore("Petr")) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
    }

    private void showFindSiblings() {
        System.out.println("Демонстрация работы поиска братьев и сестёр у Petr");
        for (Human human : tree.getSistersAndBrothers("Petr")) {
            System.out.println(human.getName());
        }
    }

    private FamilyTree getTestedTree() {
        FamilyTree familyTree = new FamilyTree();
        Human ivan = humanBuilder.newHuman("Ivan", Sex.Male, new Date(2002, 1, 1));
        Human olga = humanBuilder.newHuman("Olga", Sex.Female, new Date(2000, 1, 1));
        Human roman = humanBuilder.newHuman("Roman", Sex.Male, new Date(2000, 1, 1));
        Human petr = humanBuilder.newHuman("Petr", Sex.Male, new Date(2000, 1, 1));
        Human vika = humanBuilder.newHuman("Vika", Sex.Female, new Date(2000, 1, 1));
        Human misha = humanBuilder.newHuman("Misha", Sex.Male, new Date(2000, 1, 1));

        roman.setParents(List.of(ivan, olga));
        petr.setParents(List.of(ivan, olga));
        olga.setParents(List.of(misha, vika));

        familyTree.addHuman(roman);
        familyTree.addHuman(ivan);
        familyTree.addHuman(olga);
        familyTree.addHuman(petr);
        familyTree.addHuman(misha);
        familyTree.addHuman(vika);

        return familyTree;
    }

    public FamilyTree getTree() {
        return tree;
    }

    public void setTree(FamilyTree tree) {
        this.tree = tree;
    }
}
