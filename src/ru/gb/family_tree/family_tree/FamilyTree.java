package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.enums.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorByBirthday;
import ru.gb.family_tree.human.comparators.HumanComparatorById;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {
    List<T> familyTree;

    public FamilyTree(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addHuman(T human) {
        familyTree.add(human);
    }

    public void addHumans(T... humans) {
        familyTree.addAll(Arrays.asList(humans));
    }

    public void setParentsByChildren() {
        for (T human : familyTree) {
            List<T> children = human.getChildren();
            if (children != null) {
                for (T child : children) {
                    if (human.getGender() == Gender.Female) {
                        child.setMother(human);
                    } else {
                        child.setFather(human);
                    }
                }
            }
        }
    }

    private void setChildren(T parent, T child){
        if (parent.getChildren() != null){
            List<T> children = parent.getChildren();
            children.add(child);
            parent.setChildrenList(children);
        } else {
            List<T> children = new ArrayList<>();
            children.add(child);
            parent.setChildrenList(children);
        }
    }

    public void setChildrenByParents(){
        for (T human : familyTree){
            if (human.getMother() != null){
                T mother = (T) human.getMother();
                setChildren(mother, human);
            }
            if (human.getFather() != null){
                T father = (T) human.getFather();
                setChildren(father, human);
            }
        }
    }

    public T getHumanById(int id){
        for(T human : familyTree){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    // разбиваем строку запроса по пробелу, Создаем HashMap с количеством совпадений по Фамилии Имени и Отчеству,
    // В результат поиска выводятся объекты с максимальным количеством совпадений

    public List<T> searchHuman(String request) {
        List<String> params = new ArrayList<>(Arrays.asList(request.split(" ")));
        List<T> result = new ArrayList<>();
        Map<T, Integer> matches = new HashMap<>();
        int maxMatchCount = 0;
        for (T human : familyTree) {
            int matchCount = 0;
            for (String param : params) {
                if (human.getName().contains(param)) {
                    matchCount++;
                }
                if (human.getSurname().contains(param)) {
                    matchCount++;
                }
                if (human.getPatronymic().contains(param)) {
                    matchCount++;
                }
            }
            if (matchCount > 0) {
                matches.put(human, matchCount);
            }
        }
        maxMatchCount = Collections.max(matches.values());
        for (Map.Entry<T, Integer> entry : matches.entrySet()) {
            if (entry.getValue() == maxMatchCount) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<T> getParents(T human){
        List<T> parents = new ArrayList<>();
        parents.add((T)human.getMother());
        parents.add((T)human.getFather());
        return parents;
    }

    public String showParents(T human){
        return "Мать: " + '\n' +
                human.getMother() +
                "Отец: " + '\n' +
                human.getFather();
    }

    public List<T> getGrandMothers(T human){
        List<T> grandMothers = new ArrayList<>();
        T mother = (T)human.getMother();
        T father = (T)human.getFather();
        grandMothers.add((T)mother.getMother());
        grandMothers.add((T)father.getMother());
        return grandMothers;
    }

    public List<T> getGrandFathers(T human){
        List<T> grandFathers = new ArrayList<>();
        T mother = (T)human.getMother();
        T father = (T)human.getFather();
        grandFathers.add((T)mother.getFather());
        grandFathers.add((T)father.getFather());
        return grandFathers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T human : familyTree) {
            result.append(human);
        }
        return result.toString();
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge<>());
    }

    public void sortByBirthday(){
        familyTree.sort(new HumanComparatorByBirthday<>());
    }

    public void sortById(){
        familyTree.sort(new HumanComparatorById<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }
}
