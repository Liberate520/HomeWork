import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// ����� ������ ������� �����������?

abstract class Tree implements FamiliesI{
    // � ������ ������ ���� ����������� �����
    static List<Human> humanList = new ArrayList<>();
    static List<Animal> animalList = new ArrayList<>();
//    List<Human<Link>> links;


    //����� ������ ����� ������
    public Tree() {
    }


    public static List<Human> getHumanList() {
        return humanList;
    }
    public static Human getHumanList(int i) {
        return humanList.get(i);
    }


    // ��������� �������� � ������
    @Override
    public void addTree(FamiliesI person) {
        if(person instanceof Human)
            this.humanList.add((Human) person);
        if(person instanceof Animal)
            this.animalList.add((Animal) person);
    }
    public void addTree() {
        this.addTree(this);
    }

    @Override
    public void printTree() {

        //���� ������ ������
        int max = 0;
        for (FamiliesI person : Tree.getHumanList()) {
            for (Link link : person.getLink()){

            }
        }

    }



}
