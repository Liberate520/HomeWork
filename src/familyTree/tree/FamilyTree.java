package familyTree.tree;

import familyTree.humans.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Person> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    /**
     * Инициализация дерева
     * @param tree Для стартового дерева
     */
    public FamilyTree(List<Person> tree){
        this.tree = new ArrayList<>(tree);
    }

    /**
     * Инициализация дерева
     * @param person Если хотим начать с человека а не готового дерева
     */
    public FamilyTree(Person person) {
        this();
        this.tree.add(person);
    }

    /**
     * Поиск людей по имени
     * @param name Имя искомого человека в дереве
     * @return Список найденных совпадений по имени (На случай СанСанычей)
     */
    public List<Person> findPerson(String name){
        List<Person> listResult = new ArrayList<>();
        for(Person person : tree){
            if(person.getName().equals(name)){
                listResult.add(person);
            }
        }
        return listResult;
    }

    /**
     * Поиск людей по имени и возрасту
     * @param name Имя искомого
     * @param age Возраст искомого
     * @return Список найденных людей (На случай СанСанычей-одногодок)
     */
    public List<Person> findPerson(String name, int age){
        List<Person> listResult = new ArrayList<>();
        for(Person person : tree){
            if(person.getName().equals(name) && person.getAge() == age){
                listResult.add(person);
            }
        }
        return listResult;
    }

    /**
     * Поиск людей по имени, возрасту и именам родителям
     * @param name Имя искомого человека
     * @param age Возраст искомого человека
     * @param fatherName Имя отца искомого человека
     * @param motherName Имя матери искомого человека
     * @return Список найденных людей с заданными параметрами (Не надо недооценивать силу традиции СанСанычей)
     */
    public List<Person> findPerson(String name, int age, String fatherName, String motherName){
        List<Person> listResult = new ArrayList<>();
        for(Person person : tree){
            if(person.getName().equals(name)
                    && person.getAge() == age
                    && person.getFather().getName().equals(fatherName)
                    && person.getMother().getName().equals(motherName)){
                listResult.add(person);
            }
        }
        return listResult;
    }

    public void addFamilyMember(Person person){
        this.tree.add(person);
    }
}
