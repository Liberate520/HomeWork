package model.family_tree;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import model.human.Human;
import model.places.Place;

// Применяем SRP: Класс FamilyTree теперь отвечает только за управление деревом.
public class FamilyTree<E extends FamilyTreeItem<E>, P extends Place> implements Serializable {
        private long humansID;
        private long placesID;
        private List<E> humanList;
        private List<P> placeList;

        public FamilyTree() {
                this.humanList = new ArrayList<>();
                this.placeList = new ArrayList<>();
        }

        public boolean addHuman(E human) {
                if (!humanList.contains(human)) {
                        human.setId(humansID++);
                        humanList.add(human);
                        return true;
                }
                return false;
        }

        public boolean addPlace(P place) {
                if (!placeList.contains(place)) {
                        place.setId(placesID++);
                        placeList.add(place);
                        return true;
                }
                return false;
        }

        public E getHumanByID(long id) {
                return humanList.stream()
                                .filter(human -> human.getId() == id)
                                .findFirst()
                                .orElse(null);
        }

        public P getPlaceByID(long id) {
                return placeList.stream()
                                .filter(place -> place.getId() == id)
                                .findFirst()
                                .orElse(null);
        }

        public boolean addBirthPlace(long humanID, long placeID) {
                E human = getHumanByID(humanID);
                P place = getPlaceByID(placeID);
                if (human != null && place != null) {
                        ((Human) human).setBirthPlace((Place) place);
                        return true;
                }
                return false;
        }

        public List<E> getHumanList() {
                return humanList;
        }

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder("В дереве ");
                sb.append(humanList.size()).append(" человек:\n");
                for (E human : humanList) {
                        sb.append(human.getInfo()).append("\n");
                }

                sb.append("\nМеста:\n");
                if (placeList.isEmpty()) {
                        sb.append("Мест нет.\n");
                } else {
                        for (P place : placeList) {
                                sb.append(place.getInfo()).append("\n");
                        }
                }

                return sb.toString();
        }
}
