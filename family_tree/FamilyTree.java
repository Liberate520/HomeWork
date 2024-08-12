package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import places.*;

public class FamilyTree<E extends FamilyTreeItem<E>, P extends PlaceItem<P>> implements Serializable, Iterable<E> {
        private long humansID;
        private List<E> humanList;
        private List<P> placeList;

        public FamilyTree() {
                this(new ArrayList<>(), new ArrayList<>());
        }

        public FamilyTree(List<E> humanList) {
                this(humanList, new ArrayList<>());
        }

        public FamilyTree(List<E> humanList, List<P> placeList) {
                this.humanList = humanList;
                this.placeList = placeList;
        }

        public boolean addHuman(E human) {
                if (human == null) {
                        return false;
                }
                if (!humanList.contains(human)) {
                        human.setId(humansID++);
                        humanList.add(human);
                        addToParents(human);
                        addToChildren(human);
                        return true;
                }
                return false;
        }

        public boolean addPlace(P place) {
                if (place == null) {
                        return false;
                }
                if (!placeList.contains(place)) {
                        placeList.add(place);
                        return true;
                }
                return false;
        }

        private void addToParents(E human) {
                for (E parent : human.getParents()) {
                        parent.addChild(human);
                }
        }

        private void addToChildren(E human) {
                if (human.getChildren() == null) {
                        human.setChildren(new ArrayList<>());
                }
                for (E child : human.getChildren()) {
                        child.addParent(human);
                }
        }

        public List<E> getSiblings(int ID) {
                E human = getHumanByID(ID);
                if (human == null) {
                        return null;
                }
                List<E> siblings = new ArrayList<>();
                for (E parent : human.getParents()) {
                        for (E child : parent.getChildren()) {
                                if (!child.equals(human)) {
                                        siblings.add(child);
                                }
                        }
                }
                return siblings;
        }

        public List<E> getByName(String firstName, String lastName) {
                List<E> result = new ArrayList<>();
                for (E human : humanList) {
                        if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)) {
                                result.add(human);
                        }
                }
                return result;
        }

        public boolean setWeeding(long humanID1, long humanID2) {
                if (checkID(humanID1) && checkID(humanID2)) {
                        E human1 = getHumanByID(humanID1);
                        E human2 = getHumanByID(humanID2);
                        return setWeeding(humanID1, humanID2);
                }
                return false;
        }

        public boolean setWeeding(E human1, E human2) {
                if (human1.getSpouse() == null && human2.getSpouse() == null) {
                        human1.setSpouse(human2);
                        human2.setSpouse(human1);
                        return true;
                }
                return false;
        }

        public boolean setDivorce(long humanID1, long humanID2) {
                if (checkID(humanID1) && checkID(humanID2)) {
                        E human1 = getHumanByID(humanID1);
                        E human2 = getHumanByID(humanID2);
                        return setDivorce(human1, human2);
                }
                return false;
        }

        public boolean setDivorce(E human1, E human2) {
                if (human1.getSpouse() == human2 && human2.getSpouse() == human1) {
                        human1.setSpouse(null);
                        human2.setSpouse(null);
                        return true;
                }
                return false;
        }

        public boolean checkID(long ID) {
                return ID < humansID && ID >= 0;
        }

        public boolean remove(long humansID) {
                if (checkID(humansID)) {
                        E human = getHumanByID(humansID);
                        if (human != null) {
                                return humanList.remove(human);

                        }

                }
                return false;
        }

        public E getHumanByID(long ID) {
                for (E human : humanList) {
                        if (human.getId() == ID) {
                                return human;
                        }
                }
                return null;
        }

        @Override
        public String toString() {
                return getInfo();
        }

        public String getInfo() {
                StringBuilder sb = new StringBuilder();
                sb.append("В дереве ");
                sb.append(humanList.size());
                sb.append(" человек:\n");
                for (E human : humanList) {
                        sb.append(human.getInfo());
                        sb.append("\n");
                }
                return sb.toString();
        }

        @Override
        public Iterator<E> iterator() {
                return new HumanIterator<>(humanList);
        }

        public void sortByLastName() {
                Collections.sort(humanList, new HumanComparatorByLastName<>());
        }

        public void sortByBirthDate() {
                Collections.sort(humanList, new HumanComparatorByBirthDate<>());
        }

}