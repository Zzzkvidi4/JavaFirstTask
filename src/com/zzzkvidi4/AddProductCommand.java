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
}
