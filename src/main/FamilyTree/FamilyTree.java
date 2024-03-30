package FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO уберу ссылку на Human в дальнейшем буду возвращать только строковые данные,
// чтобы не было возможности напрямую вносить изменения. пока не поняла: нужно это делать или нет

public class FamilyTree {
    private final List<Human> familyTree;
    private int inn;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
        this.inn = 0;
    }

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
    public void addAllKinInTree(Human human) {
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

    /**
     * вернет список всех людей в дереве
     *
     * @return
     */
    public List<Human> getAllFamilyTree() {
        return familyTree;
    }


    /**
     * регистрация брака
     *
     * @param innFirst  - инн партнера
     * @param innSecond - инн партнера
     * @return успешность операции
     */
    public void marriageRegistration(int innFirst, int innSecond) {
        Human first = getHumanForINN(innFirst);
        Human second = getHumanForINN(innSecond);
        marriage(first, second);
    }

    public void marriageRegistration(Human first, int innSecond) {
        Human second = getHumanForINN(innSecond);
        marriage(first, second);
    }

    public void marriageRegistration(Human first, Human second) {
        marriage(first, second);
    }

    private void marriage(Human first, Human second) {
        if (first.getHusband() == null && second.getHusband() == null && first.getGender() != second.getGender()) {

            first.setHusband(second);
            second.setHusband(first);
            addHuman(first);
            addHuman(second);

        }
    }

    public void mortRegistration(int inn, LocalDate mort) {
        getHumanForINN(inn).setMortDay(mort);
    }

    /**
     * получение human по инн
     *
     * @param innHuman - инн
     * @return human
     */
    //TODO добавить исключение если ИНН такого нет???
    private Human getHumanForINN(int innHuman) {
        return familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .toList().get(0);
    }

    /**
     * получение списка детей родителя по инн родителя
     *
     * @param innHuman - инн родителя
     * @return возвращает лист детей
     */
    public List<Human> getChildren(int innHuman) {
        return familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .toList().get(0)
                .getChildren();
    }

    /**
     * возвращает родителей
     *
     * @param innHuman
     * @return
     */
    //TODO возможно нужно разбить на возврат матери и отца отдельно
    public List<Human> getParent(int innHuman) {
        Human human = familyTree.stream()
                .filter(e -> e.getInn() == innHuman)
                .toList().get(0);
        List<Human> res = new ArrayList<>();
        if (human.getMother() != null) {
            res.add(human.getMother());
        }
        if (human.getFather() != null) {
            res.add(human.getFather());
        }
        return res;
    }

    public String getHusband(int innHuman) {
        return getHumanForINN(innHuman).getHusband().toString();
    }

}
