package com.zzzkvidi4;

import java.util.List;

public class AddProductCommand extends Command {
    private List<Object> productList;

    public AddProductCommand(String title, List<Object> productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public void execute(){

    }

    class AddMedidcineCommand extends Command {
        public AddMedidcineCommand(String title){
            super(title);
        }

        @Override
        public void execute() {
            try {
                HelpUtils<Integer> intGetter = new HelpUtils<>();
                int val = intGetter.getValueCLI("Введите число:", new BasicValidator<Integer>("some", 0) {
                    @Override
                    boolean validate(Integer value) {
                        int tmp = value;
                        return tmp > 0;
                    }

                    @Override
                    Integer cast(String value) {
                        return Integer.valueOf(value);
                    }
                });
                Medicine medicine = new Medicine();
            }
            catch (AbortOperationException ex){

            }
        }
    }
}
