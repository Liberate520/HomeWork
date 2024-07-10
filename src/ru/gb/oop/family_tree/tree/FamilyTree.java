package ru.gb.oop.family_tree.tree;

import ru.gb.oop.family_tree.Main;
import ru.gb.oop.family_tree.human.Human;
import ru.gb.oop.family_tree.human.HumanComparatorByAge;
import ru.gb.oop.family_tree.human.HumanComparatorByName;
import ru.gb.oop.family_tree.human.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private final List<Human> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }


    public void addHuman(Human human) {
        if (!tree.contains(human)) {
            tree.add(human);
            if (!this.isCorrect(tree)) {
                tree.remove(human);
                Main.logger.warning(human.toString());
                throw new IllegalArgumentException("Error: " + human);
            }
        }
    }

    public Human findHumanByName(String name) {
        for (Human human : tree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        System.out.println("There is no human named " + name);
        return null;
    }

    public List<Human> getSistersAndBrothers(String name) {
        List<Human> sistersAndBrothers = new ArrayList<>();
        Human current = findHumanByName(name);
        Human parent1 = current.getParents().get(0);
        Human parent2 = current.getParents().get(1);

        for (Human brother : parent1.getChildren()) {
            if (!current.equals(brother)) {
                sistersAndBrothers.add(brother);
            }
        }

        /* У родителей могут быть дети от разных браков, поэтому необходимо взять список детей у обоих родителей
         *  но избежать повтороений */
        for (Human brother : parent2.getChildren()) {
            if (!current.equals(brother) && !sistersAndBrothers.contains(brother)) {
                sistersAndBrothers.add(brother);
            }
        }

        return sistersAndBrothers;
    }

    /**
     * @param name имя того, чей список предков ищем
     * @return возвращает список всех предков с указанием, в каком поколении они были
     */
    public List<Map.Entry<Human, Integer>> getAllGenerationsBefore(String name) {
        //в MyArrayList добавлена перегрузка метода contains для игнорирования номера поколения
        Human current = findHumanByName(name);
        if (current == null) {
            return null;
        }
        MyArrayList generations = new MyArrayList();

        MyArrayList ancestors = new MyArrayList();
        if (!current.getParents().isEmpty()) {
            ancestors.add(Map.entry(current.getParents().get(0), 0));
            ancestors.add(Map.entry(current.getParents().get(1), 0));

            while (!ancestors.isEmpty()) {
                MyArrayList newAncestors = new MyArrayList();
                for (Map.Entry<Human, Integer> ancestor : ancestors) {
                    if (!ancestor.getKey().getParents().isEmpty()) {
                        for (Human parent : ancestor.getKey().getParents()) {
                            if (generations.contains(parent)) {
                                Main.logger.warning("Error: there are cycles in the family tree" + this);
                                throw new IllegalArgumentException("Error: there are cycles in the family tree");
                            }
                            newAncestors.add(Map.entry(parent, ancestor.getValue() + 1));
                        }
                    }

                }
                generations.addAll(ancestors);
                ancestors = newAncestors;
            }
        }

        return generations;
    }


    /**
     * Корректное дерево удовлетворяет следующим правилам
     * 1) Все Human в дереве корректны
     * 2) Ни один ребенок не может быть родителем ни одного своего предка
     */
    public boolean isCorrect(List<Human> tree) {
        if (tree.isEmpty())
            return true;
        for (Human human : tree) {
            if (!human.isCorrect()) {
                return false;
            }
        }

//        Human human = tree.getFirst();
//
//        Set<Human> visited = new HashSet<>();
//        Stack<Human> stack = new Stack<>();
//        Set<Human> ancestors = new HashSet<>();
//        try {
//            dfs(human, visited, stack, ancestors);
//        } catch (Exception e) {
//            Main.logger.warning("Error: " + e.getMessage());
//            return false;
//        }

        return true;
    }

    public void sortByName() {
        tree.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        tree.sort(new HumanComparatorByAge());
    }

    private static void dfs(Human current, Set<Human> visited, Stack<Human> stack, Set<Human> ancestors) {
       //todo: реализовать рекурсивный обход дерева, при нахождении замкнутого цикла выбрасывать исключение
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FamilyTree: \n");
        for (Human human : tree) {
            if (!human.getParents().isEmpty()) {
                sb.append("\nParent1\n").append(human.getParents().get(0)).append("\n\nParent2\n").append(human.getParents().get(1)).append("\n");
            }
            sb.append("\nHuman\n").append(human).append("\n");
            if (!human.getChildren().isEmpty()) {
                for (Human child : human.getChildren()) {
                    sb.append("\nChild\n").append(child).append("\n");
                }
            }
            sb.append("----------------------------------\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(tree);
    }

    public static class MyArrayList extends ArrayList<Map.Entry<Human, Integer>> {
        public MyArrayList() {
            super();
        }
        public boolean contains(Human h) {
            for (Map.Entry<Human, Integer> entry : this) {
                if (entry.getKey().equals(h)) {
                    return true;
                }
            }
            return false;
        }
    }
}
