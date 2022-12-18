package spells.jdk16;

public class PatternMatchingInstanceOf {

    public static void main(String[] args) {
        Object obj = "Rafael";

        if (obj instanceof Integer num) {
            System.out.println(num.intValue());
        } else if (obj instanceof String text) {
            System.out.println(text.trim());
        }
    }

}
