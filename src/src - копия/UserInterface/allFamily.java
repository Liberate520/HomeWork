package UserInterface;
import Tree.Family;
import Tree.Human;
import Tree.Serializator;

import java.util.ArrayList;
import java.util.List;

public class allFamily implements Option{
    Serializator ser = new Serializator();




    @Override
    public String description() {
        return "���������� �������� �����";
    }

    @Override
    public void execute() {


        System.out.println("���������.........");
        System.out.println(ser.deserialization());





    }
}
