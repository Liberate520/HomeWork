package FamilyTree.writer;

import FamilyTree.familyTree.*;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath = "src/FamilyTree/writer/family_tree.dat";

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree load() {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            System.err.println("Файл не существует или недоступен для чтения: " + filePath);
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public FamilyTree load() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            FamilyTree familyTree = (FamilyTree) ois.readObject();
//            Map<Long, Human> membersMap = new HashMap<>();
//            for (Human member : familyTree.getMembers()) {
//                if (membersMap.containsKey(member.getId())) {
//                    member.setId(familyTree.getHumanId());
//                } else {
//                    familyTree.setHumanId(familyTree.getHumanId() + 1);
//                }
//                membersMap.put(member.getId(), member);
//            }
//            for (Human member : familyTree.getMembers()) {
//                if (member.getFather()!= null) {
//                    member.setFather(membersMap.get(member.getFather().getId()));
//                }
//                if (member.getMother()!= null) {
//                    member.setMother(membersMap.get(member.getMother().getId()));
//                }
//                if (member.getSpouse()!= null) {
//                    member.setSpouse(membersMap.get(member.getSpouse().getId()));
//                }
//                List<Human> children = new ArrayList<>();
//                for (Human child : member.getChildren()) {
//                    children.add(membersMap.get(child.getId()));
//                }
//                member.getChildren().clear();
//                member.getChildren().addAll(children);
//            }
//            return familyTree;
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}