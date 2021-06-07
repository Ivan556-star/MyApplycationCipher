package com.example.myapplycationcipher;

public class Cezar implements shifr {
    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        int pos, shifrKey = Integer.parseInt(KEY);
        char[] arrText = text.replace(" ", "_").toUpperCase().toCharArray();
        if (choiceShifr == 1) {
            for (char i : arrText) {
                if (RU().contains(String.valueOf(i))) {
                    pos = RU().indexOf(String.valueOf(i));
                    unswer += RU().charAt(Math.abs(pos + shifrKey) % RU().length());
                } else if (EN().contains(String.valueOf(i))) {
                    pos = EN().indexOf(String.valueOf(i));
                    unswer += EN().charAt(Math.abs(pos + shifrKey) % EN().length());
                } else if (SIM().contains(String.valueOf(i))) {
                    pos = SIM().indexOf(String.valueOf(i));
                    unswer += SIM().charAt(Math.abs(pos + shifrKey) % SIM().length());
                } else
                    System.out.println("Error Cypher Cezar");
            }
        }
        else {
            for (char i : arrText) {
                if (RU().contains(String.valueOf(i))) {
                    pos = RU().indexOf(String.valueOf(i)) - shifrKey;
                    if (-pos > RU().length())
                        pos = RU().length() - (-pos % RU().length());
                    if (pos < 0)
                        pos = RU().length() + pos;
                    unswer += RU().charAt(pos % RU().length());

                } else if (EN().contains(String.valueOf(i))) {
                    pos = EN().indexOf(String.valueOf(i)) - shifrKey;
                    if (-pos > EN().length())
                        pos = EN().length() - (-pos % EN().length());
                    if (pos < 0)
                        pos = EN().length() + pos;
                    unswer += EN().charAt(pos % EN().length());

                } else if (SIM().contains(String.valueOf(i))) {
                    pos = SIM().indexOf(String.valueOf(i)) - shifrKey;
                    if (-pos > SIM().length())
                        pos = SIM().length() - (-pos % SIM().length());
                    if (pos < 0)
                        pos = SIM().length() + pos;
                    unswer += SIM().charAt(pos % SIM().length());
                } else
                    System.out.println("Error DeCypher Cezar");
            }
        }
        return new String[]{unswer, KEY};
    }

}
