package module.lesson2.familytree;

import module.lesson2.human.Human;
import module.lesson2.sortHuman.HumanCompareSortByAge;
import module.lesson2.sortHuman.HumanCompareSortByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Creature<Human>> implements Iterable<E>{
        private List<E> creatureList = new ArrayList<>();

        public void printParents(E creature){
            System.out.printf("%s's parents: %s and %s.\n", creature.getName(), creature.getParents().get(0).getName(), creature.getParents().get(1).getName());
        }

        public void printPeopleList(){
            for (E creature:creatureList) {
                System.out.println(creature);
            }
        }
        public List<E> getPeopleList() {
            return creatureList;
        }

        public void setPeopleList(ArrayList<E> peopleList) {
            this.creatureList = peopleList;
        }

        public void addPeople(E e){
            creatureList.add(e);
        }
        public void printChildren(Human human){
                System.out.printf("%s's kids: \n", human.getName());
                for (Human hm: human.getAmountOfChildren()) {
                    System.out.println(hm.getName()+";");
                }
            System.out.println();
        }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(creatureList);
    }
    public void sortByAge(List<Human> newHumanList){
        creatureList.sort(new HumanCompareSortByAge<>());
    }
    public void sortByName(List<Human> newHumanList){
        creatureList.sort(new HumanCompareSortByName<>());
    }
}
