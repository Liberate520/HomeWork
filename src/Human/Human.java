package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

 public class Human implements Serializable {

     private String name;
     private Gender gender;
     private LocalDate birthDate;
     private LocalDate deathDate;
     public List<Human> parents;
     public List<Human> children;

     public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
         this.name = name;
         this.gender = gender;
         this.birthDate = birthDate;
         this.deathDate = deathDate;
         this.parents = new ArrayList<>();
         this.children = new ArrayList<>();
     }

     public String getName() {
         return name;
     }

     public LocalDate getBirthDate() {
         return birthDate;
     }

     public LocalDate getDeathDate() {
         return deathDate;
     }


     public void addParent(Human parent) {
         this.parents.add(parent);
     }

     public void addChild(Human child) {
         this.children.add(child);
     }

     public String toString() {
         return name + " (" + gender + ", родился: " + birthDate + ")";
     }
 }


