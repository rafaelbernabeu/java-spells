package spells.jdk14;

import java.util.Scanner;

public class SwitchExpression {

    public static void main(String... args) {
        System.out.println("Welcome!");
        var scan = new Scanner(System.in);

        while (true) {
            System.out.println(switchExpression(scan.nextLine()));
        }
    }

    private static String switchExpression(String nome) {
        return switch (nome) {
            case "rafael" -> "Bem-vindo ADM!";
            case "secret"-> {
                System.out.println("Ah mlk! Descobriu o segredo");
                yield "h4x0r";
            }
            case "exit", "quit", "off" -> { yield "No!"; }
            default -> throw new IllegalArgumentException();
        };
    }
}
