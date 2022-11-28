import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ����� ������ ������� �����������?

public class Tree {
    // � ������ ������ ���� ����������� �����
    List<Human> humanList;
    List<Animal> animalList;
//    List<Human<Link>> links;


    //����� ������ ����� ������
    public Tree() {
        this.humanList = new ArrayList<>();
    }


    public List<Human> getHumanList() {
        return humanList;
    }
    public Human getHumanList(int i) {
        return humanList.get(i);
    }

    // ��������� �������� � ������
    public void addTree(FamiliesI person) {
        if(person instanceof Human)
            this.humanList.add((Human) person);
        if(person instanceof Animal)
            this.animalList.add((Animal) person);

    }

}
