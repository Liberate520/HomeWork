package FamilyTree.Model.Tree;

import FamilyTree.Model.ItemTree.Comparator.ComparatorByAge;
import FamilyTree.Model.ItemTree.Comparator.ComparatorByFullName;
import FamilyTree.Model.ItemTree.Person;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фамильное дерево. при создании дерево необходимо указать челловека (персону) для которого будет строится дерево.
 * добавление персоналия в дерево только через установление его родственной связи (родитель, ребенок, супруг)
 */

//TODO убрала ссылку на Human (буду возвращать только строковые данные),
// чтобы не было возможности напрямую вносить изменения. пока не поняла: нужно это делать или нет

public class FamilyTree<E extends Person<E>> implements Serializable, Iterable<E> {
    private final List<E> familyTree;
    private int inn;

    public FamilyTree(E root) {
        this.familyTree = new ArrayList<>();
        this.inn = 0;
        addAllKinInTree(root);
    }

    //region Установка супружеских связей

    public boolean establishMarriage(E first, E second) {
        if (first.getHusband() == null && second.getHusband() == null && first.getGender() != second.getGender()) {
            first.setHusband(second);
            second.setHusband(first);
            addPersonInTree(first);
            addPersonInTree(second);
            return true;
        }
        return false;

    }

    public void establishMarriage(int innFirst, int innSecond) {
        E first = getPersonForINN(innFirst);
        E second = getPersonForINN(innSecond);
        establishMarriage(first, second);
    }

    public void establishMarriage(int innFirst, E second) {
        E first = getPersonForINN(innFirst);
        establishMarriage(first, second);
    }

    //endregion

    //region Установка связей родитель - ребенок

    /**
     * Метод устанавливает родственную связь родитель - ребенок.
     * Метод добавляет в дерево нового участника через родственную связь родитель - ребенок
     *
     * @param parent
     * @param children
     * @return
     */
    private boolean establishPaternity(E parent, E children) {
        if (children.setParent(parent)) {
            parent.addChildren(children);
            addPersonInTree(children);
            addPersonInTree(parent);
            return true;
        }
        return false;
    }

    /**
     * перегруженный метод, установка родительской связи по ИНН
     *
     * @param innParent
     * @param innChildren
     * @return
     */
    public boolean establishPaternity(int innParent, int innChildren) {
        E children = getPersonForINN(innChildren);
        E parent = getPersonForINN(innParent);
        return establishPaternity(parent, children);

    }

    public boolean establishPaternity(int innParent, E children) {
        E parent = getPersonForINN(innParent);
        return establishPaternity(parent, children);
    }

    public boolean establishPaternity(E parent, int innChildren) {
        E children = getPersonForINN(innChildren);
        return establishPaternity(parent, children);
    }


    /**
     * @param inn
     * @param mort
     */
    public void mortRegistration(int inn, LocalDate mort) {
        getPersonForINN(inn).setMortDay(mort);
    }


    //endregion

    //region Getters

    /**
     * вернет список всех людей в дереве
     *
     * @return
     */
    public List<String> getAllFamilyTree() {
        return familyTree.stream()
                .map(e -> e.toString())
                .collect(Collectors.toList());
    }

    /**
     * получение списка детей родителя по инн родителя
     *
     * @param innHuman - инн родителя
     * @return возвращает лист детей
     */
    public List<String> getChildren(int innHuman) {
        List<E> listChildren = familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .collect(Collectors.toList())
                .stream().findFirst().get()
                .getListChildren();
        return listChildren.stream()
                .map(e -> e.toString())
                .collect(Collectors.toList());

    }

    /**
     * возвращает родителей
     *
     * @param innPerson
     * @return
     */
    //TODO возможно нужно разбить на возврат матери и отца отдельно и возвращать строковое представление. пока не решила
    public List<String> getParent(int innPerson) {
        E person = familyTree.stream()
                .filter(e -> e.getInn() == innPerson)
                .collect(Collectors.toList()).get(0);
        List<String> res = new ArrayList<>();
        if (person.getMother() != null) {
            res.add(person.getMother().toString());
        }
        if (person.getFather() != null) {
            res.add(person.getFather().toString());
        }
        return res;
    }

    /**
     * возвращает супруга
     *
     * @param innHuman
     * @return
     */
    public String getHusband(int innHuman) {
        return getPersonForINN(innHuman).getHusband().toString();
    }

    /**
     * возвращает информацию о человеке по инн
     *
     * @param inn - инн
     * @return
     */

    public String getInfo(int inn) {
        return getPersonForINN(inn).toString();
    }

    /**
     * получение члена дерева по инн
     *
     * @param innPerson - инн
     * @return член дерева
     */
    //TODO добавить проверку  и исключение
    private E getPersonForINN(int innPerson) {
        return familyTree.stream()
                .filter(e -> e.getInn() == innPerson)
                .collect(Collectors.toList()).get(0);
    }

    //TODO потом убрать по возможности
    public List<E> getFamilyTree() {
        return familyTree;
    }

    //endregion

    //region Private-Methods

    /**
     * добавление в дерево.
     *
     * @param person
     */
    private boolean addPersonInTree(E person) {
        if (!familyTree.contains(person)) {
            familyTree.add(person);
            person.setInn(++inn);
            return true;
        }
        return false;
    }

    /**
     * если у члена дерева есть родственники - добавит их рекурсивно в дерево.
     *
     * @param person
     */
    //TODO тут могут быть проблемы с дублированием ИНН из-за рекурсии.
    private void addAllKinInTree(E person) {


        if (addPersonInTree(person)) {

            //добавим супруга
            if (person.getHusband() != null) {

                if (addPersonInTree(person.getHusband())) {
                    addAllKinInTree(person.getHusband());
                }
            }
            //добавим родителей
            if (person.getFather() != null) {
                if (addPersonInTree(person.getFather())) {
                    addAllKinInTree(person.getFather());
                }
            }
            if (person.getMother() != null) {
                if (addPersonInTree(person.getMother())) {
                    addAllKinInTree(person.getMother());
                }
            }
            // добавим детей
            if (!person.getListChildren().isEmpty()) {
                person.getListChildren()
                        .forEach(e -> {
                            addPersonInTree(e);
                            addAllKinInTree(e);

                        });
            }
        }
    }

    //endregion

    //region Servise-methods

    /**
     * Метод сортирует членов дерева по полному имени
     */
    public void sortByName() {
        familyTree.sort(new ComparatorByFullName());
    }

    /**
     * Метод сортирует членов дерева по возрасту
     */
    public void sortByAge() {
        familyTree.sort(new ComparatorByAge());
    }


    @Override
    public Iterator<E> iterator() {
        return new TreeIterator(familyTree);
    }

    //endregion
}
