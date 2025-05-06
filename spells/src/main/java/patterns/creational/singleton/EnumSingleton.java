package patterns.creational.singleton;

public enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
        System.out.println("EnumSingleton constructor");
    }

    public void doSomething() {
        System.out.println("Doing something");
    }
}
