package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        /*
        familyTree - ���� ������ ����� � ������������ ���������,
        � ��� ������ ���� ����� ArrayList, �.�. ������ �� �����
         */
        FamilyTree familyTree = new FamilyTree();

        //������� ������� human � ������� ��������� � familyTree
        Human human1 = new Human("������ ���� ��������", Gender.Male, LocalDate.of(1984, 12, 31));
        familyTree.addHuman(human1);

        Human human2 = new Human("������ ���� ��������", Gender.Male, LocalDate.of(1976, 06, 11));
        familyTree.addHuman(human2);

        Human human3 = new Human("������� ����� ���������", Gender.Male, LocalDate.of(1964, 01, 16));
        familyTree.addHuman(human3);

        Human human4 = new Human("���������� �������� ������������", Gender.Male, LocalDate.of(1949, 12, 3), LocalDate.of(2000, 07, 9));
        familyTree.addHuman(human4);

        Human human5 = new Human("�������� ����� �����������", Gender.Male, LocalDate.of(1952, 04, 26));
        familyTree.addHuman(human5);

        //������� ���������
        human2.setFather(human4);
        human2.setMother(human5);


        //������� ��������� �����
        System.out.println(familyTree);

        //��������� � FamilyTree
        System.out.println("����� ����� �������: " + Human.getCounter());


    }
}
