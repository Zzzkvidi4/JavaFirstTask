package com.zzzkvidi4;

public class AbortOperationException extends Throwable {
    private String msg;

    public AbortOperationException(String msg){
        super(msg);
    }

    public AbortOperationException() {
        super();
    }
}
