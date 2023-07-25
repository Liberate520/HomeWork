package homeWork_oop.familytree.main;

import java.util.Scanner;
import homeWork_oop.familytree.model.*;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("�������� ��������:");
            System.out.println("1. �������� ��������");
            System.out.println("2. ��������� � ����");
            System.out.println("3. ��������� �� �����");
            System.out.println("4. ������������� �� �����");
            System.out.println("5. ������������� �� ��������");
            System.out.println("6. ������� �����");
            System.out.println("0. ��� ������ �� ���������");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Person person = new Person();
                    System.out.println("������� ���:");
                    person.setFirstName(scanner.next());
                    System.out.println("������� �������:");
                    person.setLastName(scanner.next());
                    System.out.println("������� ���� �������� � ������� 2016-08-16:");
                    person.setBirthday (scanner.next());
                    System.out.println("������� ��� ����:");
                    person.setFatherFirstName(scanner.next());
                    System.out.println("������� ������� ����:");
                    person.setFatherLastName(scanner.next());
                    System.out.println("������� ��� ������:");
                    person.setMotherFirstName(scanner.next());

                    System.out.println("������� ������� ������:");
                    person.setMotherLastName(scanner.next());
                    familyTree.addPerson(person);
                    break;

                case 2:
                    System.out.println("������� ��� �����:");
                    String filename = scanner.next();
                    familyTree.saveToFile(filename);
                    break;

                case 3:
                    System.out.println("������� ��� �����:");
                    filename = scanner.next();
                    familyTree.loadFromFile(filename);
                    break;

                case 4:
                    familyTree.sortByName();
                    break;

                case 5:
                    familyTree.sortByAge();
                    break;

                case 6:
                    System.out.println("������� ���:");
                    String firstName = scanner.next();
                    System.out.println("������� �������:");
                    String lastName = scanner.next();
                    familyTree.printChildren(firstName, lastName);
                    break;
                case 0:
                    System.exit(0);
                        break;

                default:
                    System.out.println("�������� �����");
                    break;
            }
        }
    }
}
