package family_tree.model.service;

import family_tree.model.person.Gender;
import family_tree.model.person.Human;
import family_tree.model.person.TreeNode;
import family_tree.model.tree.FamilyTree;
import family_tree.model.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service<T extends TreeNode<T>> {
    private long genId;
    private FamilyTree<T> familyTree;
    private FileHandler fh;
    Class clazz; //хранение информации о классе дерева, если будет список деревьев, то будет и список классов. Будут мэтчится по индексам


    public Service(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public Service(Class clazz) {
        this.familyTree = new FamilyTree<>();
        this.clazz = clazz;
    }
    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public boolean addSubjectToFamilyTree(String name, LocalDate dob, Gender gender, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, gender);
            human.setId(genId++);
            familyTree.addPersonToFamily((T) human);
            return true;
        }
        return false;
    }


    public boolean addSubjectToFamilyTree(String name,
                                          LocalDate dob, LocalDate dod,
                                          Gender gender, T father, T mother, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, dod, gender, (Human) father, (Human) mother);
            human.setId(genId++);
            familyTree.addPersonToFamily((T) human);
            return true;
        }
        return false;
    }

    public boolean addSubjectToFamilyTree(String name,
                                          LocalDate dob, Gender gender, T father, T mother, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, gender, (Human) father, (Human) mother);
            human.setId(genId++);
            familyTree.addPersonToFamily((T) human);
            return true;
        }
        return false;
    }

    public boolean addSubjectToFamilyTree( T human) {
        // Переписать на итерацию по списку классов и поиск совпадений
        // Может быть ошибка, если будет несколько деревьев одного класса
        if (clazz.equals(human.getClass())) {
            human.setId(genId++);
            familyTree.addPersonToFamily(human);
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")

    public void addSubjectToFamilyTree(String name,
                                       LocalDate dob, LocalDate dod,
                                       Gender gender, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, dod, gender);
            human.setId(genId++);
            familyTree.addPersonToFamily((T) human);
        }
    }

    public void setParentsForSubject(String nameForSearching, T parent) {
        if (findByName(nameForSearching) != null) {
            findByName(nameForSearching).setParent(parent);
        }
    }

    public T findByName(String nameForSearching) {
        T subject =  familyTree.findUnitByName(nameForSearching);
        if(subject != null) return subject;
        System.out.println("Subject with name: " + nameForSearching + " is not found");
        return null;
    }

    public T findByDateOfBirth(LocalDate dob){
        T subject = familyTree.findHumanByDateOfBirth(dob);
        if(subject != null) return subject;
        System.out.println("Subject with this date of birth: " + dob + " is not found");
        return null;
    }


    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }
    public ArrayList<T> sortByAge() {
        return familyTree.sortByAge();
    }

    public ArrayList<T> sortByDateOfBirth() {
        return familyTree.sortByDateOfBirth();
    }

    public ArrayList<T> sortByName() {
        return familyTree.sortByName();
    }

    public void initializationFileHandler() {
        fh = new FileHandler<T>(); // ??
    }


    public boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree) {
        return fh.writeTreeAsByteCode(outputObject, fileNameForTree);
    }

    public boolean writeSubjectAsByteCode(Serializable outputObject, String fileNameForPeople) {
        return fh.writeSubjectAsByteCode(outputObject, fileNameForPeople);
    }

    public FamilyTree<T> readTreeFromByteCodeFile(String fileNameForTree) {
        return fh.readTreeFromByteCodeFile(fileNameForTree);
    }

    public T readSubjectFromByteCodeFile(String fileNameForPeople) {
        return (T) fh.readSubjectFromByteCodeFile(fileNameForPeople); //??
    }
    public ArrayList<String> getListOfNamesFromFamilyTree(){
        return getFamilyTree().getListOfNames();
    }

    public ArrayList<String> getListOfNamesFromInputLIstOfSubjects(ArrayList<T> inputList){
        return familyTree.getListOfNamesFromInputList(inputList);
    }

}

