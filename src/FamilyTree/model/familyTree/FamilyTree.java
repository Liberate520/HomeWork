package FamilyTree.model.familyTree;

import FamilyTree.model.human.Comparators.*;
import FamilyTree.model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Iterable<T>, Serializable {
    private long id;
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {return members.iterator();}
//    public Iterator<T> iterator() {
//        return new FamilyTreeIterator<>(members);
//    }

    public void addChild(T child) {
        if (child.getFather() != null && members.contains(child.getFather())) {
            if (!child.getFather().getChildren().contains(child)) {
                child.getFather().getChildren().add(child);
            }
        }
        if (child.getMother() != null && members.contains(child.getMother())) {
            if (!child.getMother().getChildren().contains(child)) {
                child.getMother().getChildren().add(child);
            }
        }
    }

    public void addGrandchild(T grandchild) {
        for (T member : members) {
            if (member.getChildren().contains(grandchild.getFather()) ||
                    member.getChildren().contains(grandchild.getMother())) {
                member.addGrandchild(grandchild);
            }
        }
    }

    public List<T> getGrandchildren() {
        List<T> grandchildren = new ArrayList<>();
        for (T member : members) {
            grandchildren.addAll(member.getGrandchildren());
        }
        return grandchildren;
    }

    public void setParent(T parent) {
        if (parent.getGender() == Gender.Female) {
            for (T child : parent.getChildren()) {
                child.setMother(parent);
            }
        } else if (parent.getGender() == Gender.Male) {
            for (T child : parent.getChildren()) {
                child.setFather(parent);
            }
        }
    }

    public List<T> getSiblings(T person) {
        List<T> siblings = new ArrayList<>();
        if (person.getFather() != null) {
            for (T sibling : person.getFather().getChildren()) {
                if (!sibling.equals(person)) {
                    siblings.add(sibling);
                }
            }
        }
        return siblings;
    }

    public List<T> getAncestors(T person) {
        List<T> ancestors = new ArrayList<>();
        if (person.getFather() != null) {
            ancestors.add(person.getFather());
            ancestors.addAll(getAncestors((T) person.getFather()));
        }
        if (person.getMother() != null) {
            ancestors.add(person.getMother());
            ancestors.addAll(getAncestors((T) person.getMother()));
        }
        return ancestors;
    }

    public int getAge() {
        int totalAge = 0;
        for (T member : members) {
            totalAge += member.getAge();
        }
        return totalAge;
    }

    public void sortByName() {
        members.sort(new FTComparatorByName<>());
    }

    public void sortByBirthDate() {
        members.sort(new FTComparatorByBirthDate<>());
    }

    public void sortByAge() {
        members.sort(new FTComparatorByAge<>());
    }

    public boolean addMember(T member) {
        if (member == null) {
            return false;
        }

        for (T existingMember : members) {
            if (existingMember.getName().equals(member.getName()) &&
                    existingMember.getBirthDate().equals(member.getBirthDate())) {
                System.out.println("Член семьи с таким именем уже существует: " + member.getName());
                return false;
            }
        }

        member.setId(id++);
        members.add(member);
        System.out.println("Добавлен новый член семьи с id: " + member.getId() + ", имя: " + member.getName());

        if (member.getFather() != null && members.contains(member.getFather())) {
            member.getFather().addChild(member);
        }
        if (member.getMother() != null && members.contains(member.getMother())) {
            member.getMother().addChild(member);
        }
        updateFamilyTree(member);
        return true;
    }

//    public boolean addMember(T member) {
//        if (member == null) {
//            return false;
//        }
//
//        // Проверка, есть ли уже такой член в дереве
//        T existingMember = null;
//        for (T existing : members) {
//            if (existing.equals(member)) {
//                existingMember = existing;
//                break;
//            }
//        }
//
//        if (existingMember == null) {
//            // Новый член семьи
//            members.add(member);
//            member.setId(id++);
//
//            // Привязываем к отцу и матери, если они есть в дереве
//            if (member.getFather() != null && members.contains(member.getFather())) {
//                member.getFather().addChild(member);
//            }
//            if (member.getMother() != null && members.contains(member.getMother())) {
//                member.getMother().addChild(member);
//            }
//
//            // Обновляем семейное дерево с учетом новых отношений
//            updateFamilyTree(member);
//            return true;
//        }
//
//        // Если член уже существует в дереве, ничего не делаем
//        return false;
//    }
//
////    public boolean addMember(T member) {
////        System.out.println("___ЧЛЕН - " + member);
////        System.out.println("___id before - " + id);
////        if (member == null) {
////            return false;
////        }
////        for (T existingMember : members) {
////            if (existingMember.equals(member)) {
////                member = existingMember;
////                break;
////            }
////        }
////        System.out.println("__ЧЛЕН - " + member);
////        System.out.println("__id before - " + id);
//////        if (!members.contains(member)) {
////            System.out.println("ЧЛЕН - " + member);
////            members.add(member);
////            System.out.println("id before - " + id);
////            member.setId(id++);
////            System.out.println("id after - " + id);
////            if (member.getFather() != null && members.contains(member.getFather())) {
////                member.getFather().addChild(member);
////            }
////            if (member.getMother() != null && members.contains(member.getMother())) {
////                member.getMother().addChild(member);
////            }
////            // Обновим семейное дерево с учетом новых отношений члена семьи
////            updateFamilyTree(member);
////
////            System.out.println("_ЧЛЕН - " + member);
////            System.out.println("_id before - " + id);
////
//////            return true;
//////        }
////        return true;
////    }

    private void updateFamilyTree(T member) {
        List<T> children = new ArrayList<>();
        if (member.getFather() != null) {
            children.addAll(member.getFather().getChildren());
        }
        if (member.getMother() != null) {
            children.addAll(member.getMother().getChildren());
        }
        for (T child : children) {
            addChild(child);
        }
    }

    public List<T> getMembers() {
        return Collections.unmodifiableList(members);
    }

//        public List<T> getMembers() {
//            return members;
//        }

    public T getMemberById(long id) {
        for (T member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public T getMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getChildren(T person) {
        List<T> children = new ArrayList<>();
        if (person.getChildren() != null) {
            children.addAll(person.getChildren());
        }
        return children;
    }

    public T getSpouse(T person) {
        if (person.getSpouse() != null) {
            return person.getSpouse();
        }
        return null;
    }

    public void setSpouse(T person, T spouse) {
        person.setSpouse(spouse);
        spouse.setSpouse(person);
    }

    public int getNumberOfMembers() {
        return members.size();
    }

//    public boolean removeMember(T member) {
//        return members.remove(member);
//    }

    public boolean removeMember(T member) {
        if (members.contains(member)) {
            members.remove(member);
            if (member.getFather() != null && member.getFather().getChildren().contains(member)) {
                member.getFather().getChildren().remove(member);
            }
            if (member.getMother() != null && member.getMother().getChildren().contains(member)) {
                member.getMother().getChildren().remove(member);
            }
            for (T child : member.getChildren()) {
                child.setFather(null);
                child.setMother(null);
            }
            return true;
        }
        return false;
    }

    public void clear() {
        members.clear();
    }

    public StringBuilder printFamilyTree() {
        StringBuilder info = new StringBuilder();
        info.append("Семейное дерево:\n");
        for (T member : members) {
            info.append(member.getInfo()).append("\n");  // Добавляем информацию о члене дерева в StringBuilder
        }
        return info;
    }

    public void printChildren(T person) {
        System.out.println("Дети " + person.getName() + ":");
        if (person.getChildren() != null && !person.getChildren().isEmpty()) {
            for (T child : person.getChildren()) {
                System.out.println(child.getName());
            }
        } else {
            System.out.println("Отсутствуют");
        }
    }

    public void printSiblings(T person) {
        System.out.println("Братья и сестры " + person.getName() + ":");
        List<T> siblings = getSiblings(person);
        if (siblings != null && !siblings.isEmpty()) {
            for (T sibling : siblings) {
                System.out.println(sibling.getName());
            }
        } else {
            System.out.println("Отсутствуют");
        }
    }

    public void printAncestors(T person) {
        System.out.println("Предки " + person.getName() + ":");
        List<T> ancestors = getAncestors(person);
        if (ancestors != null && !ancestors.isEmpty()) {
            for (T ancestor : ancestors) {
                System.out.println(ancestor.getName());
            }
        } else {
            System.out.println("Отсутствуют");
        }
    }

    public void printGrandchildren(T person) {
        System.out.println("Внуки " + person.getName() + ":");
        List<T> grandchildren = person.getGrandchildren();
        if (grandchildren != null && !grandchildren.isEmpty()) {
            for (T grandchild : grandchildren) {
                System.out.println(grandchild.getName());
            }
        } else {
            System.out.println("Отсутствуют");
        }
    }

    public void printSpouse(T person) {
        T spouse = person.getSpouse();
        if (spouse != null) {
            String spouseTitle = spouse.getGender() == Gender.Male ? "супруг" : "супруга";
            System.out.println("У " + person.getName() + " есть " + spouseTitle + ": " + spouse.getName());
        } else {
            System.out.println(person.getName() + " не состоит в браке.");
        }
    }

    public void printAgeStatistics() {
        int totalAge = 0;
        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;

        for (T member : members) {
            int age = member.getAge();
            totalAge += age;
            if (age < minAge) {
                minAge = age;
            }
            if (age > maxAge) {
                maxAge = age;
            }
        }

        double averageAge = (double) totalAge / members.size();

        System.out.println("Статистика возраста членов семьи:");
        System.out.println("Средний возраст: " + averageAge);
        System.out.println("Минимальный возраст: " + minAge);
        System.out.println("Максимальный возраст: " + maxAge);
    }
}
