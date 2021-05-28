package com.stars.javaz.reflect.test;

import com.stars.javaz.reflect.base.Cat;
import com.stars.javaz.reflect.base.service.CatService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class TestCatService {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //获取类
        //两种方法
        //Class cls = Class.forName("com.stars.javaz.reflect.base.service.CatService");
        Class cls = CatService.class;

        //获取构造方法
        //Constructor[] constructors = cls.getConstructors();
        Class[] params = {};
        Constructor constructor =cls.getConstructor(params);
        //构造对象
        Object obj = constructor.newInstance();

        //获取public method
        Method method = cls.getMethod("createCat", String.class);
        method.invoke(obj,"open cat");
        Cat pblCat = (Cat) method.invoke(obj,"pub cat");
        //获取私有方法
        Method priMtd = cls.getDeclaredMethod("create", String.class);
        //解除私有
        priMtd.setAccessible(true);

        //私有属性
        Field f = cls.getDeclaredField("name");
        f.setAccessible(true);
        f.set(obj,"yx");
        System.out.println(f.get(obj));

          //setAccessible 只对当前方法有效
//        Method priMtd2 = cls.getDeclaredMethod("create", String.class);
//        priMtd2.invoke(obj,"pri cat");

    }
}
