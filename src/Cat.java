import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal{

    private List<Link> links;

    public Cat(String name, Human keeper) {
        super(name, keeper);
        links = new ArrayList<>();
    }


    //��������� ����� ����� ��� �����
    public void addLink(Link link) {
        this.links.add(link);
    }

    //��������� ����� ����� ����������� ������
    public void addLink(Human second, int tipeLink) {
        new Link(this, second, tipeLink);
    }
    public List<Link> getLink() {
        return links;
    }
    public Link getLink(int i) {
        return links.get(i);
    }
}
