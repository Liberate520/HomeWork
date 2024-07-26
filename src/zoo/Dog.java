package zoo;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public void speak(){
        System.out.println("гав-гав");
    }
}
