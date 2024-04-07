package FamilyTree;

import FamilyTree.Comparator.TreeIterator;

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

public class FamilyTree implements Serializable, Iterable<Human> {
    private final List<Human> familyTree;
    private int inn;

    public FamilyTree(Human root) {
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
        Human first = getHumanForINN(innFirst);
        Human second = getHumanForINN(innSecond);
        marriage(first, second);
    }

    /**
     * регистрация брака со сторонним человеком
     *
     * @param innFirst
     * @param second
     */
    public void addHusband(int innFirst, Human second) {
        Human first = getHumanForINN(innFirst);
        marriage(first, second);
    }

    //TODO нужно подумать.
    // Комм(Лучше создавать обоюдные связи, чтобы не было путаницы и было подобие автоматизации)
    // возможно буду переделывать
    public void addChildren(int innParent, Human child) {
        Human parent = getHumanForINN(innParent);
        parent.addChildren(child);
        addHuman(child);
    }

    /**
     * устанвить родителя, если его еще нет в дереве
     *
     * @param innChild
     * @param parent
     */
    public void addParent(int innChild, Human parent) {
        Human child = getHumanForINN(innChild);
        child.setParent(parent);
        addHuman(parent);
    }

    /**
     * установить родителя если он уже есть в дереве
     *
     * @param innChild
     * @param innParent
     */
    public void addParent(int innChild, int innParent) {
        Human child = getHumanForINN(innChild);
        Human parent = getHumanForINN(innParent);
        child.setParent(parent);
    }


    public void mortRegistration(int inn, LocalDate mort) {
        getHumanForINN(inn).setMortDay(mort);
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
        return familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .collect(Collectors.toList())
                .stream().findFirst().get()
                .getChildren().stream()
                .map(e -> e.toString())
                .collect(Collectors.toList());
    }

    /**
     * возвращает родителей
     *
     * @param innHuman
     * @return
     */
    //TODO возможно нужно разбить на возврат матери и отца отдельно и возвращать строковое представление. пока не решила
    public List<String> getParent(int innHuman) {
        Human human = familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .collect(Collectors.toList()).get(0);
        List<String> res = new ArrayList<>();
        if (human.getMother() != null) {
            res.add(human.getMother().toString());
        }
        if (human.getFather() != null) {
            res.add(human.getFather().toString());
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
        return getHumanForINN(innHuman).getHusband().toString();
    }

    /**
     * возвращает информацию о человеке по инн
     *
     * @param inn - инн
     * @return
     */

    public String getInfo(int inn) {
        return getHumanForINN(inn).toString();
    }


    //region Private-Methods

    /**
     * добавление в дерево.
     *
     * @param human
     */
    private boolean addHuman(Human human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            human.setInn(++inn);
            return true;
        }
        return false;
    }

    /**
     * если у human есть родственники - добавит их рекурсивно в дерево.
     *
     * @param human
     */
    //TODO тут могут быть проблемы с дублированием ИНН из-за рекурсии.
    private void addAllKinInTree(Human human) {
        if (addHuman(human)) {
            //добавим супруга
            if (human.getHusband() != null) {
                if (addHuman(human.getHusband())) {
                    addAllKinInTree(human.getHusband());
                }
            }
            //добавим родителей
            if (human.getFather() != null) {
                if (addHuman(human.getFather())) {
                    addAllKinInTree(human.getFather());
                }
            }
            if (human.getMother() != null) {
                if (addHuman(human.getMother())) {
                    addAllKinInTree(human.getMother());
                }
            }
            // добавим детей
            if (!human.getChildren().isEmpty()) {
                human.getChildren()
                        .forEach(e -> {
                            addHuman(e);
                            addAllKinInTree(e);

                        });
            }
        }
    }


    private void marriage(Human first, Human second) {
        if (first.getHusband() == null && second.getHusband() == null && first.getGender() != second.getGender()) {
            first.setHusband(second);
            second.setHusband(first);
//            addHuman(first);
            addHuman(second);
        }
    }

    /**
     * получение human по инн
     *
     * @param innHuman - инн
     * @return human
     */
    //TODO добавить проверку  и исключение
    private Human getHumanForINN(int innHuman) {
        return familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .collect(Collectors.toList()).get(0);
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(familyTree);
    }


//endregion

}
