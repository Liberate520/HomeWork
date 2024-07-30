package FamilyTree.familyTree;

import FamilyTree.human.Human;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humanId;
    private List<Human> members;

    private static final long serialVersionUID = 1L;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(members);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        members = (List<Human>) ois.readObject();
    }

    public boolean addMember(Human human) {
        if (human == null) {
            return false;
        }
        for (Human member : members) {
            if (member.equals(human)) {
                human = member;
                break;
            }
        }
        if (!members.contains(human)) {
            members.add(human);
            human.setId(humanId++);
            if (human.getFather() != null && members.contains(human.getFather())) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null && members.contains(human.getMother())) {
                human.getMother().addChild(human);
            }
            // Обновить семейное дерево с учетом новых отношений члена семьи
            updateFamilyTree(human);
            return true;
        }
        return true;
    }

    private void updateFamilyTree(Human human) {
        // Обновить родственные отношения
        if (human.getFather() != null) {
            human.getFather().addChild(human);
            // Обновить отношения дедушки и бабушки
            if (human.getFather().getFather() != null) {
                human.getFather().getFather().addGrandchild(human);
            }
            if (human.getFather().getMother() != null) {
                human.getFather().getMother().addGrandchild(human);
            }
        }
        if (human.getMother() != null) {
            human.getMother().addChild(human);
            // Обновить отношения дедушки и бабушки
            if (human.getMother().getFather() != null) {
                human.getMother().getFather().addGrandchild(human);
            }
            if (human.getMother().getMother() != null) {
                human.getMother().getMother().addGrandchild(human);
            }
        }
        // Обновить отношения супругов
        if (human.getSpouse() != null) {
            human.getSpouse().setSpouse(human);
        }
        // Обновить семейное дерево с учетом нового имени члена семьи
        human.setName(human.getName());
    }
//    public boolean addMember(Human human) {
//        if (human == null) {
//            return false;
//        }
//        Human existingMember = getMemberById(human.getId());
//        if (existingMember != null) {
//            existingMember.setName(human.getName());
//            existingMember.setBirthDate(human.getBirthDate());
//            existingMember.setDeathDate(human.getDeathDate());
//            existingMember.setGender(human.getGender());
//            existingMember.setOccupation(human.getOccupation());
//            existingMember.setNationality(human.getNationality());
//            existingMember.setPlaceOfBirth(human.getPlaceOfBirth());
//            existingMember.setFather(getMemberById(human.getFather().getId()));
//            existingMember.setMother(getMemberById(human.getMother().getId()));
//            existingMember.setSpouse(getMemberById(human.getSpouse().getId()));
//            existingMember.getChildren().clear();
//            for (Human child : human.getChildren()) {
//                existingMember.addChild(getMemberById(child.getId()));
//            }
//            return true;
//        } else {
//            human.setId(humanId++);
//            members.add(human);
//            if (human.getFather() != null && members.contains(human.getFather())) {
//                human.getFather().addChild(human);
//            }
//            if (human.getMother() != null && members.contains(human.getMother())) {
//                human.getMother().addChild(human);
//            }
//            return true;
//        }
//    }

    public List<Human> getMembers() {
        return members;
    }

    public Human getMemberById(long id) {
        for (Human member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public Human getMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    public List<Human> getSiblings(Human person) {
        List<Human> siblings = new ArrayList<>();
        if (person.getFather() != null) {
            for (Human child : person.getFather().getChildren()) {
                if (!child.equals(person)) {
                    siblings.add(child);
                }
            }
        }
        if (person.getMother() != null) {
            for (Human child : person.getMother().getChildren()) {
                if (!child.equals(person) && !siblings.contains(child)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public Human getSpouse(Human person) {
        return person.getSpouse();
    }

    public List<Human> getAncestors(Human person) {
        List<Human> ancestors = new ArrayList<>();
        if (person.getFather() != null) {
            ancestors.add(person.getFather());
            ancestors.addAll(getAncestors(person.getFather()));
        }
        if (person.getMother() != null) {
            ancestors.add(person.getMother());
            ancestors.addAll(getAncestors(person.getMother()));
        }
        return ancestors;
    }

    public long getHumanId() {
        return humanId;
    }

    public void setHumanId(long humanId) {
        this.humanId = humanId;
    }

    // Дополнительные методы для исследования добавлю позже здесь
}