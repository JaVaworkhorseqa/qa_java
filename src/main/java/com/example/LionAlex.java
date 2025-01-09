package com.example;

import java.util.List;

public class LionAlex extends Lionn {

    public LionAlex() throws Exception {
        super("Самец");
    }

    public List<String> getFriends(){
        return List.of("Марти", "Мелман", "Глория", "Практикум");
    }
    public String getPlaceOfLiving() {
        return ("Нью-Йоркский зоопарк");
    }
    @Override
    public int getKittens() {
        return 0;
    }
}
