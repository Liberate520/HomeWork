package pack;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Human {
    private String name;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private List<Human> children = new ArrayList<>();
    private Human mother, father;
    private short age;
    private static final LocalDate currentDate = LocalDate.now();
    private static Family_Tree familyTree = new Family_Tree();
    private Human spouse;


    public Human(){}


    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = calculateAge(birthDate, currentDate);
        familyTree.addHumanToFamilyTree(this);
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        if (isValidBirthDate(birthDate)) {
            this.birthDate = birthDate;
        } else {
            System.out.println("Некорректная дата рождения");
        }
        this.gender = gender;
        if (isValidDeathDate(deathDate, birthDate)) {
            this.deathDate = deathDate;
            this.age = calculateAge(birthDate, deathDate);
        } else {
            System.out.println("Некорректная дата смерти");
            this.age = calculateAge(birthDate, currentDate);
            familyTree.addHumanToFamilyTree(this);
        }
    }

    private boolean isValidBirthDate(LocalDate birthDate) {
        return birthDate != null && birthDate.getYear() <= currentDate.getYear();
    }

    private boolean isValidDeathDate(LocalDate deathDate, LocalDate birthDate) {
        return deathDate != null && deathDate.getYear() <= currentDate.getYear() && deathDate.getYear() > birthDate.getYear();
    }

    private short calculateAge(LocalDate birthDate, LocalDate endDate) {
        return (short) (endDate.getYear() - birthDate.getYear());
    }

    public short getAge() {
        System.out.println("Возраст человека: " + this.age);
        return this.age;
    }

    public void setDeathDate(LocalDate deathDate) {
        if (isValidDeathDate(deathDate, this.birthDate)) {
            this.deathDate = deathDate;
            this.age = calculateAge(this.birthDate, deathDate);
            System.out.println("Человек умер и его возраст: " + this.age);
        } else {
            System.out.println("Некорректная дата смерти");
        }
    }

    public void addMother(Human mother) {
        if (this.mother != mother) {
            removeMother();
            this.mother = mother;
            if (mother != null) {
                mother.addChild(this);
            }
        }
    }

    public void addFather(Human father) {
        if (this.father != father) {
            removeFather();
            this.father = father;
            if (father != null) {
                father.addChild(this);
            }
        }
    }

    public void removeMother() {
        if (this.mother != null) {
            this.mother.removeChild(this);
            this.mother = null;
        }
    }

    public void removeFather() {
        if (this.father != null) {
            this.father.removeChild(this);
            this.father = null;
        }
    }

    public void addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            if (this.gender == Gender.Male)
                child.addFather(this);
            else
                child.addMother(this);
        }
    }

    public void removeChild(Human child) {
        this.children.remove(child);
    }

    public void getInfo() {
        String motherName = (this.mother != null) ? this.mother.name : "Неизвестно";
        String fatherName = (this.father != null) ? this.father.name : "Неизвестно";
        String info = "Id - " + familyTree.getId(this) + "\nИмя - " + this.name + "\nПол - " + this.gender + "\nДети: \n";
        for (Human child : children) {
            info += child.name + "\n";
        }
        info += "Мать - " + motherName + "\nОтец - " + fatherName + "\nВозраст - " + this.age + "\n----------------------------------";
        System.out.println(info);
    }

    public void  getChildren() {
        for (Human child : children) {
            System.out.println(child.name);
        }
    }

    public Human getFather() {
        return this.father;
    }

    public Human getMother() {
        return this.mother;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getName() {
        return this.name;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        for (Human child : this.children) {
            spouse.addChild(child);
        }
        for (Human child : spouse.children){
            this.addChild(child);
        }
    }

    public short getId(){
        return (short) familyTree.getId(this);
    }

    public void printFamilyTree() {
        for (Human human : familyTree.getFamilyTree()) {
            human.getInfo();
        }
    }


    public void getBrothers() {
        String info = "";
        if (this.mother != null) {
            for (Human human : this.mother.children) {
                if (human.gender == Gender.Male && this != human) {
                    info += human.name + "\n";
                }
            }
        } else if (this.father != null) {
            for (Human human : this.father.children) {
                if (human.gender == Gender.Male && this != human) {
                    info += human.name + "\n";
                }
            }

        }
        info += "\n-----------------------";
        System.out.println("Братья " + this.name + ": \n" + info);
    }


    public void getSisters() {
        String info = "";
        if (this.mother != null) {
            for (Human human : this.mother.children) {
                if (human.gender == Gender.Female && this != human) {
                    info += human.name + "\n";
                }
            }
        } else if (this.father != null) {
            for (Human human : this.father.children) {
                if (human.gender == Gender.Female && this != human) {
                    info += human.name + "\n";
                }
            }

        }
        info += "\n-----------------------";
        System.out.println("Сёстры " + this.name + ": \n" + info);
    }



}



