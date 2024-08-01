package family_tree.presentor;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandier;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presentor {

    private View view;
    private FamilyTree<Human> familyTree;

    public Presentor(View view){
        this.view = view;
        familyTree = new FamilyTree<Human>();
    }

    public String getFamily(){
        return familyTree.getFamily_tree().toString();
    }

    private Human creatHuman(String first_name, String last_name, String patronymic, LocalDate dayofdeath, LocalDate birthday, Human father, Human mother, ArrayList<Human> children, Gender gender){
        return new Human(first_name, last_name, patronymic, dayofdeath, birthday, father, mother, children, gender);
    }

    public void addHuman(String first_name, String last_name, String patronymic, LocalDate dayofdeath, LocalDate birthday, int father, int mother, List<Integer> childrensId, String genderstr){
        ArrayList<Human> children = new ArrayList<>();
        for (int id : childrensId){
            children.add(familyTree.findHumanbyid(id));
        }
        Gender gender;
        if (genderstr.equals("MALE")) gender = Gender.MALE;
        else gender = Gender.FEMALE;
        Human human = new Human(first_name, last_name, patronymic, dayofdeath, birthday, familyTree.findHumanbyid(father), familyTree.findHumanbyid(mother), children, gender);
        familyTree.addHuman(human);
        view.printAnswer("Человек добавлен успешно!");
    }

    public void removeHuman(int id){
        familyTree.removeHuman(familyTree.findHumanbyid(id));
        view.printAnswer("Человек удален успешно!");
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
        view.printAnswer("Семейное дерево сортированно успешно!");
    }

    public void sortByDateOfBirthday(){
        familyTree.sortByDateOfBirthday();
        view.printAnswer("Семейное дерево сортированно успешно!");
    }

    public void save(String way){
        FileHandier fh = new FileHandier();
        fh.Save(familyTree, way);
        view.printAnswer("Семейное дерево сохранено!");
    }

    public void load(String way){
        FileHandier fh = new FileHandier();
        familyTree = (FamilyTree<Human>) fh.Input(way);
        view.printAnswer("Семейное дерево загружено!");
    }
}
