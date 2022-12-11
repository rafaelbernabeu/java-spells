package spells;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PerformanceCheck {

    public void call(Object object, Method method, int times, Object... params) throws InvocationTargetException, IllegalAccessException {
        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            method.invoke(object, params);
        }
        Duration duration = Duration.of(System.currentTimeMillis() - before, ChronoUnit.MILLIS);
        System.out.println("Duration of " + duration.getSeconds() +" seconds / " + duration.getNano() + " nanos");
    }
}
