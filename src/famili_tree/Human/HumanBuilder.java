package Human;

public class HumanBuilder  {


    public Human humanBuild (String name, String familiya, String pol, String birthDate ){
        Human human=new Human (name, familiya, pol, birthDate);
        return human;
    }
}
