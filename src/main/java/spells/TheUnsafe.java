package spells;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class TheUnsafe {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "./run-kafka-local.sh up"}).waitFor();
        Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "./run-kafka-local.sh down"}).waitFor();
    }

    private static final Unsafe THE_UNSAFE;

    static {
        try {
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };

            THE_UNSAFE = AccessController.doPrivileged(action);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }
}