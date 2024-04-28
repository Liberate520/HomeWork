package family_TREE.model;

import family_TREE.model.family_tree.FamilyTree;
import family_TREE.model.human.Gender;
import family_TREE.model.human.Human;
import java.time.LocalDate;
import family_TREE.model.save.*;

public class FamilyTreeService {
    private Writable writable;
    private FamilyTree<Human> activeTree;

    public FamilyTreeService(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public FamilyTreeService(){
        activeTree = new FamilyTree<>();
    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(activeTree);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        activeTree = writable.read();
        return true;
    }

    public String addHuman(String name, String genderString, String birthDate,
                           long idFather, long idMother){
        Human father = activeTree.getById(idFather);
        Human mother = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.add(human);
        return "Человек успешно добавлен в дерево";
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }


    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByDeathDate(){
        activeTree.sortByDeathDate();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }


}
