package Family_tree.Model;

import java.time.LocalDate;

import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;

public class HumanModel extends ElementManager<Human> {

    @Override
    Human newSubject(String name, Gender gender, LocalDate bd) {
        return new Human(name, gender, bd);
    }

    public Human getActiveHuman(){
        int id = super.getActiveSubjectIndex();
        return super.getActiveTree().getItem(id);
    }

    public boolean addToActiveTree(String name, String gender, String bd){
        boolean boo = super.newSubject(name, gender, bd);
        if (boo){
            Family_tree<Human> tree = super.getActiveTree();
            tree.add(this.getActiveHuman());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeSubject() {
        try{
            Human human = this.getActiveHuman();
            Family_tree<Human> tree = super.getActiveTree();
            tree.remove(human);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

   

    

    
}
