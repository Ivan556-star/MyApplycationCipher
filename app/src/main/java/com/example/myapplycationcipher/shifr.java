package com.example.myapplycationcipher;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public interface shifr {
    Random r = new Random();

    String[] crypt(int choiceShifr, String text, String KEY);
    ArrayList<String> hack(String text, int choiceShifr);
    default String RU(){
        return "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    }

    default String EN(){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    default String SIM(){
        return " !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_{|}~«»№";
    }

    default String MyCopy(int start, int finish, String str){
        String tmpS = "";
        for (int i = start; i < finish; i++)
            tmpS += str.charAt(i);
        return tmpS;
    }

}
