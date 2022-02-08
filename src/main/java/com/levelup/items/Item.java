package com.levelup.items;

public class Item {

    int value = 1;
    String name;

    String DEFAULT_NAME = "Item of value " + value;

    public Item() {
        this.name = DEFAULT_NAME;
    }

    public Item(String name, int value) {
        super();
        this.name = name;
        this. value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    
}
