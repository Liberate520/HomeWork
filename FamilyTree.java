package OOP.SemDZ.homeWork;

public class FamilyTree {
    public int idCount=0;

    public void add (Human human){
        idCount++;
        human.setId(idCount);
    }

    public void wedding (Human groom, Human bride){
        groom.setSpouse(bride);
        bride.setSpouse(groom);
    }

       
}
