package familytree;

import human.Human;

import java.util.ArrayList;

public class FamilyTree {
        private ArrayList<Human> peopleList = new ArrayList<>();

        public void printParents(Human human){
            System.out.printf("%s's parents: %s and %s.\n", human.getName(), human.getParents().get(0).getName(), human.getParents().get(1).getName());
        }

        public void printPeopleList(){
            for (Human human:peopleList) {
                System.out.println(human);
            }
        }
        public ArrayList<Human> getPeopleList() {
            return peopleList;
        }

        public void setPeopleList(ArrayList<Human> peopleList) {
            this.peopleList = peopleList;
        }

        public void printChildren(Human human){
                System.out.printf("%s's kids: \n", human.getName());
                for (Human h: human.getAmountOfChildren()) {
                    System.out.println(h.getName()+";");
                }
            System.out.println();
        }
    }
