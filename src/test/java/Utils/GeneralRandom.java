package Utils;

import java.util.Random;

public class GeneralRandom {
    Random rand = new Random();

    public String RandomEmail(){

        return "MisDior" + rand.nextInt(1000) + "gmail.com";
    }
}
