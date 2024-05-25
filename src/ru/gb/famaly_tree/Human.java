package ru.gb.famaly_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;
import java.util.stream.Stream;

public class Human {
        private String name;
        private LocalDate birthDate;
        private LocalDate deathDate;
        Human mother, father;
        List<Human> children = new ArrayList<>();
        private Gender gender;
        boolean isHeLive = false;


        public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
                this.name = name;
                this.gender = gender;
                this.birthDate = birthDate;
                if (deathDate == null){
                        isHeLive = true;
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
                        isHeLive = true;
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
        public String getBirthDate(){
                return "" + birthDate;
        }
        public String getDeathDate(){
                if (isHeLive == true){
                        return "жив на данный момент";
                }
                else{
                        return "" + deathDate;
                }
        }
        public String getGender(){
                return gender.toString();
        }
        public String getFather(){
                if (this.father != null) {
                        return father.name;
                }
                else{
                        return "нет";
                }
        }
        public String getMother(){
                if (this.mother != null) {
                        return mother.name;
                }
                else{
                        return "нет";
                }
        }
        public List<Human> getChildren(){

                return children;
        }
        public String Age(){
                Period period = Period.between(birthDate, deathDate);
                return "" + period.getYears();

        }
}