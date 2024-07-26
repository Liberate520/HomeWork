package zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args){
        List<Speakable> speakables = new ArrayList<>();
        speakables.add(new Cat("Шарли"));
        speakables.add(new Dog("Арти"));
        speakables.add(new Radio());

        NoiseZoo noiseZoo = new NoiseZoo(speakables);
        noiseZoo.speakAll();
    }
}
