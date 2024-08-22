package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.comparators.ComparatorByAge;
import ru.gb.family_tree.model.human.comparators.ComparatorByName;
import ru.gb.family_tree.model.family_tree.iterators.FamilyTreeIterator;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Класс FamilyTree представляет собой древо семейных связей,
 * содержащее элементы типа {@link FamilyTreeElement}.
 *
 * @param <E> тип элемента семейного дерева, наследующего {@link FamilyTreeElement}
 */
public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E> {

    private long MemberId;
    private final List<E> MemberList;

    /**
     * Конструктор по умолчанию инициализирует пустое семейное дерево.
     */
    public FamilyTree() {
        this.MemberList = new ArrayList<>();
    }

    /**
     * Добавляет нового члена в семейное дерево.
     * Если член уже существует в дереве или равен null, он не будет добавлен.
     *
     * @param member новый член семейного дерева
     * @return true, если член был успешно добавлен, иначе false
     */
    public boolean addMember(E member) {
        if (member == null) {
            return false;
        }
        if (!MemberList.contains(member)) {
            MemberList.add(member);
            member.setId(MemberId++);

            addParentsRelations(member);
            addChildrenRelations(member);

            return true;
        }
        return false;
    }

    /**
     * Добавляет отношения родителей для указанного члена семейного дерева.
     *
     * @param member член семейного дерева, для которого устанавливаются родительские связи
     */
    private void addParentsRelations(E member) {
        E mother = member.getMother();
        if (mother != null) {
            mother.addChild(member);
        }

        E father = member.getFather();
        if (father != null) {
            father.addChild(member);
        }
    }

    /**
     * Добавляет отношения детей для указанного члена семейного дерева.
     *
     * @param member член семейного дерева, для которого устанавливаются отношения с детьми
     */
    private void addChildrenRelations(E member) {
        if (member.getChildren().size() > 0) {
            for (E child : member.getChildren()) {
                if (member.getGender() == Gender.female) {
                    child.setMother(member);
                } else {
                    child.setFather(member);
                }
            }
        }
    }

    /**
     * Ищет члена семейного дерева по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор члена семейного дерева
     * @return найденный член семейного дерева, либо null, если член с таким идентификатором не найден
     */
    public E findById(long id) {
        for (E member : MemberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    /**
     * Ищет членов семейного дерева по их имени.
     *
     * @param name имя для поиска
     * @return список членов семейного дерева с заданным именем
     */
    public List<E> findByName(String name) {
        List<E> res = new ArrayList<>();
        for (E member : MemberList) {
            if (member.getName().equalsIgnoreCase(name)) {
                res.add(member);
            }
        }
        return res;
    }

    /**
     * Проверяет, существует ли член семейного дерева с заданным идентификатором.
     *
     * @param id идентификатор для проверки
     * @return true, если член с таким идентификатором существует, иначе false
     */
    public boolean checkById(int id) {
        return MemberList.contains(findById(id));
    }

    /**
     * Возвращает информацию о семейном дереве в виде строки.
     *
     * @return строковое представление семейного дерева
     */
    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Members in family: ");
        sb.append(MemberList.size() + "\n\n------------\nThey are:\n\n");
        for (E member : MemberList) {
            sb.append(member);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }

    /**
     * Возвращает строковое представление семейного дерева.
     *
     * @return строковое представление семейного дерева
     */
    @Override
    public String toString() {
        return getAboutFamily();
    }

    /**
     * Возвращает итератор для обхода членов семейного дерева.
     *
     * @return итератор для семейного дерева
     */
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(MemberList);
    }

    /**
     * Сортирует членов семейного дерева по возрасту.
     */
    public void sortByAge() {
        MemberList.sort(new ComparatorByAge<>());
    }

    /**
     * Сортирует членов семейного дерева по имени.
     */
    public void sortByName() {
        MemberList.sort(new ComparatorByName<>());
    }

}
