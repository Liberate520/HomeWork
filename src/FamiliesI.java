import java.util.List;

/*
�� ��� ���� ����������
 */
public interface FamiliesI {
    // � �������� � ���� ������ ����� ��� ����� � ������
    public void addTree(FamiliesI person);

    public void addTree();

    public void printTree();

    public int getGender();

    public void addLink(Link link);

    public List<Link> getLink();
    public Link getLink(int i);

//    public void addLink();
}
