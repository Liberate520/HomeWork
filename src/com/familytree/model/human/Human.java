package com.familytree.model.human;

import com.familytree.model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

    public class Human implements TreeNode,Serializable {
        private long id;
        private String name;
        private Gender gender;
        private LocalDate birthDate;
        private LocalDate deathDate;
        private List<Human> parents;
        private List<Human> children;
        private Human spouse;

        public Human(String name, Gender gender, LocalDate birthDate) {
            this(name, gender, birthDate, null);
        }

        public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
            this.name = name;
            this.gender = gender;
            this.birthDate = birthDate;
            this.deathDate = deathDate;
            this.parents = new ArrayList<>();
            this.children = new ArrayList<>();
        }

        public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
            this(name, gender, birthDate);
            if (father != null) {
                this.parents.add(father);
                father.addChild(this);
            }
            if (mother != null) {
                this.parents.add(mother);
                mother.addChild(this);
            }
        }

        public Human(String name, LocalDate birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }




        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public LocalDate getDeathDate() {
            return deathDate;
        }

        public List<Human> getParents() {
            return parents;
        }

        public List<Human> getChildren() {
            return children;
        }

        public Human getSpouse() {
            return spouse;
        }

        @Override
        public void setSpouse(TreeNode spouse) {

        }

        @Override
        public void addParent(TreeNode parent) {

        }

        @Override
        public void addChild(TreeNode child) {

        }

        public void setSpouse(Human spouse) {
            this.spouse = spouse;
        }

        public void addParent(Human parent) {
            if (!parents.contains(parent)) {
                parents.add(parent);
            }
        }

        public void addChild(Human child) {
            if (!children.contains(child)) {
                children.add(child);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(id)
                    .append(", имя: ").append(name)
                    .append(", пол: ").append(gender)
                    .append(", возраст: ").append(getAge())
                    .append(deathDate != null ? " (умер)" : "")
                    .append(", супруг(а): ").append(spouse != null ? spouse.getName() : "нет")
                    .append(", мать: ").append(parents.stream().anyMatch(p -> p.getGender() == Gender.Female) ?
                            getParentNameByGender(Gender.Female) : "неизвестна")
                    .append(", отец: ").append(parents.stream().anyMatch(p -> p.getGender() == Gender.Male) ?
                            getParentNameByGender(Gender.Male) : "неизвестен")
                    .append(", дети: ").append(children.isEmpty() ? "отсутствуют" : getChildrenNames());
            return sb.toString();
        }

        private int getAge() {
            LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
            return birthDate.until(endDate).getYears();
        }

        private String getParentNameByGender(Gender gender) {
            return parents.stream()
                    .filter(p -> p.getGender() == gender)
                    .map(Human::getName)
                    .findFirst()
                    .orElse("неизвестен");
        }

        private String getChildrenNames() {
            StringBuilder sb = new StringBuilder();
            for (Human child : children) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(child.getName());
            }
            return sb.toString();
        }

    }


