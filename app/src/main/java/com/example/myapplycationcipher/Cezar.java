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

    public static void main(String[] args) {
        Cezar cypher = new Cezar();
        int choiceShifr;
        while (true)
            try {
                System.out.print("Зашифровать(1)/расшифровать(0): ");
                String choiceShifrIn = cin.nextLine();
                choiceShifr = Integer.parseInt(choiceShifrIn);
                if (choiceShifr < 0 || choiceShifr > 1) {
                    System.out.println("Ошибка, введите 1 или 0");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка, введите 1 или 0");
            }

        String KEY;
        while (true) {
            boolean lolOk = true;
            try {
                System.out.print("Введите ключ: ");
                KEY = cin.nextLine();
                for (int i : KEY.toCharArray())
                    if (!Character.isDigit(i)) {
                        System.out.println("Ошибка, положительное целое число");
                        lolOk = false;
                        break;
                    }
                if (lolOk)
                    break;
            } catch (Exception e) {
                System.out.println("Ошибка, положительное целое число");
            }
        }
        System.out.println("Введите текст");
        String text = cin.nextLine();
        String[] unswer = cypher.crypt(choiceShifr, text, KEY);
        if (choiceShifr == 1)
            System.out.println("Зашифрованный текст\n" +  unswer[0] +
                    "\nКлюч от шифра: " + unswer[1]);
        else
            System.out.println("Расшированный текст\n" +  unswer[0] +
                    "\nКлюч от шифра: " + unswer[1]);

    }
}
