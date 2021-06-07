package com.example.myapplycationcipher;

public class Vijenera implements shifr {

    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        text = text.toUpperCase().replace(" ", "_");
        KEY = KEY.toUpperCase().replace(" ", "_");

        if (choiceShifr == 1){
            int k = 0;
            while (KEY.length() < text.length()){
                if (RU().contains(String.valueOf(text.charAt(k)))){
                    KEY += RU().charAt(r.nextInt(RU().length()));
                }
                if (EN().contains(String.valueOf(text.charAt(k)))){
                    KEY += EN().charAt(r.nextInt(EN().length()));
                }
                if (SIM().contains(String.valueOf(text.charAt(k)))){
                    KEY += SIM().charAt(r.nextInt(SIM().length()));
                }
                k++;
            }

            int indexTMP, indexKEY;
            for (int i = 0; i <text.length(); i++) {
                if (RU().contains(String.valueOf(text.charAt(i)))){
                    indexTMP = RU().indexOf(String.valueOf(text.charAt(i)));
                    indexKEY = RU().indexOf(String.valueOf(KEY.charAt(i)));
                    unswer += RU().charAt(Math.abs((indexTMP + indexKEY) % RU().length()));
                }
                else if (EN().contains(String.valueOf(text.charAt(i)))){
                    indexTMP = EN().indexOf(String.valueOf(text.charAt(i)));
                    indexKEY = EN().indexOf(String.valueOf(KEY.charAt(i)));
                    unswer += EN().charAt(Math.abs((indexTMP + indexKEY) % EN().length()));
                }
                else if (SIM().contains(String.valueOf(text.charAt(i)))){
                    indexTMP = SIM().indexOf(String.valueOf(text.charAt(i)));
                    indexKEY = SIM().indexOf(String.valueOf(KEY.charAt(i)));
                    unswer += SIM().charAt(Math.abs((indexTMP + indexKEY) % SIM().length()));
                }
                else
                    System.out.println("Error VIjener");
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
                    if (RU().contains(String.valueOf(text.charAt(i)))){
                        indexTMP = RU().indexOf(String.valueOf(text.charAt(i)));
                        indexKEY = RU().indexOf(String.valueOf(KEY.charAt(i)));
                        unswer += RU().charAt((indexTMP + RU().length() - indexKEY) % RU().length());
                    }
                    else if (EN().contains(String.valueOf(text.charAt(i)))){
                        indexTMP = EN().indexOf(String.valueOf(text.charAt(i)));
                        indexKEY = EN().indexOf(String.valueOf(KEY.charAt(i)));
                        unswer += EN().charAt((indexTMP + EN().length() - indexKEY) % EN().length());
                    }
                    else if (SIM().contains(String.valueOf(text.charAt(i)))){
                        indexTMP = SIM().indexOf(String.valueOf(text.charAt(i)));
                        indexKEY = SIM().indexOf(String.valueOf(KEY.charAt(i)));
                        unswer += SIM().charAt((indexTMP + SIM().length() - indexKEY) % SIM().length());
                    }
                    else
                        System.out.println("Ошибка, вы ввели символ, которого нет в стандартной клавиатуре");
                }
            }catch (IndexOutOfBoundsException e){
                return new String[]{"Ошибка, вы указали неверный ключ!", KEY};
            }
        }
        return new String[]{unswer, KEY};
    }

}
