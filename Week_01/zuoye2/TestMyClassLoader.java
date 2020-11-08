package zuoye2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader=new MyClassLoader();
        Class<?> hello = myClassLoader.loadClass("Hello");
        Object o = hello.newInstance();
        Method helloMethod = hello.getMethod("hello");
        Object invoke = helloMethod.invoke(o);
    }
}
