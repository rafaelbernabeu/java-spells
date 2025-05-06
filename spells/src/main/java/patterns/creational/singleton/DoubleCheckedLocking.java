package patterns.creational.singleton;

/**
 * Double-checked locking is a design pattern used to reduce the overhead of acquiring a lock by first testing the locking criterion (the "check") without actually acquiring the lock.
 * Only if the check indicates that locking is required does the actual locking logic proceed.
 * This pattern is often used in lazy initialization scenarios, where an object is created only when it is needed.
 *
 * See:
 * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
 * https://www.oracle.com/technical-resources/articles/javase/bloch-effective-08-qa.html
 * https://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 */
public class DoubleCheckedLocking {

    // Double-check idiom for lazy initialization of instance fields.
    private volatile Object field;

    Object getField() {
        Object result = field;
        if (result == null) { // First check (no locking)
            synchronized (this) {
                result = field;
                if (result == null) // Second check (with locking)
                    field = result = computeFieldValue();
            }
        }
        return result;
    }

    private Object computeFieldValue() {
        return new Object();
    }

}
