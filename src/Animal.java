/*
��� ����� �������� ��� ��� ����� ����������� � �����
 */
abstract class Animal extends Tree {
    // �������� ������ ���� ���, ���� ���, �� ����� �� ���������
    private String name;
    // � ��������� ���� ��� (�����, ������, ������, ������) (� ���� ������� �����)

    // ������, ��� ��� ��� �������� �����
    private Human keeper;

    private int gender = 0;

    public Animal(String name, Human keeper) {
        this.name = name;
        this.keeper = keeper;
    }

    @Override
    public int getGender() {
        return gender;
    }
}
