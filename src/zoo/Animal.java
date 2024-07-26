package zoo;

public abstract class Animal implements Speakable{
    String name;
    public Animal (String name){
       this.name = name;
    }

    public String getName(){
        return name;
    }
}
