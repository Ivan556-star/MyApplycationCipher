package com.example.myapplycationcipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Skitalo implements shifr {
    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        int rows = 0, cols = 0;
        //⁣
        if (text.length() < Integer.parseInt(KEY))
                KEY = Integer.toString(r.nextInt(text.length()));
        if (text.length() % Integer.parseInt(KEY) != 0) {
            rows = text.length() / Integer.parseInt(KEY) + 1;
            cols = Integer.parseInt(KEY);
        }else {
            rows = text.length() / Integer.parseInt(KEY);
            cols = Integer.parseInt(KEY);
        }
        if (choiceShifr == 1){
            char[][] arr = new char[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    arr[i][j] = '\u2063';

            for (int i = 0, k = 0; i < rows; i++) {
                if (k == text.length())
                    break;
                for (int j = 0; j < cols; j++, k++) {
                    if (k == text.length())
                         break;
                    arr[i][j] = text.charAt(k);
                }
            }

            for (int i = 0, k = 0; i < cols; i++)
                for (int j = 0; j < rows; j++, k++)
                        unswer += arr[j][i];
        }
        else {
            char[][] arr = new char[cols][rows];

            for (int i = 0; i < cols; i++)
                for (int j = 0; j < rows; j++)
                    arr[i][j] = '\u2063';

            for (int i = 0, k = 0; i < cols; i++) {
                if (k == text.length())
                    break;
                for (int j = 0; j < rows; j++, k++) {
                    if (k == text.length())
                        break;
                    arr[i][j] = text.charAt(k);
                }
            }

            for (int i = 0, k = 0; i < rows; i++)
                for (int j = 0; j < cols; j++, k++)
                        unswer += arr[j][i];
        }
        return new String[]{unswer, KEY};
    }

    public ArrayList<String> hack(String text, int choiceShifr) {
        ArrayList<String > unswer = new ArrayList<>();
        int rows = 0, cols = 0;
        for (int q = 0, KEY = 1; q < text.length(); q++, KEY++) {
            if (text.length() % KEY != 0) {
                rows = text.length() / KEY + 1;
                cols = KEY;
            }else {
                rows = text.length() / KEY;
                cols = KEY;
            }
            char[][] arr = new char[cols][rows];

            for (int i = 0; i < cols; i++)
                for (int j = 0; j < rows; j++)
                    arr[i][j] = '\u2063';

            for (int i = 0, k = 0; i < cols; i++) {
                if (k == text.length())
                    break;
                for (int j = 0; j < rows; j++, k++) {
                    if (k == text.length())
                        break;
                    arr[i][j] = text.charAt(k);
                }
            }
            String tmpS = "";
            for (int i = 0, k = 0; i < rows; i++)
                for (int j = 0; j < cols; j++, k++)
                        tmpS += arr[j][i];

            unswer.add(tmpS);
        }
        return unswer;
    }
}
