package ru.gb.FamilyTree.family_tree;

import ru.gb.FamilyTree.person.Gender;
import ru.gb.FamilyTree.person.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
//    private String nameTree;
    private long personId;
    private final List<Person> familyMembersList;

    public FamilyTree() {
        familyMembersList = new ArrayList<>();
    }

    public FamilyTree(List<Person> familyMembersList) {
        this.familyMembersList = familyMembersList;
    }

    public boolean addPerson(Person person) {
        if (person == null) {
            return false;
        }
        if (!familyMembersList.contains(person)) {
            familyMembersList.add(person);
            person.setId(personId++);

            addToParents(person);
            addToChildren(person);
            return true;
        }
        return false;
    }

    private void addToParents(Person person) {
        for (Person parent: person.getParents()) {
            parent.addChild(person);
        }
    }

    private void addToChildren(Person person) {
        for (Person child: person.getChildren()) {
            if (person.getGender().equals(Gender.Male.toString())) {
                child.setFather(person);
            } else if (person.getGender().equals(Gender.Female.toString())) {
                child.setMother(person);
            }
        }
    }

    public List<Person> getSiblings(long personId) {
        Person person = getById(personId);
        if (person == null) {
            return null;
        }
        List<Person> siblings = new ArrayList<>();
        for (Person parent: person.getParents()) {
            for (Person child: parent.getChildren()) {
                if (!child.equals(person)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public Person getById(long personId) {
        for (Person person: familyMembersList) {
            if (person.getId() == personId) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getByName(String name) {
        List<Person> persons = new ArrayList<>();
        for (Person person: familyMembersList) {
            if (person.getName().equals(name)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public boolean setAddSpouses(long personId1, long personId2) {
        if (checkId(personId1) && checkId(personId2)) {
            Person person1 = getById(personId1);
            Person person2 = getById(personId2);
            setAddSpouses(person1, person2);
            return true;
        }
        return false;
    }

    public boolean setAddSpouses(Person person1, Person person2) {
        if (person1 != null && person2 != null) {
            person1.setSpouse(person2);
            person2.setSpouse(person1);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSpouses(Person person1, Person person2) {
        if (person1 != null && person2 != null) {
            person1.setSpouse(null);
            person2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSpouses(long personId1, long personId2) {
        if (checkId(personId1) && checkId(personId2)) {
            Person person1 = getById(personId1);
            Person person2 = getById(personId2);
            removeSpouses(person1, person2);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long personId) {
        if (checkId(personId)) {
            Person person = getById(personId);
            return familyMembersList.remove(person);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < personId && id >=0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Количество членов семьи: ").append(familyMembersList.size()).append("\n");
        for (Person person: familyMembersList) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }



//    public String showAllFamilyMembers() {
//        StringBuilder sb = new StringBuilder();
//        for (Person person : familyMembersList) {
//            sb.append(person.toString()).append("\n");
//        }
//        return sb.toString();
//    }
//
//    public List<Person> getFamilyMembers() {
//        return familyMembersList;
//    }
//
//    public Person getFamilyMember(String name) {
//        for (Person person : familyMembersList) {
//            if (person.getName().equals(name)) {
//                return person;
//            }
//        }
//        return null;
//    }
//
//    public void setFatherForPerson(Person father, Person child) {
//        if (father != child) {
//            if (father.getGender().equals("Male")) {
//                if (father.getAge() - child.getAge() >= 16) {
//                    father.addChild(child);
//                    child.setFather(father);
//                    System.out.println("Добавлена связь: " + father + " отец -> " + child);
//                    if (!familyMembersList.contains(father)) {
//                        familyMembersList.add(father);
//                    }
//                    if (!familyMembersList.contains(child)) {
//                        familyMembersList.add(child);
//                    }
//                } else {
//                    System.out.println("Маленькая разница в возрасте. Не могут быть отцом и ребенком");
//                }
//            } else {
//                System.out.println("Отец должен быть мужчиной");
//            }
//
//        }
//    }
}
