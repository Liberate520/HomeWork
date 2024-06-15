package oop_home.my_familyTree;

import java.util.ArrayList;
import java.util.List;

public class Parents extends Human {
        private String father;
        private String mother;

        private List<Human> parentsList;

        public Parents(String surname, String name, String patronymic, int age, String gender, String father,
                        String mother) {
        super(surname, name, patronymic, age, gender);
        this.father = father;
        this.mother = mother;
        parentsList = new ArrayList<>(parentsList);{
        if(!parentsList.contains(father)){
                parentsList.add(null);
        }
        if(mother!=null){
                parentsList.add(null);
        }
        }
        }
        
        public boolean addParent(Human parent) {
        if (!parentsList.contains(parent)) {
                parentsList.add(parent);
                return true;
        }
                return false;
        }


        public String getFather() {
                return father;
        }

        public void setFather(String father) {
                this.father = father;
        }

        public String getMother() {
                return mother;
        }

        public void setMother(String mother) {
                this.mother = mother;
        }

        
        }


