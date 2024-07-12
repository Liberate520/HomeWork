package family_tree;

import human.Human;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;
    private final List<Human> members;
    private LocalDate birthDate;
    private LocalDate deathDate;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human member) {
        members.add(member);
    }

    public void connectSpouses(Human person1, Human person2) {
        person1.setSpouse(person2);
        person2.setSpouse(person1);
    }

    public void connectParents(Human child, Human father, Human mother) {
        child.setFather(father);
        child.setMother(mother);
        father.addChild(child);
        mother.addChild(child);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Tree:\n");

        if (members.isEmpty()) {
            sb.append("Family tree is empty.");
        } else {
            for (Human member : this) {
                sb.append("Name: ").append(member.getName());
                sb.append(", human.Gender: ").append(member.getGender());
                sb.append(", Age: ").append(member.getAge());

                if (member.getSpouse() != null) {
                    sb.append(", Spouse: ").append(member.getSpouse().getName());
                }

                if (member.getFather() != null) {
                    sb.append(", Father: ").append(member.getFather().getName());
                }

                if (member.getMother() != null) {
                    sb.append(", Mother: ").append(member.getMother().getName());
                }

                if (!member.getChildren().isEmpty()) {
                    sb.append(", Children: ");
                    for (Human child : member.getChildren()) {
                        sb.append(child.getName()).append(", ");
                    }
                    sb.delete(sb.length() - 2, sb.length());
                }

                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public void save(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error saving family tree: " + e.getMessage());
        }
    }

    public static FamilyTree load(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading family tree: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(Human::getBirthDate));
    }
}
