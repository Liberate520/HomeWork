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
        Human HB = new Human("name 2", 1);
        // ������� ��������� � ������
        // ������ ������
        Tree tree = new Tree();
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


    }


}
