package task2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 定义ClassLoader，用来从文件 Hello.xlass 中加载类
 * @author Jaymie on 2021/1/9
 */
public class HelloClassLoader extends ClassLoader {
    /**
     * 类所在的路径
     */
    private String path;

    /**
     * 需要加载的文件的后缀名
     */
    private String suffix;

    public HelloClassLoader(String path, String suffix) {
        this.path = path;
        this.suffix = suffix;
    }

    /**
     * 读取要加载文件成字节流
     * @param name 类名
     * @return byte[]
     */
    private byte[] readFileToByts(String name) {
        String fileName = path + name + suffix;
        System.out.println(fileName);
        File file = new File(fileName);
        try (InputStream in = new FileInputStream(file);
             ByteArrayOutputStream out = new ByteArrayOutputStream()){
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = readFileToByts(name);
        // 进行转换，取反操作
        for (int i = 0; i < bytes.length; i++) {
            byte temp = bytes[i];
            bytes[i] = (byte) (~temp);
        }
        System.out.println(HelloClassLoader.class.getName() + " loading");
        return defineClass(name, bytes, 0, bytes.length);
    }
}
