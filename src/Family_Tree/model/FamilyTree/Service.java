package Family_Tree.model.FamilyTree;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Human.Human;
import Family_Tree.view.View;

public class Service {
    private FamilyTree tree;
    private View view;

    public Service(){
        tree = new FamilyTree();}

    public String getInf() {
        return tree.getInfo();
}

    public void sortByAge(){
        tree.sortByAge();
        getInf();
    }
    public void sortByName(){
        tree.sortByName();
        getInf();
    }

    public void addHuman(String name, Integer age, Gender gender){
        Human human = new Human(name, age, gender);
        tree.add(human);
    }


//    public void addParents(String name, Integer age, Gender gender){
//        Human human = new Human(name, age, gender);
//
//    }

}

