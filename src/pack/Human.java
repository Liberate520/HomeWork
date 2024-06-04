package pack;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static List<HumanObserver> observers = new ArrayList<>();
    private static short idCounter = 0; // Статический счетчик для ID

    public static void addObserver(HumanObserver observer) {
        observers.add(observer);
    }

    public static void removeObserver(HumanObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (HumanObserver observer : observers) {
            observer.onHumanCreated(this);
        }
    }

    private short id;
    private String name;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private List<Human> children = new ArrayList<>();
    private Human mother, father;
    private Human spouse;

    public Human() {}

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.id = ++idCounter; // Присвоение уникального ID
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        notifyObservers();
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.id = ++idCounter; // Присвоение уникального ID
        this.name = name;
        if (isValidBirthDate(birthDate)) {
            this.birthDate = birthDate;
        } else {
            System.out.println("Некорректная дата рождения");
        }
        this.gender = gender;
        if (isValidDeathDate(deathDate, birthDate)) {
            this.deathDate = deathDate;
        } else {
            System.out.println("Некорректная дата смерти");
        }
        notifyObservers();
    }

    private boolean isValidBirthDate(LocalDate birthDate) {
        return birthDate != null && birthDate.getYear() <= LocalDate.now().getYear();
    }

    private boolean isValidDeathDate(LocalDate deathDate, LocalDate birthDate) {
        return deathDate != null && deathDate.getYear() <= LocalDate.now().getYear() && deathDate.getYear() > birthDate.getYear();
    }

    private double calculateAge() {
        if (this.deathDate != null)
            return deathDate.getYear() - birthDate.getYear();
        else
            return LocalDate.now().getYear() - birthDate.getYear();
    }

    public double getAge() {
        return this.calculateAge();
    }

    public void setDeathDate(LocalDate deathDate) {
        if (isValidDeathDate(deathDate, this.birthDate)) {
            this.deathDate = deathDate;
            System.out.println("Человек умер и его возраст: " + this.calculateAge());
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

    public String getInfo() {
        String motherName = (this.mother != null) ? this.mother.name : "Неизвестно";
        String fatherName = (this.father != null) ? this.father.name : "Неизвестно";
        String info = "Id - " + this.id + "\nИмя - " + this.name + "\nПол - " + this.gender + "\nДети: \n";
        for (Human child : children) {
            info += child.name + "\n";
        }
        info += "Братья: \n";
        for (Human human : this.getBrothers())
            info += human.name + "\n";
        info += "Сёстры: \n";
        for (Human human : this.getSisters())
            info += human.name + "\n";
        info += "Мать - " + motherName + "\nОтец - " + fatherName + "\nВозраст - " + this.calculateAge() + "\n----------------------------------";
        return info;
    }

    public List<Human> getChildren() {
        return this.children;
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
        for (Human child : spouse.children) {
            this.addChild(child);
        }
    }

    public void setDivorce() {
        if (this.spouse != null) {
            for (Human human : this.spouse.children) {
                this.removeChild(human);
            }
            this.spouse = null;
        }
    }

    public double getId() {
        return this.id;
    }

    public List<Human> getBrothers() {
        List<Human> brothers = new ArrayList<>();
        if (this.mother != null) {
            for (Human human : this.mother.children) {
                if (human.gender == Gender.Male && this != human) {
                    brothers.add(human);
                }
            }
        } else if (this.father != null) {
            for (Human human : this.father.children) {
                if (human.gender == Gender.Male && this != human) {
                    brothers.add(human);
                }
            }

        }
        return brothers;
    }

    public List<Human> getSisters() {
        List<Human> sisters = new ArrayList<>();
        if (this.mother != null) {
            for (Human human : this.mother.children) {
                if (human.gender == Gender.Female && this != human) {
                    sisters.add(human);
                }
            }
        } else if (this.father != null) {
            for (Human human : this.father.children) {
                if (human.gender == Gender.Female && this != human) {
                    sisters.add(human);
                }
            }
        }
        return sisters;
    }
}
