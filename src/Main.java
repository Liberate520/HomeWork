import FamillyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Writer.FileOperations;

import java.time.LocalDate;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("�����", Gender.FEMALE, LocalDate.of(1978, 4, 1), null);
        Human human2 = new Human("�������", Gender.MALE, LocalDate.of(2012, 2, 4), null);
        Human human3 = new Human("�������", Gender.FEMALE, LocalDate.of(1959, 8, 16), null);
        Human human4 = new Human("������", Gender.MALE, LocalDate.of(1958, 4, 20), null);
        Human human5 = new Human("���������", Gender.FEMALE, LocalDate.of(1933, 5, 18), LocalDate.of(2012, 7, 30));
        Human human6 = new Human("��������", Gender.MALE, LocalDate.of(1934, 3, 7), LocalDate.of(2012, 7, 30));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);

        familyTree.setParentChildRelationship(human3, human1); // ���� �����
        familyTree.setParentChildRelationship(human4, human1); // ���� �����
        familyTree.setParentChildRelationship(human1, human2); // ���� �������
        familyTree.setParentChildRelationship(human5, human3); // ���� �������
        familyTree.setParentChildRelationship(human6, human3); // ���� �������

        familyTree.printFamilyRelationships();

        FileOperations fileOps = new FileOperations(familyTree);
        try {
            fileOps.save("file.txt");
            System.out.println("���� ��������.");
        } catch (IOException e) {
            e.printStackTrace();

            try {
                fileOps.load("file.txt");
                System.out.println("���� ��������.");

                FamilyTree loadedTree = fileOps.getFamilyTree();
                loadedTree.printFamilyRelationships();
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}