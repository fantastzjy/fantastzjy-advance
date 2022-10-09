package com.fantastzjy.lintener;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class SingeThreadUtil {

    private static ExecutorService kafkaConsumer;

    public SingeThreadUtil() {
    }

    public static ExecutorService getKafkaConsumer() {
        return kafkaConsumer;
    }

    static {
        kafkaConsumer = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),
                new CustomizableThreadFactory("singe-Thread-pool-kfa"));
    }
}
