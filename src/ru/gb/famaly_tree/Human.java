package ru.gb.famaly_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;
import java.util.stream.Stream;

public class Human implements Serializable {
        private String name;
        private LocalDate birthDate;
        private LocalDate deathDate;
        private Human mother, father;
        private List<Human> children = new ArrayList<>();
        private Gender gender;
        private boolean isHeLive = false;
        private String childStringOutput;

        public void addMother(Human mother){
                this.mother = mother;
        }

        public void addChild(Human child){
                this.children.add(child);
        }

        public void addFather(Human father){
                this.father = father;
        }

        public void addChildren(List<Human> children){
                this.children = children;
        }


        public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
                this.name = name;
                this.gender = gender;
                this.birthDate = birthDate;
                if (deathDate == null){
                        this.isHeLive = true;
                        this.deathDate = LocalDate.now();
                }
                else{
                        this.deathDate = deathDate;
                }
        }

        public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, List<Human> children){
                this.name = name;
                this.gender = gender;
                this.birthDate = birthDate;
                if (deathDate == null){
                        this.isHeLive = true;
                        this.deathDate = LocalDate.now();
                }
                else{
                        this.deathDate = deathDate;
                }
                if (mother == null){
                        this.mother = null;
                }
                else{
                        this.mother = mother;
                }
                if (father == null){
                        this.father = null;
                }
                else{
                        this.father = father;
                }
                if (children != null){
                        this.children = children;
                }
        }

        public String  getName(){
                return name;
        }

        public LocalDate getBirthDate(){
                return birthDate;
        }

        public LocalDate getDeathDate(){
                return deathDate;
        }

        public boolean deadOrAlive(){
                return isHeLive;
        }

        public Gender getGender(){
                return gender;
        }

        public Human getFather(){
                return father;
        }

        public Human getMother(){
                return mother;
        }

        public List<Human> getChildren(){
                return children;
        }

        public String Age(){
                Period period = Period.between(birthDate, deathDate);
                return "" + period.getYears();
        }

        public String ToString(){
                String outputPersonInfo = "имя: "+ getName()+"\n"+"возраст: "+ Age()+"\n"+"пол: "+getGender()+"\n"+"дата рождения: "+getBirthDate();
                String temporary = "";
                if (deadOrAlive() == true){
                        temporary = "жив на данный момент";
                }
                else{
                        temporary = "дата смерти: "+ getDeathDate();
                }
                outputPersonInfo = outputPersonInfo + "\n" + temporary;
                temporary = "";
                if (getFather() != null){
                        temporary = "имя отца: "+getFather().getName();
                }
                else{
                        temporary = "имя отца: неизвестно";
                }
                outputPersonInfo = outputPersonInfo + "\n" + temporary;
                temporary = "";
                if (getMother() != null){
                        temporary = "имя матери: "+getMother().getName();
                }
                else{
                        temporary = "имя матери: неизвестно";
                }
                outputPersonInfo = outputPersonInfo + "\n" + temporary;
                temporary = "";
                if (!getChildren().isEmpty()){
                        for (Human child : getChildren()){
                                temporary += child.getName()+", ";
                        }
                }
                else{
                        temporary +="нет";
                }
                outputPersonInfo = outputPersonInfo + "\n" + "дети: "+ temporary;
                //System.out.println(outputPersonInfo);
                return outputPersonInfo;
        }
}