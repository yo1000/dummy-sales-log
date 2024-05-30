package com.yo1000.saleslog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceManager {
    private final Logger logger = LoggerFactory.getLogger(ExecutorServiceManager.class);

    private final ExecutorService[] executorServices;

    public ExecutorServiceManager(int capacity) {
        executorServices = new ExecutorService[capacity];

        for (int i = 0; i < executorServices.length; i++) {
            executorServices[i] = Executors.newSingleThreadExecutor();
        }
    }

    public void submit(String key, Runnable task) {
        byte[] digest = DigestUtils.md5Digest(key.getBytes(StandardCharsets.UTF_8));
        int tail2 = ((digest[digest.length - 2] & 0xFF) << 8) | (digest[digest.length - 1] & 0xFF);
        int index = tail2 % executorServices.length;
        submit(index, task);
    }

    public void submit(int index, Runnable task) {
        if (logger.isDebugEnabled()) {
            logger.debug("Chosen thread index: {} of {}", index, executorServices.length);
        }
        executorServices[index].submit(task);
    }
}
