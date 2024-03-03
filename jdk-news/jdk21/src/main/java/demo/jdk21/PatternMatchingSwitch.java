package demo.jdk21;

public class PatternMatchingSwitch {

    public static void main(String[] args) {
        Object obj = "Rafael";

        switch (obj){
            case null -> System.out.println("null");
            case String s when s.length() > 1 -> System.out.println(s.trim());
            case Integer i when i > 10 -> System.out.println(i.intValue());
            case Double d -> System.out.println(d.doubleValue());
            default -> throw new IllegalArgumentException();
        }
    }

}
