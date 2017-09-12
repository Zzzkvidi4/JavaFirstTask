package com.zzzkvidi4;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandList {
    private ArrayList<Command> commandList = new ArrayList<>();

    public void printCommandTitles(String header){
        Iterator<Command> commandIterator = commandList.iterator();
        System.out.println(header);
        int i = 1;
        while (commandIterator.hasNext()){
            System.out.println(i + ". " + commandIterator.next().getTitle());
        }
    }

    public void executeCommand(int index){
        commandList.get(index).execute();
    }

    public void add(Command cmd){
        commandList.add(cmd);
    }

    public void clear() {
        commandList.clear();
    }
}
