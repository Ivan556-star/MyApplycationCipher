package com.example.myapplycationcipher;

import android.renderscript.Script;

import java.util.ArrayList;
import java.util.Scanner;

public class Vijenera implements shifr {

    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        KEY = KEY.toUpperCase();

        if (choiceShifr == 1){
            int k = 0;
            while (KEY.length() < text.length()){
                final String s = String.valueOf(text.charAt(k)).toUpperCase();
                if (RU().contains(s))
                    KEY += RU().charAt(r.nextInt(RU().length()));
                else if (EN().contains(s))
                    KEY += EN().charAt(r.nextInt(EN().length()));
                else if (SIM().contains(String.valueOf(text.charAt(k))))
                    KEY += SIM().charAt(r.nextInt(SIM().length()));
                else KEY += text.charAt(k);
                k++;
            }

            int indexTMP, indexKEY;
            for (int i = 0; i <text.length(); i++) {
                final String s = String.valueOf(text.charAt(i)).toUpperCase();
                if (RU().contains(s)){
                    indexTMP = RU().indexOf(s);
                    indexKEY = RU().indexOf(String.valueOf(KEY.charAt(i)));
                    if (indexKEY == -1) indexKEY = 1;
                    if (indexTMP == -1) indexTMP = 1;
                    if (Character.isUpperCase(text.charAt(i)))
                        unswer += RU().charAt(Math.abs((indexTMP + indexKEY) % RU().length()));
                    else
                        unswer += String.valueOf(RU().charAt(Math.abs((indexTMP + indexKEY) % RU().length()))).toLowerCase();
                }
                else if (EN().contains(s)){
                    indexTMP = EN().indexOf(s);
                    indexKEY = EN().indexOf(String.valueOf(KEY.charAt(i)));
                    if (indexKEY == -1) indexKEY = 1;
                    if (indexTMP == -1) indexTMP = 1;
                    if (Character.isUpperCase(text.charAt(i)))
                        unswer += EN().charAt(Math.abs((indexTMP + indexKEY) % EN().length()));
                    else
                        unswer += String.valueOf(EN().charAt(Math.abs((indexTMP + indexKEY) % EN().length()))).toLowerCase();
                }
                else if (SIM().contains(String.valueOf(text.charAt(i)))){
                    indexTMP = SIM().indexOf(String.valueOf(text.charAt(i)));
                    indexKEY = SIM().indexOf(String.valueOf(KEY.charAt(i)));
                    if (indexKEY == -1) indexKEY = 1;
                    if (indexTMP == -1) indexTMP = 1;
                    unswer += SIM().charAt(Math.abs((indexTMP + indexKEY) % SIM().length()));
                }
                else
                    unswer += text.charAt(i);
            }
        }

        else {

            if (KEY.length() < text.length())
                text = MyCopy(0, KEY.length(), text);
            else if (KEY.length() > text.length())
                KEY = MyCopy(0, KEY.length(), KEY);


            try {
                int indexTMP, indexKEY;
                for (int i = 0; i <text.length(); i++) {
                    final String s = String.valueOf(text.charAt(i)).toUpperCase();
                    if (RU().contains(s)){
                        indexTMP = RU().indexOf(s);
                        indexKEY = RU().indexOf(String.valueOf(KEY.charAt(i)));
                        if (indexKEY == -1) indexKEY = 1;
                        if (indexTMP == -1) indexTMP = 1;
                        if (Character.isUpperCase(text.charAt(i)))
                            unswer += RU().charAt((indexTMP + RU().length() - indexKEY) % RU().length());
                        else
                            unswer += String.valueOf(RU().charAt((indexTMP + RU().length() - indexKEY) % RU().length())).toLowerCase();
                    }
                    else if (EN().contains(s)){
                        indexTMP = EN().indexOf(s);
                        indexKEY = EN().indexOf(String.valueOf(KEY.charAt(i)));
                        if (indexKEY == -1) indexKEY = 1;
                        if (indexTMP == -1) indexTMP = 1;
                        if (Character.isUpperCase(text.charAt(i)))
                            unswer += EN().charAt((indexTMP + EN().length() - indexKEY) % EN().length());
                        else
                            unswer += String.valueOf(EN().charAt((indexTMP + EN().length() - indexKEY) % EN().length())).toLowerCase();
                    }
                    else if (SIM().contains(String.valueOf(text.charAt(i)))){
                        indexTMP = SIM().indexOf(String.valueOf(text.charAt(i)));
                        indexKEY = SIM().indexOf(String.valueOf(KEY.charAt(i)));
                        if (indexKEY == -1) indexKEY = 1;
                        if (indexTMP == -1) indexTMP = 1;
                        unswer += SIM().charAt((indexTMP + SIM().length() - indexKEY) % SIM().length());
                    }
                    else
                        unswer += text.charAt(i);
                }
            }catch (IndexOutOfBoundsException e){
                return new String[]{"Ошибка, вы указали неверный ключ!", KEY};
            }
        }
        return new String[]{unswer, KEY};
    }
    // Oohlr!srrZL"
    // HKWADHWADWAA
    public ArrayList<String> hack(String text, int choiceShifr){
        return null;
    }


}
