package com.zzzkvidi4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpUtils {
    static int getChoiceCLI(String title, int minValue, int maxValue){
        String buf;
        boolean isInputCorrect = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while (!isInputCorrect){
            System.out.println(title);
            try {
                buf = reader.readLine();
                choice = Integer.parseInt(buf);
                isInputCorrect = (choice >= minValue) && (choice <= maxValue);
                if (!isInputCorrect) {
                    System.out.println("Число должно быть в диапазоне от " + String.valueOf(minValue) + " и до " + String.valueOf(maxValue) + ".");
                }
            }
            catch(IOException e){
                System.out.println("Внимание, произошла ошибка ввода!");
            }
            catch(NumberFormatException e){
                System.out.println("Внимание, вы ввели не число!");
            }
        }
        return 0;
    }

    public static int getChoiceCLI(String title, int maxValue) {
        return getChoiceCLI(title, 1, maxValue);
    }
}
