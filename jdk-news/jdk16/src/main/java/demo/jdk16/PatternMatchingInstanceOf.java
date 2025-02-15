package demo.jdk16;

public class PatternMatchingInstanceOf {


    public static void main(String[] args) {
        Object obj = "Rafael";

        if (obj instanceof Integer num) {
            System.out.println(num.intValue());
        } else if (obj instanceof String text) {
            System.out.println(text.trim());
        }
    }

    public static boolean teste(Object obj) {
        if (!(obj instanceof String str)) {
            throw new RuntimeException();
        }

        System.out.println(str.trim());
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
