package family_tree.family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;

public class FamilyTree {
    private  int humansId;
    private List<Human> humanList;



    public FamilyTree(List<Human> humanList){ this.humanList =humanList;}

    public FamilyTree(){this(new ArrayList<>());}

    public boolean add(Human human){
        if (human == null) {
             return false;
        }
        if (!humanList.contains(human)){

        }
    }

    Human human1 = new Human("Андрей", Gender.Male, LocalDate.of(1974,4,17));


}
