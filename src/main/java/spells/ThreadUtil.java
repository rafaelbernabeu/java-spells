package spells;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadUtil {

    private static ExecutorService executorService;

    public static ExecutorService getExecutorService() {
        ThreadPoolExecutor instance = SingletonUtil.getInstance(ThreadPoolExecutor.class);

        if (instance == null) {
            try {
                return SingletonUtil.putInstance(Executors.newCachedThreadPool());
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        return instance;

    }
}