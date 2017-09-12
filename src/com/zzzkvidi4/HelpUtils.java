package com.zzzkvidi4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpUtils {
    private static String abortString = "";

    static int getChoiceCLI(String title, int minValue, int maxValue) throws AbortOperationException{
        String buf;
        boolean isInputCorrect = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.MIN_VALUE;
        while (!isInputCorrect){
            System.out.println(title);
            try {
                buf = reader.readLine();
                if (buf.equals("abort")){
                    throw new AbortOperationException();
                }
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
        return choice;
    }

    public static int getChoiceCLI(String title, int maxValue) throws AbortOperationException {
        return getChoiceCLI(title, 1, maxValue);
    }

    static String getStringCLI(String title) throws AbortOperationException {
        String buf = "";
        boolean isInputCorrect = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isInputCorrect){
            System.out.println(title);
            try {
                buf = reader.readLine();
                if (buf.equals("abort")){
                    throw new AbortOperationException();
                }
                isInputCorrect = !buf.equals("");
                if (!isInputCorrect) {
                    System.out.println("Строка не должна быть пустой!");
                }
            }
            catch(IOException e){
                System.out.println("Внимание, произошла ошибка ввода!");
            }
        }
        return buf;
    }

    public static void setAbortString(String abort){
        abortString = abort;
    }
}
