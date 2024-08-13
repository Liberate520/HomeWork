package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private FamilyTree<Human> familyTree;

    public Service(){
        familyTree = new FamilyTree<Human>();
    }

    public String getFamily(){
        return familyTree.getFamily_tree().toString();
    }

    public void addHuman (String first_name, String last_name, String patronymic, LocalDate dayofdeath, LocalDate birthday, int father, int mother, List<Integer> childrensId, String genderstr){
        ArrayList<Human> children = new ArrayList<>();
        for (int id : childrensId){
            children.add(familyTree.findHumanbyid(id));
        }
        Gender gender;
        if (genderstr.equals("MALE")) gender = Gender.MALE;
        else gender = Gender.FEMALE;
        Human human = new Human(first_name, last_name, patronymic, dayofdeath, birthday, familyTree.findHumanbyid(father), familyTree.findHumanbyid(mother), children, gender);
        familyTree.addHuman(human);
    }

    public void removeHuman(int id){
        familyTree.removeHuman(familyTree.findHumanbyid(id));
    }

    public String idFindHuman(int id){
        return familyTree.findHumanbyid(id).toString();
    }

    public String nameFindHuman(String first_name, String last_name, String patronymic){
        return familyTree.findHumanbyname(first_name, last_name, patronymic).toString();
    }

    public ArrayList<String> getAncestors(int id){
        ArrayList<Human> arr = familyTree.getAncestors(familyTree.findHumanbyid(id));
        ArrayList<String> res = new ArrayList<String>();
        for (Human human : arr){
            res.add(human.toString());
        }
        return res;
    }

    public ArrayList<String> getDescendants(int id){
        ArrayList<Human> arr = familyTree.getDescendants(familyTree.findHumanbyid(id));
        ArrayList<String> res = new ArrayList<String>();
        for (Human human : arr){
            res.add(human.toString());
        }
        return res;
    }

    public void sortByname(){
        familyTree.sortByName();
    }

    public void sortByDateOfBirthday(){
        familyTree.sortByDateOfBirthday();
    }

    public void save(String way){
        FileHandier fh = new FileHandier();
        fh.Save(familyTree, way);
    }

    public void load(String way){
        FileHandier fh = new FileHandier();
        familyTree = (FamilyTree<Human>) fh.Input(way);
    }
}
