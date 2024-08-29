package GB_Homework.Model.Service;

import GB_Homework.Model.Handler.FileHandler;
import GB_Homework.Model.Handler.Writable;
import GB_Homework.Model.Human.HumanBuilder;
import GB_Homework.Model.Family_Tree.FamilyTree;
import GB_Homework.Model.Gender.Gender;
import GB_Homework.Model.Human.Human;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.List;

public class Service {
    private Human human;
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    private Writable writable;

    public Service() {
        human=new Human();
        familyTree=new FamilyTree<Human>();
        humanBuilder=new HumanBuilder();
        writable=new FileHandler();
    }

    public void addHuman(String name, LocalDate birghDate, LocalDate deathDate, Gender gender){
        Human human1=humanBuilder.build(name,birghDate,deathDate,gender);
        familyTree.addHuman(human1);
    }

    public void addHuman(String name, LocalDate birghDate, Gender gender) {
        Human human1 = humanBuilder.build(name, birghDate, gender);
        familyTree.addHuman(human1);
    }

    public void addChild(Human human,Human child) {  //добавить ребёнка

        human.addChild(child);

    }

    public void addMother(Human human,Human mother) {  //добавить мать
        human.addMother(mother);
    }

    public void addFather(Human human,Human father) {   //добавить отца
        human.addFather(father);
    }

    public void addSpouse(Human human,Human spouse) {   //добавить супруга,супругу
        human.addSpouse(spouse);
    }

    public int getAge(Human human) {   //возвращает возраст либо годы жизни
        return human.getAge();
    }

    public Human getById(int id){   // вернуть по id
        return familyTree.getById(id);
    }

    public List<Human> getByName(String name){   //вернуть по имени
        return familyTree.getByName(name);
    }

    public  List<Human> getSiblings(int id) {   //найти братьев и сестёр
        return familyTree.getSiblings(id);
    }

    public FamilyTree<Human> getFamilyTree(){
        return familyTree;
    }

    public void printNameFamilyTree(){
        for (Human h:familyTree){
            System.out.println(h.getName());
        }
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByData(){
        familyTree.sortByData();
    }

    public void saveFamilyTree(String file) throws IOException {  // Сохранить в файл
        writable.save(getFamilyTree(),file);
    }

    public void readFamilyTree(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        FamilyTree<Human> loadedTree = (FamilyTree<Human>) ois.readObject();
        ois.close();

        // Восстановление данных в текущем экземпляре Service
        this.familyTree = loadedTree;
    }
}
