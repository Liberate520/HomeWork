package FamilyTree.Tree;

import FamilyTree.ItemTree.Comparator.ComparatorByAge;
import FamilyTree.ItemTree.Comparator.ComparatorByFullName;
import FamilyTree.ItemTree.Person;

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

    /**
     * регистрация брака, если они уже оба есть в дереве.
     *
     * @param innFirst  - инн партнера
     * @param innSecond - инн партнера
     * @return успешность операции
     */
    public void addHusband(int innFirst, int innSecond) {
        E first = getPersonForINN(innFirst);
        E second = getPersonForINN(innSecond);
        marriage(first, second);
    }

    /**
     * регистрация брака со сторонним человеком
     *
     * @param innFirst
     * @param second
     */
    public void addHusband(int innFirst, E second) {
        E first = getPersonForINN(innFirst);
        marriage(first, second);
    }

    //TODO нужно подумать.
    // Комм(Лучше создавать обоюдные связи, чтобы не было путаницы и было подобие автоматизации)
    // возможно буду переделывать
    public void addChildren(int innParent, E child) {
        E parent = getPersonForINN(innParent);
        parent.addChildren(child);
        addPerson(child);
    }

    /**
     * устанвить родителя, если его еще нет в дереве
     *
     * @param innChild
     * @param parent
     */
    public void addParent(int innChild, E parent) {
        E child = getPersonForINN(innChild);
        child.setParent(parent);
        addPerson(parent);
    }

    /**
     * установить родителя если он уже есть в дереве
     *
     * @param innChild
     * @param innParent
     */
    public void addParent(int innChild, int innParent) {
        E child = getPersonForINN(innChild);
        E parent = getPersonForINN(innParent);
        child.setParent(parent);
    }


    public void mortRegistration(int inn, LocalDate mort) {
        getPersonForINN(inn).setMortDay(mort);
    }


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


    //region Private-Methods

    /**
     * добавление в дерево.
     *
     * @param person
     */
    private boolean addPerson(E person) {
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


        if (addPerson(person)) {

            //добавим супруга
            if (person.getHusband() != null) {

                if (addPerson(person.getHusband())) {
                    addAllKinInTree(person.getHusband());
                }
            }
            //добавим родителей
            if (person.getFather() != null) {
                if (addPerson(person.getFather())) {
                    addAllKinInTree(person.getFather());
                }
            }
            if (person.getMother() != null) {
                if (addPerson(person.getMother())) {
                    addAllKinInTree(person.getMother());
                }
            }
            // добавим детей
            if (!person.getListChildren().isEmpty()) {
                person.getListChildren()
                        .forEach(e -> {
                            addPerson(e);
                            addAllKinInTree(e);

                        });
            }
        }
    }


    private void marriage(E first, E second) {
        if (first.getHusband() == null && second.getHusband() == null && first.getGender() != second.getGender()) {
            first.setHusband(second);
            second.setHusband(first);
//            addPerson(first);
            addPerson(second);
        }
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
    //endregion

    //TODO потом убрать по возможности
    public List<E> getFamilyTree() {
        return familyTree;
    }

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
}
