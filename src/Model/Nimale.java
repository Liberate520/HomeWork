package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Nimale
{
    private String name;
    private String sex;
    private int age;
    private Nimale mather;
    private Nimale father;
    private List<Nimale> children;
    public Nimale(String name, String sex, int age, Nimale mather, Nimale father)
    {

        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mather = mather;
        this.father = father;
        children = new ArrayList<>();
    }

    public Nimale(String name, String sex, int age)
    {
        this(name, sex, age, null,null); // �������� �����������!
    }

    public void addChild(Nimale child)
    {
        if (!children.contains(child))
        {
            this.children.add(child);
            if(this.sex == "���.")
            {
                child.father = this;
            }
            else child.mather = this;
        }
    }

    public String printChildren()
    {
        String res = " ����: ";
        if (!this.children.isEmpty())
        {
            for (int i = 0; i < children.size(); i++)
            {
                res += children.get(i).name + ",";
            }
        }
        else res += " ���";
        return res;
    }

    @Override
    public String toString()
    {
        String res = "���: " + name +  ",\t ���: " + sex + ", �������: " + age;
        if (this.mather != null)
        {
            res += ", ����: " + mather.name;
        }
        else res += ", ����: ����������";

        if (this.father != null)
        {
            res += ", ����: " + father.name + ",";
        }
        else res += ", ����: ����������,";

        res += printChildren();

        return res;

    }

    public String getName()
    {
        return name;
    }

    public Nimale getFather()
    {
        return father;
    }

    public Nimale getMather()
    {
        return mather;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

}