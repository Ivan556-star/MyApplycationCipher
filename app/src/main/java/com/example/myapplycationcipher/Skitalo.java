package com.example.myapplycationcipher;

import java.util.ArrayList;
import java.util.Scanner;

public class Skitalo implements shifr {
    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        if (text.length() % 2 != 0) text += ".";

        if (choiceShifr == 1){
            char[][] arr = new char[text.length() / 2][2];

            for (int i = 0, k = 0; i < text.length() / 2; i++)
                for (int j = 0; j < 2; j++, k++)
                    arr[i][j] = text.charAt(k);



            for (int i = 0, k = 0; i < 2; i++)
                for (int j = 0; j < text.length() / 2; j++, k++)
                    unswer += arr[j][i];

        }
        else {
            char[][] arr = new char[text.length() / 2][2];

            for (int i = 0, k = 0; i < 2; i++)
                for (int j = 0; j < text.length() / 2; j++, k++)
                    arr[j][i] = text.charAt(k);



            for (int i = 0, k = 0; i < text.length() / 2; i++)
                for (int j = 0; j < 2; j++, k++)
                    unswer += arr[i][j];


        }
        return new String[]{unswer, KEY};
    }

    public ArrayList<String> hack(String text, int choiceShifr){
        return null;
    }

}
