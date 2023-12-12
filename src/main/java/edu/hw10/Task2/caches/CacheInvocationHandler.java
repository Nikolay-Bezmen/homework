package edu.hw10.Task2.caches;

import edu.hw10.Task2.annotations.Cache;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheInvocationHandler implements InvocationHandler {
    private final Object delegate;
    private final Map<String, Object> cache = new HashMap<>();
    private final File file;

    public CacheInvocationHandler(Object delegate, File file) {
        this.delegate = delegate;
        this.file = file;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }

        String cacheKey = method.getName() + Arrays.toString(args);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        Object result = method.invoke(delegate, args);
        cache.put(cacheKey, result);

        if (method.getAnnotation(Cache.class).persist()) {
            saveCacheToFile(cacheKey, result);
        }

        return result;
    }

    private void saveCacheToFile(String cacheKey, Object result) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(cacheKey);
            bw.write(" : ");
            bw.write(result.toString());
            bw.write("\n");
        }
    }
}
