package com.advanced.dome.reflection;

import com.advanced.dome.util.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author guohong
 * 反射
 */
public class MainReflect {

    /**
     * 获取class 对象的三种方式
     * Class.forName()
     * 类名.class
     * 对象名.getClass()
     */
    private void getClazz() {
        try {
//            Class<?> aClass = Class.forName("com.advanced.dome.util.Car");
//            System.out.println(Car.class);
            Car car = new Car();
            Class<? extends Car> aClass = car.getClass();
//            System.out.println(aClass);
//            System.out.println(aClass);
//            System.out.println(car.getClass() == aClass);
            //class常用方法
            //String getName() 获取全类名
            //ClassLoader getClassLoader() 返回类的类加载器。
            //类<?>[] getInterfaces() 确定由该对象表示的类或接口实现的接口。
            //Package getPackage() 获取此类的包。
            aClass.getName();
            System.out.println(aClass.getClassLoader());

            System.out.println(aClass.getPackage());
            Class<?>[] interfaces = aClass.getInterfaces();
            System.out.println(Arrays.toString(interfaces));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象
     *
     * @throws NoSuchFieldException
     */
    private void getClassAttributes() throws NoSuchFieldException, IllegalAccessException {

        Car car = new Car();
        Class<? extends Car> aClass = car.getClass();
        //获取class对象的全类名
        System.out.println(aClass.getName());

        //获取对象的全部public修饰的对象
        Field[] fields = aClass.getFields();
        //获取指定名称 由public修饰的对象
//        System.out.println(Arrays.toString(fields));
        Field name = aClass.getField("name");
//        System.out.println(name);
        name.set(car, "ceshi");
        System.out.println(car);
        //获取对象的全部对象，不考虑修饰符
        Field[] declaredFields = aClass.getDeclaredFields();
//        System.out.println(Arrays.toString(declaredFields));

        //通过名称获取对象不考虑修饰符
        Field length = aClass.getDeclaredField("length");
//        System.out.println(length);

    }

    /**
     * 获取构造方法
     */
    private void getConstructors() throws NoSuchMethodException {
        Car car = new Car();
        Class<? extends Car> aClass = car.getClass();
        Constructor<?>[] constructors = aClass.getConstructors();
        //通过传入参数类型寻找构造参数
        Constructor<? extends Car> constructor = aClass.getConstructor(String.class);


        System.out.println(constructor);
        System.out.println(Arrays.toString(constructors));
    }

    /**
     * 获取成员变量
     */
    private void getVariables() throws Exception {
        Car car = new Car();
        Class<? extends Car> aClass = car.getClass();
        //获取全部对象
        Method[] methods = aClass.getMethods();
        System.out.println(Arrays.toString(methods));
        //通过名称获取成员变量
        Method getLength = aClass.getMethod("getLength");
        System.out.println(getLength);
        Field f = aClass.getDeclaredField("length");
        //暴力破解反射
        f.setAccessible(true);
        f.set(car,"123");
        //调用成员变量
        // 在具有指定参数的方法对象上调用此方法对象表示的底层方法。
        //如果底层方法是静态的，则指定的obj参数将被忽略。 它可能为null。
        //如果底层方法所需的形式参数的数量为0，则提供的args数组的长度为0或为空。
        Object invoke = getLength.invoke(car, null);

        System.out.println(invoke);


    }


    public static void main(String[] args) throws Exception {
        MainReflect mainReflect = new MainReflect();
        mainReflect.getClazz();//获取class方法
//        mainReflect.getClassAttributes(); //获取对象
//        mainReflect.getConstructors();// 构造参数
//        mainReflect.getVariables();//获取成员变量

    }

}
