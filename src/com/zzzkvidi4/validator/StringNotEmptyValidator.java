package com.zzzkvidi4.validator;

public class StringNotEmptyValidator extends BasicValidator<String> {
    public StringNotEmptyValidator(String validationFailsMsg){
        super(validationFailsMsg, "");
    }

    @Override
    public boolean validate(String value) {
        return !value.equals("");
    }

    @Override
    public String cast(String value) {
        return value;
    }
}
