package zuoye2;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "D:\\geekbang\\JAVA-000\\Week_01\\" + name + ".xlass";
        System.out.println(path);
        File classFile = new File(path);
        byte[] bytes = new byte[1024];
        byte[] readBytes = null;
        InputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(classFile);
            int length;
            while (-1 != (length = fileInputStream.read(bytes))) {
                byteArrayOutputStream.write(bytes, 0, length);
            }
            readBytes = byteArrayOutputStream.toByteArray();
            for (int i = 0; i < readBytes.length; i++) {
                readBytes[i] = (byte) (255-readBytes[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name,readBytes,0, readBytes.length);
    }
}

