package com.zzzkvidi4.validator;

/**
 * Created by Роман on 14.09.2017.
 */
public abstract class BasicValidator<T> {
    public BasicValidator(String validationFailsMsg, T initialValue){
        this.validationFailsMsg = validationFailsMsg;
        this.initialValue = initialValue;
        this.isAbortAllowed = false;
    }

    public BasicValidator(String validationFailsMsg, T initialValue, boolean isAbortAlowed){
        this.validationFailsMsg = validationFailsMsg;
        this.initialValue = initialValue;
        this.isAbortAllowed = isAbortAlowed;
    }

    public abstract boolean validate(T value);

    private String validationFailsMsg;

    private boolean isAbortAllowed;

    public String message(){
        return validationFailsMsg;
    }

    private T initialValue;

    public T initialValue(){
        return initialValue;
    }

    public abstract T cast(String value);

    public boolean isAbortAllowed() {
        return isAbortAllowed;
    }
}
