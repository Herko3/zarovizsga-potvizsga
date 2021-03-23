package hu.nive.ujratervezes.zarovizsga.words;

import java.util.ArrayList;
import java.util.List;

public class Words {

    public boolean hasMoreDigits(String s){
        List<Character> digits = new ArrayList<>();
        List<Character> notDigits = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                digits.add(c);
            } else {
                notDigits.add(c);
            }
        }

        return digits.size() > notDigits.size();
    }

}
