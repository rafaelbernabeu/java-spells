package demo.jdk10;

import java.util.ArrayList;
import java.util.Arrays;

public class InferringLocalVariables {

    public static void main(String[] args) {
        var list = new ArrayList<String>();  // infers ArrayList<String>
        list.add("Hello");
        list.add("World!");
        var stream = list.stream();          // infers Stream<String>
        System.out.println(Arrays.toString(stream.toArray()));
    }

}
