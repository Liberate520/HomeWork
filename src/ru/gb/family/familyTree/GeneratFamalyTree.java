package ru.gb.family.familyTree;


import ru.gb.family.humans.GeneratHuman;
import ru.gb.family.humans.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeneratFamalyTree {
    public GeneratFamalyTree() {
        List<Human> newHuman = new ArrayList<>();
    }

    public FamilyTree gen() {
        FamilyTree familyTree = new FamilyTree();
        GeneratHuman genHum = new GeneratHuman();
        for (Human newHum: genHum.GeneratHuman()) {
            familyTree.addHumanInTree(newHum);
        }
        return familyTree;
    }
}