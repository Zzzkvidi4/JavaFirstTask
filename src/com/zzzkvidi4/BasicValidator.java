package com.zzzkvidi4;

/**
 * Created by Роман on 14.09.2017.
 */
abstract class BasicValidator<T> {
    public BasicValidator(String validationFailsMsg, T initialValue){
        this.validationFailsMsg = validationFailsMsg;
        this.initialValue = initialValue;
    }

    abstract boolean validate(T value);

    private String validationFailsMsg;

    String message(){
        return validationFailsMsg;
    }

    private T initialValue;

    T initialValue(){
        return initialValue;
    }

    abstract T cast(String value);
}
