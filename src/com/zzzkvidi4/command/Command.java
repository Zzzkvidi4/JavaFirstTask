package com.zzzkvidi4.command;

public abstract class Command {

    Command(String title){
        this.title = title;
    }

    private String title;


    public String getTitle() {
        return title;
    }

    public abstract boolean isEnabled();

    public abstract void execute();
}