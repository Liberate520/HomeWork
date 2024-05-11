package Family_Tree.presenter;

import Family_Tree.model.FamilyTree.FamilyTree;
import Family_Tree.model.FamilyTree.TreeVersatility;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Human.Human;
import Family_Tree.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Presenter<E extends TreeVersatility<E>> implements Iterable<E>, Serializable {
    private final View view;
    private final FamilyTree familytree;
    private Scanner scanner;
    private List<Human> HumanList;
    private long countPeople;



    public Presenter(View view) {
        this.view = view;
        familytree = new FamilyTree();
    }

    public void getInf() {
        String answer = familytree.getInfo();
        view.PrintAnswer(answer);
    }

    public void sortByAge(){
        familytree.sortByAge();
        getInf();
    }
    public void sortByName(){
        familytree.sortByName();
        getInf();
    }
    public void FamilyTree() {
        HumanList = new ArrayList<>();
    }

public void addHuman(String name, Integer age, Gender gender){
    Human human = new Human(name, age, gender);
    familytree.add(human);
}

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
