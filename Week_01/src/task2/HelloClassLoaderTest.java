package task2;


import java.lang.reflect.Method;

/**
 * HelloClassLoader的测试类
 * @author Jaymie on 2021/1/9
 */
public class HelloClassLoaderTest {
    public static void main(String[] args) throws Exception {
        // 创建自定义类加载器
        HelloClassLoader helloClassLoader = new HelloClassLoader("/Users/jaymie/study/learn-java/JAVA-01/Week_01/src/task2/", ".xlass");
        Class<?> helloClazz = helloClassLoader.findClass("Hello");
        // 创建实例对象
        Object helloObject = helloClazz.newInstance();
        // 获取 hello 方法
        Method hello = helloClazz.getDeclaredMethod("hello");
        // 调用该方法
        hello.invoke(helloObject);
    }

}
