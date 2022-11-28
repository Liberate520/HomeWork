import java.util.ArrayList;
import java.util.List;

public class Human implements FamiliesI {
    // �������� ����� ���
    private String fullName;
    // ������ 0=� 1=�
    int gender;
    // � �������� ����� �����
    private List<Link> links;

    public Human(String fullName, int gender) {

        this.fullName = fullName; // ��� ���� ������ � ����������
        this.gender = gender;
        links = new ArrayList<>();
//        this.addHumanList(this);
    }


    // ����������� �������� � ������
    public void addTree(Tree tree) {
        tree.addTree(this);
    }

    //��������� ����� ����� ��� �����
    public void addLink(Link link) {
        this.links.add(link);
    }

    //��������� ����� ����� ����������� ������
    public void addLink(Human second, byte tipeLink) {
        new Link(this, second, tipeLink);
    }

    public List<Link> getAllLinks() {
        return links;
    }
    public Link getLink(int i) {
        return links.get(i);
    }

    public int getGender() {
        return gender;
    }


}
