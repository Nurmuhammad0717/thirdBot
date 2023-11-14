package uz.pdp.bot;

import java.util.regex.Pattern;

public class Checker {
    public static Boolean checkEmail(String username){
        return Pattern.matches(".+@\\w+\\.\\w+",username);
    }
}
