public class Main {

    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("�������", "�������");
        Human human2 = new Human("�������", "�������");
        Human human3 = new Human("�����", "�������", human1, human2);
        Human human4 = new Human("����", "�������");
        Human human5 = new Human("�����", "�������", human4, human3);
        Human human6 = new Human("������", "�������", human4, human3);
        Human human7 = new Human("����", "�������", human4, human3);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        System.out.println("��� ��������������� ������: ");
        System.out.println(familyTree);

        System.out.println("����� �� ����� �����: ");
        System.out.println(familyTree.getHumanByName("�����"));
    }
}
