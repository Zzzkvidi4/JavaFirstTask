package com.zzzkvidi4;

import com.zzzkvidi4.validator.BasicValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpUtils<T> {
    private static String abortString = "";

    T getValueCLI(String title, BasicValidator<T> validator) throws AbortOperationException{
        String buf;
        boolean isInputCorrect = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T value = validator.initialValue();
        while (!isInputCorrect){
            System.out.println(title);
            try {
                buf = reader.readLine();
                if ((validator.isAbortAllowed()) && (buf.equals(abortString))){
                    throw new AbortOperationException("Отмена операции...");
                }
                value = validator.cast(buf);
                isInputCorrect = validator.validate(value);
                if (!isInputCorrect) {
                    System.out.println(validator.message());
                }
            }
            catch(IOException e){
                System.out.println("Внимание, произошла ошибка ввода!");
            }
            catch(NumberFormatException e){
                System.out.println("Внимание, вы ввели не число!");
            }
        }
        return value;
    }
}
