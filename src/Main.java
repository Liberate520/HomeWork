//�����������, � ������ ��� �������, ����������.
//        ��� ���������� ������������ � ��������������� ������.
//        ����: ������� ��������� ���������� ���������, ��������:
//        ������ ��������
//        ���������� �������� ������ � ��������� ����� ������: ��������, ������ - ��������, �� ����� �������� � ��� ���������, ����, ��������, ������ � �. �.
//        ��������� ��� ���������� ������������
//        �������������� ����������, �������� ���������� �� ����� ������ � �������, �������� � ���������� � ����, ���������\���������� ��������� ������� ��������
//        ��� ������������ ������������� ����� �������� ��������� ���� ����� ���������� ��������.
//
//        ������� PR � �������: https://github.com/Liberate520/homeWork

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lis = new ArrayList<String>();
//        lis.get(1);

        // ����� ������� ��������
        Human HA = new Human("name 1", 0); // ����
        Human HB = new Human("name 2", 1); // ���
        Human HC = new Human("name 3", 0); // ����
        Human HD = new Human("name 4", 1); // ���
        Human HE = new Human("name 5", 0); // ������� ����
        Human HF = new Human("name 6", 1); // ������� ����
        Human HG = new Human("name 5", 0); // ������� ����
        Human HH = new Human("name 6", 1); // ������� ����

        // ������� ��������� � ������
        // ������ ������

        //<editor-fold desc="Description">
        HA.addTree();
        HB.addTree();
        HC.addTree();
        HD.addTree();
        HE.addTree();
        HF.addTree();
        HG.addTree();
        HH.addTree();
        //</editor-fold>

        System.out.println(Tree.getHumanList());


        //region Description
        new Link(HA, HB, 300);
        new Link(HA, HC, 800);
        new Link(HA, HD, 800);
        new Link(HA, HE, 900);
        new Link(HA, HF, 900);

        HB.addLink(HC, 801);
        HB.addLink(HD, 801);
        HB.addLink(HG, 901);
        HB.addLink(HH, 901);

        HC.addLink(HD, 300);
        HC.addLink(HE, 1000);
        HC.addLink(HF, 1000);
        HC.addLink(HG, 1000);
        HC.addLink(HH, 1000);

        HD.addLink(HE, 1001);
        HD.addLink(HF, 1001);
        HD.addLink(HG, 1001);
        HD.addLink(HH, 1001);

        HE.addLink(HF, 300);
        HG.addLink(HH, 300);
        //endregion


        System.out.println(Tree.getHumanList(0).getLink());
        System.out.println(Tree.getHumanList(0).getLink(0).getFirst() + " -> " + Tree.getHumanList(0).getLink(0).getSecond());
        System.out.println(Tree.getHumanList(1).getLink());
        System.out.println(Tree.getHumanList(1).getLink(0).getFirst() + " -> " + Tree.getHumanList(1).getLink(0).getSecond());


        Cat cat = new Cat("����", HC);

/*
        // ���������� � ������
        tree.addTree(new Human("name 3", 0));
        tree.addTree(new Human("name 4", 1)); // ���
        System.out.println(tree.getHumanList());

        HA.addTree(tree);
        HB.addTree(tree);

        System.out.println(tree.getHumanList());

        // ��������� �����

        new Link(tree.getHumanList(1), tree.getHumanList(2), 12);

        System.out.println(tree.getHumanList(1).getAllLinks());
        System.out.println(tree.getHumanList(1).getLink(0).getFirst() + " -> " + tree.getHumanList(1).getLink(0).getSecond());
        System.out.println(tree.getHumanList(2).getAllLinks());
        System.out.println(tree.getHumanList(2).getLink(0).getFirst() + " -> " + tree.getHumanList(2).getLink(0).getSecond());
*/

    }


}
