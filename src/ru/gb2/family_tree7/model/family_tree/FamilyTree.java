package ru.gb2.family_tree7.model.family_tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private List<E> humanList = new ArrayList<>();
    private long humansId = 1; // Начальный идентификатор для членов семьи

    // Метод для сохранения дерева в файл
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this); // Сериализация объекта
            System.out.println("Дерево успешно сохранено в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении дерева: " + e.getMessage());
        }
    }

    // Метод для восстановления дерева из файла
    public static <E extends TreeNode<E>> FamilyTree<E> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            FamilyTree<E> tree = (FamilyTree<E>) ois.readObject(); // Десериализация объекта
            System.out.println("Дерево успешно загружено из файла " + filename);
            return tree;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке дерева: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return humanList.iterator();
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
        if (human == null) return false; // Проверка на null
        if (!humanList.contains(human)) {
            human.setId(humansId++); // Увеличение ID происходит перед добавлением
            humanList.add(human);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false; // Возвращаем false, если человек уже существует
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSiblings(long id) {
        E human = getById(id);
        if (human == null) {
            return null; // Если человек не найден, возвращаем null
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add((E) child);
                }
            }
        }
        return res; // Возвращаем список братьев и сестер
    }

    public List<E> getByName(String name) {
        if (name == null) { // Проверка на null для имени
            return new ArrayList<>(); // Возвращаем пустой список, если имя null
        }
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (name.equals(human.getName())) {
                res.add((E) human);
            }
        }
        return res;
    }

    public E getById(long id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human; // Возвращаем человека по ID
            }
        }
        return null; // Если не найдено, возвращаем null
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В древе ").append(humanList.size()).append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    // Метод для добавления члена семьи
    public boolean addMember(E human) {
        if (human == null) return false; // Проверка на null
        if (humanList.contains(human)) return false; // Проверка существования

        // Установить идентификатор
        human.setId(humansId++);

        // Добавить человека в список
        humanList.add(human);

        // Обновить семейные связи для родителей и детей
        for (E parent : human.getParents()) { // Заменить E на Human
            if (!humanList.contains(parent)) {
                humanList.add((E) parent); // Добавляем родителя в список, если его там нет
            }
            parent.addChild(human); // Добавляем человека в детей для каждого родителя
        }

        for (E child : human.getChildren()) { // Заменить E на Human
            if (!humanList.contains(child)) {
                humanList.add((E) child); // Добавляем ребенка в список, если его там нет
            }
            child.addParent(human); // Добавляем человека в родителей для каждого ребенка
        }

        return true; // Успешное добавление
    }

}