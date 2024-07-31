package Service;

//import Builder.HumanBuilder;
import FamilyTree.FamilyTree;
import Human.Human;
import Human.Gender;
import Writer.Writer;
import Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanService {
    private FamilyTree familyTree;
    //private HumanBuilder builder;

    public HumanService() {
        familyTree = new FamilyTree();
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

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    public FamilyTree getFamilyTree(){
        return familyTree;
    }

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
    
    public void SortByName(){
        familyTree.SortByName();
    }

    public void SortByAge(){
        familyTree.SortByAge();
    }

    public void SortByChildrenNum(){
        familyTree.SortByChildrenNum();
    }

    public void SortByBirthdate(){
        familyTree.SortByBirthdate();
    }
}
