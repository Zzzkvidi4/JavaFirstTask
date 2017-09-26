package com.zzzkvidi4.command;

abstract class Command {

    Command(String title){
        this.title = title;
    }

    private String title;


    public String getTitle() {
        return title;
    }

    public boolean isEnabled() {
        return true;
    }

    public abstract void execute();
}