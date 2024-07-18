package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.util.*;

public class FamilyTree {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public void addHumans(Human... humans) {
        familyTree.addAll(Arrays.asList(humans));
    }

    public void setParentsByChildren() {
        for (Human human : familyTree) {
            List<Human> children = human.getChildren();
            if (children != null) {
                for (Human child : children) {
                    if (human.getGender() == Gender.Female) {
                        child.setMother(human);
                    } else {
                        child.setFather(human);
                    }
                }
            }
        }
    }

    // разбиваем строку запроса по пробелу, Создаем HashMap с количеством совпадений по Фамилии Имени и Отчеству,
    // В результат поиска выводятся объекты с максимальным количеством совпадений

    public List<Human> searchHuman(String request) {
        List<String> params = new ArrayList<>(Arrays.asList(request.split(" ")));
        List<Human> result = new ArrayList<>();
        Map<Human, Integer> matches = new HashMap<>();
        int maxMatchCount = 0;
        for (Human human : familyTree) {
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
        for (Map.Entry<Human, Integer> entry : matches.entrySet()) {
            if (entry.getValue() == maxMatchCount) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<Human> getParents(Human human){
        List<Human> parents = new ArrayList<>();
        parents.add(human.getMother());
        parents.add(human.getFather());
        return parents;
    }

    public String showParents(Human human){
        return "Мать: " + '\n' +
                human.getMother() +
                "Отец: " + '\n' +
                human.getFather();
    }

    public List<Human> getGrandMothers(Human human){
        List<Human> grandMothers = new ArrayList<>();
        grandMothers.add(human.getMother().getMother());
        grandMothers.add(human.getFather().getMother());
        return grandMothers;
    }

    public List<Human> getGrandFathers(Human human){
        List<Human> grandFathers = new ArrayList<>();
        grandFathers.add(human.getFather().getFather());
        grandFathers.add(human.getMother().getFather());
        return grandFathers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : familyTree) {
            result.append(human);
        }
        return result.toString();
    }
}
