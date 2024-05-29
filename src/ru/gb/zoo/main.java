package ru.gb.zoo;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Speakable> speakables = new ArrayList<>();
        speakables.add(new Cat());
        speakables.add(new Dog());
        speakables.add(new Radio());

        NoiseZoo noiseZoo = new NoiseZoo(speakables);
        noiseZoo.speakAll();
    }
}
