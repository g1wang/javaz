package com.stars.javaz.reflect.test;

import com.stars.javaz.reflect.base.service.CatService;
import com.stars.javaz.reflect.base.service.ICatService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class DynamicProxyTest {


    public static void main(String[] args) {
        //代理对象
        ICatService catService = new CatService();
        CatServiceHandler catHandler = new CatServiceHandler(catService);
        ICatService catServiceProxy = (ICatService) Proxy.newProxyInstance(ICatService.class.getClassLoader(),
                new Class[]{ICatService.class}, catHandler);
        System.out.println("--- before");
        String name ="miao";
        catServiceProxy.createCat(name);
        System.out.println("--- after");


    }

}

class CatServiceHandler implements InvocationHandler {

    ICatService target;

    public CatServiceHandler(ICatService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke( target,objects);
    }
}
