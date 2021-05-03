package com.example.myapplycationcipher;

public class Skitalo implements shifr {
    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        text = text.toUpperCase().replace(" ", "_");
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

    public static void main(String[] args) {
        Skitalo cypher = new Skitalo();
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

        System.out.println("Введите текст");
        String text = cin.nextLine();
        String[] unswer = cypher.crypt(choiceShifr, text, "");
        if (choiceShifr == 1)
            System.out.println("Зашифрованный текст\n" +  unswer[0]);
        else
            System.out.println("Расшированный текст\n" +  unswer[0]);
//wad
    }
}
