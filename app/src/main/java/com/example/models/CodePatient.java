package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodePatient {
    public static String createCode(String phoneNumber){
        String codeRandom = "";
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        codeRandom += "MP-";
        Random random = new Random();
        int upperbound_digit = phoneNumber.length() - 1;
        int upperbound_letter = letter.length() - 1;
        int count = 0;
        int random_index_digit;
        int radom_index_letter;
        String digitChar;
        String letterChar;
        List<Integer> numbers = new ArrayList<>();
        while (count < phoneNumber.length() - 3){
            random_index_digit = random.nextInt(upperbound_digit);
            radom_index_letter = random.nextInt(upperbound_letter);
            if(!numbers.contains(random_index_digit)){
                numbers.add(random_index_digit);
                count++;
                digitChar = phoneNumber.substring(random_index_digit, random_index_digit+1);
                letterChar = letter.substring(radom_index_letter, radom_index_letter+1);
                phoneNumber = phoneNumber.replace(digitChar, letterChar);
            }
        }
        codeRandom += phoneNumber;
        return codeRandom;
    }
}
