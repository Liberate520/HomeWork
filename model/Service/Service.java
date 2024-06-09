package OOP.SemDZ.homeWork.model.Service;

import java.time.LocalDate;

import OOP.SemDZ.homeWork.model.familyTree.FamilyTree;
import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.model.human.Human;
import OOP.SemDZ.homeWork.model.write.FileHandler;

public class Service {
    FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }
    
    public void addHuman (String name, Gender gender, LocalDate birthDate){
        Human human = new Human(name, gender, birthDate);
        tree.addHuman(human); 
    }

    public void loadOfFile(){
        FileHandler file = new FileHandler();
        tree = (FamilyTree<Human>) file.read("C:\\Users\\korpa\\Documents\\Разработчик\\Java\\OOP\\SemDZ\\homeWork\\model\\write\\tree.data");
    }

    public void saveToFile(){
        FileHandler file = new FileHandler();
        file.save(tree, "C:\\Users\\korpa\\Documents\\Разработчик\\Java\\OOP\\SemDZ\\homeWork\\model\\write\\tree.data");
    }

    public void addHuman(Human human) {
        tree.addHuman(human);
    }

    public String printFamilyTree(){
        return tree.toString();
    }

    public void wedding (Human groom, Human bride){
        groom.setSpouse(bride);
        bride.setSpouse(groom);
    }

    public void birthChildren(String name, Gender gender, LocalDate birthday, String IdFather, String IdMather){
        Human father = null;
        Human mather = null;
        for (Human human : tree) {
            if (human.getId()==Integer.parseInt(IdFather)){
                father = human;
            }
            if (human.getId()==Integer.parseInt(IdMather)){
                mather = human;
            }
        }
        Human child = new Human(name, gender, birthday, father, mather);
        tree.addHuman(child);
        System.out.println("У "+ father.getName()+" и "+ mather.getName()+ " родился ребенок "+ child.getName());
    }

    public void wedding (String groom, String bride){
        Human gr = null;
        Human br = null; 
        for (Human human : tree) {
            if (human.getId()==Integer.parseInt(groom)){
                gr = human;
            }
            if (human.getId()==Integer.parseInt(bride)){
                br = human;
            }
        }
        wedding(gr, br);
        System.out.println(gr.getName()+" и "+ br.getName()+" теперь муж и жена");

    }
    
    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    
}
