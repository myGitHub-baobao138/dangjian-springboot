package com.partybuilding.webserver.util;

import java.io.*;

/**
 *
 * 序列化工具类
 */
public class SerializeUtils {

    /**
     * 将对象序列化成字符串
     * @param obj
     * @return
     * @throws IOException
     */
    public  String serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        String string = byteArrayOutputStream.toString("ISO-8859-1");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return string;
    }

    /**
     * 将字符串反序列化成对象
     * @param str
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  Object serializeToObject(String str) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return object;
    }
}