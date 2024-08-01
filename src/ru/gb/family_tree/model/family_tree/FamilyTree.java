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
 * Класс FamilyTree представляет собой семейное древо.
 * Он управляет членами семьи и их взаимосвязями.
 *
 * @param <E> тип элемента семейного древа, который должен расширять FamilyTreeElement
 */
public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E> {

    private long MemberId;
    private final List<E> MemberList;

    /**
     * Конструктор создает пустое семейное древо.
     */
    public FamilyTree() {
        this.MemberList = new ArrayList<>();
    }

    /**
     * Добавляет нового члена семьи в древо.
     *
     * @param member новый член семьи
     * @return true, если член семьи был успешно добавлен, иначе false
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
     * Добавляет отношения родитель-ребенок для нового члена семьи.
     *
     * @param member новый член семьи
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
     * Добавляет отношения ребенок-родитель для нового члена семьи.
     *
     * @param member новый член семьи
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
     * Ищет члена семьи по идентификатору.
     *
     * @param id идентификатор члена семьи
     * @return член семьи с данным идентификатором или null, если член не найден
     */
    public E findById(long id) {
        for (E member: MemberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    /**
     * Ищет членов семьи по имени.
     *
     * @param name имя для поиска
     * @return список членов семьи с данным именем
     */
    public List<E> findByName(String name) {
        List<E> res = new ArrayList<>();
        for (E member: MemberList) {
            if (member.getName().equalsIgnoreCase(name)) {
                res.add(member);
            }
        }
        for (E member : res) {
            System.out.println(member);
        }
        return res;
    }

    /**
     * Проверяет наличие члена семьи по идентификатору.
     *
     * @param id идентификатор члена семьи
     * @return true, если член семьи с данным идентификатором существует, иначе false
     */
    public boolean checkById(int id) {
        return MemberList.contains(findById(id));
    }

    /**
     * Возвращает информацию о семейном древе.
     *
     * @return строка с информацией о семейном древе
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
     * Возвращает строковое представление семейного древа.
     *
     * @return строка с информацией о семейном древе
     */
    @Override
    public String toString() {
        return getAboutFamily();
    }

    /**
     * Возвращает итератор для обхода членов семейного древа.
     *
     * @return итератор для обхода членов семейного древа
     */
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(MemberList);
    }

    /**
     * Сортирует членов семьи по возрасту.
     */
    public void sortByAge() {
        MemberList.sort(new ComparatorByAge<>());
    }

    /**
     * Сортирует членов семьи по имени.
     */
    public void sortByName() {
        MemberList.sort(new ComparatorByName<>());
    }

}
