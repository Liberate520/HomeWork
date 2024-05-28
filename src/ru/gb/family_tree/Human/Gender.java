package ru.gb.family_tree.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum Gender {
    Male, Female;

    public static class Human implements Serializable {
        private static final long serialVersionUID = 1L;

        private String lastName;
        private String name;
        private Human mother, father; // ссылка на другой объект, т.е. связи между родственниками
        private List<Human> children;
        private LocalDate birthDate, deathDate;
        private Gender gender; // перечисление вариантов через запятую

        public Human(String lastName, String name, Gender gender, LocalDate birthDate) {
            this.lastName =  lastName;
            this.name = name;
            this.gender = gender;
            this.birthDate = birthDate;
            this.children = new ArrayList<>();
        }

        public void setParents(Human mother, Human father) {
            this.mother = mother;
            this.father = father;
        }

        public void addChild(Human child) {
            this.children.add(child);
            if (this.gender == Female) {
                child.setMother(this);
            } else {
                child.setFather(this);
            }
        }

        private void setMother(Human mother) {
            this.mother = mother;
        }

        private void setFather(Human father) {
            this.father = father;
        }

        public String getName() {
            return name;
        }

        public List<Human> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "lastName: " + lastName +
                    " name: " + name +
                    ", mother: " + (mother != null ? mother.getName() : "null") +
                    ", father: " + (father != null ? father.getName() : "null") +
                    ", children: " + children.stream().map(Human::getName).collect(Collectors.toList()) +
                    ", birthDate: " + birthDate +
                    ", deathDate: " + deathDate +
                    ", gender: " + gender +
                    '}';
        }

    }
}
