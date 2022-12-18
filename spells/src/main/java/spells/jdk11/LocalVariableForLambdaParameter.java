package spells.jdk11;

import java.util.function.Consumer;

public class LocalVariableForLambdaParameter {

    public static void main(String[] args) {

        Consumer<String> name = (var s) -> s.trim();

    }
}
