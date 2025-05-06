package patterns.creational.singleton;

/**
 * Alexander Terekhov (TEREKHOV@de.ibm.com) came up clever suggestion for
 * implementing double checked locking using thread local storage.
 * Each thread keeps a thread local flag to determine whether
 * that thread has done the required synchronization.
 */
public class ThreadLocalFlag {
    /**
     * If perThreadInstance.get() returns a non-null value, this thread
     * has done synchronization needed to see initialization
     * of helper
     */
    private final ThreadLocal<Object> perThreadInstance = new ThreadLocal<>();
    private Object helper = null;

    public Object getObject() {
        if (perThreadInstance.get() == null) createObject();
        return helper;
    }

    private final void createObject() {
        synchronized (this) {
            if (helper == null)
                helper = new Object();
        }
        // Any non-null value would do as the argument here
        perThreadInstance.set(perThreadInstance);
    }
}
