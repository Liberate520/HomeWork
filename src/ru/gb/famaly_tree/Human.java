package ru.gb.famaly_tree;

import java.time.LocalDate;
import java.util.List;
import java.time.Period;

public class Human {
        private String name;
        private LocalDate birthDate;
        private LocalDate deathDate;
        Human mother, father;
        List<Human> children;
        Gender gender;
        boolean isHeLive = false;

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
                if (children == null){
                        this.children = null;
                }
                else{
                        this.children = children;
                }
        }

        public String Age(){
                Period period = Period.between(birthDate, deathDate);
                return "" + period.getYears();

        }
}