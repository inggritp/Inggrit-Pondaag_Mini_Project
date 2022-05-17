package Utils;

import java.util.Random;
public class General {

    Random num = new Random();

    public String randomNumForEmail(String email){
        return "rosieposie" + num.nextInt(100) + "@gmail.com";
    }


}
