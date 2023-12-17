package edu.hw10.Task2.caches;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Proxy;

public class CacheProxy {
    private CacheProxy() {
    }

    public static <T> T create(T obj, Class<T> interfaceClass, File file) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsoluteFile().toString(), "rw")) {
            randomAccessFile.setLength(0);
        }
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass},
            new CacheInvocationHandler(obj, file)
        );
    }
}
