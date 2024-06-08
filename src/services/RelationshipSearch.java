package services;

import models.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для поиска родственных связей между людьми в генеалогическом древе.
 */
public class RelationshipSearch {

    /**
     * Возвращает список братьев и сестер человека.
     *
     * @param human Человек, для которого нужно найти братьев и сестер.
     * @return Список братьев и сестер.
     */
    public static List<Human> findSiblings(Human human) {
        List<Human> siblings = new ArrayList<>();
        for (Human mother : human.getMothers()) {
            siblings.addAll(mother.getChildren());
        }
        for (Human father : human.getFathers()) {
            siblings.addAll(father.getChildren());
        }
        siblings.remove(human);
        return siblings;
    }

    /**
     * Возвращает список дядей и тетей человека.
     *
     * @param human Человек, для которого нужно найти дядей и тетей.
     * @return Список дядей и тетей.
     */
    public static List<Human> findAuntsAndUncles(Human human) {
        List<Human> auntsAndUncles = new ArrayList<>();
        for (Human mother : human.getMothers()) {
            auntsAndUncles.addAll(findSiblings(mother));
        }
        for (Human father : human.getFathers()) {
            auntsAndUncles.addAll(findSiblings(father));
        }
        return auntsAndUncles;
    }

    /**
     * Возвращает список двоюродных братьев и сестер человека.
     *
     * @param human Человек, для которого нужно найти двоюродных братьев и сестер.
     * @return Список двоюродных братьев и сестер.
     */
    public static List<Human> findCousinsSiblings(Human human) {
        List<Human> cousins = new ArrayList<>();
        for (Human aunt : findAuntsAndUncles(human)) {
            cousins.addAll(aunt.getChildren());
        }
        for (Human uncle : findAuntsAndUncles(human)) {
            cousins.addAll(uncle.getChildren());
        }
        cousins.removeAll(findSiblings(human));
        return cousins;
    }
}
