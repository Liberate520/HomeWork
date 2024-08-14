package family_tree.services;

import family_tree.help_classes.FamilyTreeItem;
import family_tree.help_classes.Gender;
import family_tree.program_classes.FamilyTree;
import family_tree.program_classes.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class RandomTreeService {
    private FamilyTree my_family;

    public RandomTreeService() {
        this.my_family = new FamilyTree();
    }

    public FamilyTree CreateRandomTree() {
        FillTreeRandomHumans();
        //CreateRandomRelationships();
        //SetRandomDeath();
        return my_family;
    }

    private void FillTreeRandomHumans() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            String id = "doc" + i;
            String name = "Имя " + rand.nextInt(1000);
            Gender gender = Gender.values()[rand.nextInt(Gender.values().length)];
            LocalDate birth = LocalDate.of(rand.nextInt(1024,2024),rand.nextInt(1, 12),rand.nextInt(1, 28));
            Human human = new Human(id,name,gender,birth);
            my_family.add(human);
        }

    }
/*
    private void CreateRandomRelationships() {
        int index = 0;
        for (Object human : my_family) {
            if (index % 2 == 0) {
                human.setParents(FindRandomMother(human));
            }
            if (index % 3 == 0) {
                human.setParents(FindRandomFather(human));
            }
            index++;
        }
    }

    private void SetRandomDeath() {
        Random rand = new Random();
        int index = 0;
        for (Object item : my_family) {
            if (index % 5 == 0) {
                LocalDate death = item. getBirthDate().plusYears(rand.nextInt(100));
                item.setDeathDate(death);
            }
            index ++;
        }
    }

    private Human FindRandomMother(Object human) {
        Random rand = new Random();
        ArrayList<Human> possibleM = new ArrayList<>();
        for (Human h : my_family) {
            if (h.getGender() == Gender.Female && !human.equals(h)) {
                possibleM.add(h);
            }
        }
        int ramdom_indexM = rand.nextInt(possibleM.size());
        return possibleM.get(ramdom_indexM);
    }

    private Human FindRandomFather(Object human) {
        Random rand = new Random();
        ArrayList<Human> possibleF = new ArrayList<>();
        for (Human h : my_family) {
            if (h.getGender() == Gender.Male && !human.equals(h)) {
                possibleF.add(h);
            }
        }
        int ramdom_indexM = rand.nextInt(possibleF.size());
        return possibleF.get(ramdom_indexM);
    }*/
}
