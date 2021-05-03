package com.example.myapplycationcipher;

public class AtBash implements shifr{

    @Override
    public String[] crypt(int choiceShifr, String text, String KEY) {
        String unswer = "";
        text = text.toUpperCase().replace(" ", "_");

        if (choiceShifr == 1){
            int indexTMP;
            for (char i : text.toCharArray()) {
                if (RU().contains(String.valueOf(i))) {
                    indexTMP = RU().indexOf(i);
                    unswer += RU().charAt(RU().length() - indexTMP - 1);
                }
                else if (EN().contains(String.valueOf(i))) {
                    indexTMP = EN().indexOf(i);
                    unswer += EN().charAt(EN().length() - indexTMP - 1);
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
                if (RU().contains(String.valueOf(i))) {
                    indexTMP = RU().indexOf(i);
                    unswer += RU().charAt(RU().length() - indexTMP - 1);
                }
                else if (EN().contains(String.valueOf(i))) {
                    indexTMP = EN().indexOf(i);
                    unswer += EN().charAt(EN().length() - indexTMP - 1);
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

    public static void main(String[] args) {
        AtBash cypher = new AtBash();
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

    }


}
