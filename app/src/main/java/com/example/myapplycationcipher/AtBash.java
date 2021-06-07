package com.example.myapplycationcipher;

import java.util.ArrayList;
import java.util.Scanner;

public class AtBash implements shifr{

    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        if (choiceShifr == 1){
            int indexTMP;
            for (char i : text.toCharArray()) {
                if (RU().contains(String.valueOf(i).toUpperCase())) {
                    indexTMP = RU().indexOf(String.valueOf(i).toUpperCase());
                    if (Character.isUpperCase(i))
                        unswer += RU().charAt(RU().length() - indexTMP - 1);
                    else
                        unswer += String.valueOf(RU().charAt(RU().length() - indexTMP - 1)).toLowerCase();
                }
                else if (EN().contains(String.valueOf(i).toUpperCase())) {
                    indexTMP = EN().indexOf(String.valueOf(i).toUpperCase());
                    if (Character.isUpperCase(i))
                        unswer += EN().charAt(EN().length() - indexTMP - 1);
                    else
                        unswer += String.valueOf(EN().charAt(EN().length() - indexTMP - 1)).toLowerCase();
                }
                else if (SIM().contains(String.valueOf(i))) {
                    indexTMP = SIM().indexOf(i);
                    unswer += SIM().charAt(SIM().length() - indexTMP - 1);
                }
                else
                    System.out.println("Ошибка Атбаш 1");
            }
        }
        else {
            int indexTMP;
            for (char i : text.toCharArray()) {
                if (RU().contains(String.valueOf(i).toUpperCase())) {
                    indexTMP = RU().indexOf(String.valueOf(i).toUpperCase());
                    if (Character.isUpperCase(i))
                        unswer += RU().charAt(RU().length() - indexTMP - 1);
                    else
                        unswer += String.valueOf(RU().charAt(RU().length() - indexTMP - 1)).toLowerCase();
                }
                else if (EN().contains(String.valueOf(i).toUpperCase())) {
                    indexTMP = EN().indexOf(String.valueOf(i).toUpperCase());
                    if (Character.isUpperCase(i))
                        unswer += EN().charAt(EN().length() - indexTMP - 1);
                    else
                        unswer += String.valueOf(EN().charAt(EN().length() - indexTMP - 1)).toLowerCase();
                }
                else if (SIM().contains(String.valueOf(i))) {
                    indexTMP = SIM().indexOf(i);
                    unswer += SIM().charAt(SIM().length() - indexTMP - 1);
                }
                else
                    System.out.println("Ошибка Атбаш 0");
            }
        }
        return new String[]{unswer};
    }

    public ArrayList<String> hack(String text, int choiceShifr){
        return null;
    }

}
