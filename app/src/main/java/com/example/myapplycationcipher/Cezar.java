package com.example.myapplycationcipher;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Cezar implements shifr {
    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        int pos, shifrKey = Integer.parseInt(KEY);
        char[] arrText = text.toCharArray();
        if (choiceShifr == 1) {
            for (char i : arrText) {
                if (RU().contains(String.valueOf(i).toUpperCase())) {
                    pos = RU().indexOf(String.valueOf(i).toUpperCase());
                    if (Character.isUpperCase(i))
                        unswer += RU().charAt(Math.abs(pos + shifrKey) % RU().length());
                    else
                        unswer += String.valueOf(RU().charAt(Math.abs(pos + shifrKey) % RU().length())).toLowerCase();

                } else if (EN().contains(String.valueOf(i).toUpperCase())) {
                    pos = EN().indexOf(String.valueOf(i).toUpperCase());
                    if (Character.isUpperCase(i))
                        unswer += EN().charAt(Math.abs(pos + shifrKey) % EN().length());
                    else
                        unswer += String.valueOf(EN().charAt(Math.abs(pos + shifrKey) % EN().length())).toLowerCase();

                } else if (SIM().contains(String.valueOf(i))) {
                    pos = SIM().indexOf(String.valueOf(i));
                    unswer += SIM().charAt(Math.abs(pos + shifrKey) % SIM().length());
                } else
                    unswer += i;
            }
        } else {
            for (char i : arrText)
                if (RU().contains(String.valueOf(i).toUpperCase())) {
                    pos = RU().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                    if (-pos > RU().length())
                        pos = RU().length() - (-pos % RU().length());
                    if (pos < 0)
                        pos = RU().length() + pos;
                    if (Character.isUpperCase(i))
                        unswer += RU().charAt(pos % RU().length());
                    else
                        unswer += String.valueOf(RU().charAt(pos % RU().length())).toLowerCase();

                } else if (EN().contains(String.valueOf(i).toUpperCase())) {
                    pos = EN().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                    if (-pos > EN().length())
                        pos = EN().length() - (-pos % EN().length());
                    if (pos < 0)
                        pos = EN().length() + pos;
                    if (Character.isUpperCase(i))
                        unswer += EN().charAt(pos % EN().length());
                    else
                        unswer += String.valueOf(EN().charAt(pos % EN().length())).toLowerCase();

                } else if (SIM().contains(String.valueOf(i))) {
                    pos = SIM().indexOf(String.valueOf(i)) - shifrKey;
                    if (-pos > SIM().length())
                        pos = SIM().length() - (-pos % SIM().length());
                    if (pos < 0)
                        pos = SIM().length() + pos;
                    unswer += SIM().charAt(pos % SIM().length());
                } else
                    unswer += i;
        }
        return new String[]{unswer, KEY};
    }

    public ArrayList<String> hack(String text, int choiceShifr) {
        ArrayList<String> unswer = new ArrayList<>();
        int pos, shifrKey = 1;
        char[] arrText = text.toCharArray();
        if (choiceShifr == 1) {
            for (int k = 0; k < RU().length(); k++, shifrKey++) {
                String tmp = "";
                for (char i : arrText)
                    if (RU().contains(String.valueOf(i).toUpperCase())) {
                        pos = RU().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                        if (-pos > RU().length())
                            pos = RU().length() - (-pos % RU().length());
                        if (pos < 0)
                            pos = RU().length() + pos;
                        if (Character.isUpperCase(i))
                            tmp += RU().charAt(pos % RU().length());
                        else
                            tmp += String.valueOf(RU().charAt(pos % RU().length())).toLowerCase();
                    } else
                        tmp += i;
                unswer.add(tmp);
            }

        } else if (choiceShifr == 2) {
            for (int k = 0; k < EN().length(); k++, shifrKey++) {
                String tmp = "";
                for (char i : arrText)
                    if (EN().contains(String.valueOf(i).toUpperCase())) {
                        pos = EN().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                        if (-pos > EN().length())
                            pos = EN().length() - (-pos % EN().length());
                        if (pos < 0)
                            pos = EN().length() + pos;
                        if (Character.isUpperCase(i))
                            tmp += EN().charAt(pos % EN().length());
                        else
                            tmp += String.valueOf(EN().charAt(pos % EN().length())).toLowerCase();
                    } else
                        tmp += i;
                unswer.add(tmp);
            }

        } else {
            for (int k = 0; k < RU().length() + EN().length() + SIM().length(); k++, shifrKey++) {
                String tmp = "";
                for (char i : arrText)
                    if (RU().contains(String.valueOf(i).toUpperCase())) {
                        pos = RU().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                        if (-pos > RU().length())
                            pos = RU().length() - (-pos % RU().length());
                        if (pos < 0)
                            pos = RU().length() + pos;
                        if (Character.isUpperCase(i))
                            tmp += RU().charAt(pos % RU().length());
                        else
                            tmp += String.valueOf(RU().charAt(pos % RU().length())).toLowerCase();

                    } else if (EN().contains(String.valueOf(i).toUpperCase())) {
                        pos = EN().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                        if (-pos > EN().length())
                            pos = EN().length() - (-pos % EN().length());
                        if (pos < 0)
                            pos = EN().length() + pos;
                        if (Character.isUpperCase(i))
                            tmp += EN().charAt(pos % EN().length());
                        else
                            tmp += String.valueOf(EN().charAt(pos % EN().length())).toLowerCase();

                    } else if (SIM().contains(String.valueOf(i).toUpperCase())) {
                        pos = SIM().indexOf(String.valueOf(i).toUpperCase()) - shifrKey;
                        if (-pos > SIM().length())
                            pos = SIM().length() - (-pos % SIM().length());
                        if (pos < 0)
                            pos = SIM().length() + pos;
                        tmp += SIM().charAt(pos % SIM().length());
                    } else
                        System.out.println("Error hack Cezar");

                unswer.add(tmp);
            }
        }
        return unswer;
    }

    

}
