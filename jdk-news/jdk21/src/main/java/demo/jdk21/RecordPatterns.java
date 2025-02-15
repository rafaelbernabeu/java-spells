package demo.jdk21;

public class RecordPatterns {

    public record Point(int x, int y){}

    public static void main(String[] args) {

        Object point = new Point(0, 0);

        if (point instanceof Point(int x, int y)) {
            System.out.println(x);
            System.out.println(y);
        }
    }
}
