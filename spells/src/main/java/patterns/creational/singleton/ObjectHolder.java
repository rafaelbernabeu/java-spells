package patterns.creational.singleton;

/**
 *
 * This relies on the fact that nested classes are not loaded until they are referenced.
 *
 */

public class ObjectHolder {

    private static class Holder {
       public static final Object helper = new Object();
    }

    public static Object getHelper() {
        return Holder.helper;
    }

}
