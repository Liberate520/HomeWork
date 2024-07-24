import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
        private long humansID;
        private List<Human> humanList;

        public FamilyTree() {
                this(new ArrayList<>());
        }

        public FamilyTree(List<Human> humanList) {
                this.humanList = humanList;
        }

        public boolean addHuman(Human human) {
                if (human == null) {
                        return false;
                }
                if (!humanList.contains(human)) {
                        humanList.add(human);
                        human.setId(humansID++);

                        addToParents(human);
                        addToChildren(human);

                        return true;
                }
                return false;
        }

        private void addToParents(Human human) {
                for (Human parent : human.getParents()) {
                        parent.addChild(human);
                }
        }

        private void addToChildren(Human human) {
                for (Human child : human.getChildren()) {
                        child.addParent(human);
                }
        }

        public List<Human> getSiblings(int ID) {
                Human human = getHumanByID(ID);
                if (human == null) {
                        return null;
                }
                List<Human> siblings = new ArrayList<>();
                for (Human parent : human.getParents()) {
                        for (Human child : parent.getChildren()) {
                                if (!child.equals(human)) {
                                        siblings.add(child);
                                }
                        }
                }
                return siblings;
        }

        public List<Human> getByName(String firstName, String lastName) {
                List<Human> result = new ArrayList<>();
                for (Human human : humanList) {
                        if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)) {
                                result.add(human);
                        }
                }
                return result;
        }

        public boolean setWeeding(long humanID1, long humanID2) {
                if (checkID(humanID1) && checkID(humanID2)) {
                        Human human1 = getHumanByID(humanID1);
                        Human human2 = getHumanByID(humanID2);
                        return setWeeding(humanID1, humanID2);
                }
                return false;
        }

        public boolean setWeeding(Human human1, Human human2) {
                if (human1.getSpouse() == null && human2.getSpouse() == null) {
                        human1.setSpouse(human2);
                        human2.setSpouse(human1);
                        return true;
                }
                return false;
        }

        public boolean setDivorce(long humanID1, long humanID2) {
                if (checkID(humanID1) && checkID(humanID2)) {
                        Human human1 = getHumanByID(humanID1);
                        Human human2 = getHumanByID(humanID2);
                        return setDivorce(human1, human2);
                }
                return false;
        }

        public boolean setDivorce(Human human1, Human human2) {
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
                        Human human = getHumanByID(humansID);
                        if (human != null) {
                                return humanList.remove(human);

                        }

                }
                return false;
        }

        public Human getHumanByID(long ID) {
                for (Human human : humanList) {
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
                for (Human human : humanList) {
                        sb.append(human.getInfo());
                        sb.append("\n");
                }
                return sb.toString();
        }

}