package FamilyTree;

import Person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private long countPeople;
    private List<Person> personList;

    public FamilyTree(List<Person> personList) {
        this.personList = personList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Person person){
        if (person== null) {
            return false;
        }
        if (!personList.contains(person)){
            personList.add(person);
            person.setId(countPeople++);

            addToParents(person);
            addToChildren(person);

            return true;
        }
        return false;
    }

    private void addToParents(Person person){
        for (Person parent: person.getParents()){
            parent.addChild(person);
        }
    }

    private void addToChildren(Person person){
        for (Person child: person.getChildren()){
            child.addParent(person);
        }
    }

    public List<Person> getSiblings(int id){
        Person person = getById(id);
        if (person == null){
            return null;
        }
        List<Person> res = new ArrayList<>();
        for (Person parent: person.getParents()){
            for (Person child: parent.getChildren()){
                if (!child.equals(person)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Person> getByName(String name){
        List<Person> res = new ArrayList<>();
        for (Person person: personList){
            if (person.getName().equals(name)){
                res.add(person);
            }
        }
        return res;
    }

    //TODO написать метод создания родственной связи

    public boolean setWedding(long personId1, long personId2){
        if (checkId(personId1) && checkId(personId2)){
            Person person1 = getById(personId1);
            Person person2 = getById(personId2);
            return setWedding(person1, person2);
        }
        return false;
    }

    public boolean setWedding(Person person1, Person person2){
        if (person1.getSpouse() == null && person2.getSpouse() == null){
           person1.setSpouse(person2);
            person2.setSpouse(person1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(long personId1, long personId2){
        if (checkId(personId1) && checkId(personId2)){
            Person person1 = getById(personId1);
            Person person2 = getById(personId2);
            return setDivorce(person1, person2);
        }
        return false;
    }

    public boolean setDivorce(Person person1, Person person2){
        if (person1.getSpouse() != null && person2.getSpouse() != null){
            person1.setSpouse(null);
            person2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long personsId){
        if (checkId(personsId)){
            Person person = getById(personsId);
            return personList.remove(person);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < countPeople && id >= 0;
    }

    public Person getById(long id){
        if (checkId(id)){
            for (Person person: personList){
                if (person.getId() == id){
                    return person;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(personList.size());
        sb.append(" объектов: \n");
        for (Person person: personList){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }


}
