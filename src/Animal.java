/*
��� ����� �������� ��� ��� ����� ����������� � �����
 */
abstract class Animal implements FamiliesI {
    // �������� ������ ���� ���, ���� ���, �� ����� �� ���������
    private String name;
    // � ��������� ���� ��� (�����, ������, ������, ������) (� ���� ������� �����)

    // ������, ��� ��� ��� �������� �����
    private Human keeper;

    public Animal(String name, Human keeper) {
        this.name = name;
        this.keeper = keeper;
    }

    @Override
    public void addTree(Tree tree) {
        tree.addTree(this);
    }
}
