package ru.gb.zoo;

import java.util.List;

public class NoiseZoo {
    private List<Speakable> speakables;

    public NoiseZoo(List<Speakable> speakables) {
        this.speakables = speakables;
    }

    public void addSpeakable(Speakable speakable){
        this.speakables.add(speakable);
    }

    public void speakAll(){
        for (Speakable speakable : speakables) {
            speakable.speak();
        }
    }
}
