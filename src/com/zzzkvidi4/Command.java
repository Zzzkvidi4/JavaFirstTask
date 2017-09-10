package com.zzzkvidi4;

public abstract class Command {

    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void execute();
}
