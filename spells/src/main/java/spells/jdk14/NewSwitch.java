package spells.jdk14;

import java.util.Scanner;

public class NewSwitch {

    public static void main(String... args) {
        System.out.println("Welcome!");
        var scan = new Scanner(System.in);

        while (true) {
            System.out.println(newSwitch(scan.nextLine()));
        }
    }

    private static String newSwitch(String nome) {
        return switch (nome) {
            case "rafael" -> "Bem-vindo ADM!";
            case "secret"-> {
                System.out.println("Ah mlk! Descobriu o segredo");
                yield "h4x0r";
            }
            case "exit", "quit", "off" -> "No!";
            default -> throw new IllegalArgumentException();
        };
    }
}
