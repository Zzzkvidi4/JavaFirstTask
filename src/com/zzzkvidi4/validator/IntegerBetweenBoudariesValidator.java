package com.zzzkvidi4.validator;

public class IntegerBetweenBoudariesValidator extends BasicValidator<Integer> {
    private int leftBound, rightBound;
    public IntegerBetweenBoudariesValidator(String validationFailsMsg, int leftBound, int rightBound){
        super(validationFailsMsg, leftBound);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    @Override
    public boolean validate(Integer value) {
        return (value >= leftBound) && (value <= rightBound);
    }

    @Override
    public Integer cast(String value) {
        return null;
    }
}
