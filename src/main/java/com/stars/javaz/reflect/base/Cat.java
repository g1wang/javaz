package com.stars.javaz.reflect.base;

/**
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class Cat {
    private int id;
    private String name;
    public String name2;
    private String color;

    public Cat(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
