package com.stars.javaz.reflect.base.service;

import com.stars.javaz.reflect.base.Cat;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class CatService implements ICatService{

    private String name;
    public Cat createCat(String name) {
        System.out.println("createCat:" + name);
        return new Cat(name);
    }

    private Cat create(String name) {
        System.out.println("create:" + name);
        return new Cat(name);
    }

}
