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
                HelpUtils.getStringCLI("Input category of medicine: ");
            }
            catch (AbortOperationException ex){

            }
        }
    }
}
