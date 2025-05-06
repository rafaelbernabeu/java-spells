package demo.jdk14;

import java.util.Scanner;
import java.util.logging.Logger;

public class SwitchExpression {

    private static final Logger LOG = Logger.getLogger(SwitchExpression.class.getName());

    public static void main(String... args) {
        LOG.info("Welcome!");
        var scan = new Scanner(System.in);

        while (true) {
            LOG.info(switchExpression(scan.nextLine()));
        }
    }

    private static String switchExpression(String nome) {
        return switch (nome) {
            case "rafael" -> "Bem-vindo ADM!";
            case "secret" -> {
                LOG.info("Ah mlk! Descobriu o segredo");
                yield "h4x0r";
            }
            case "exit", "quit", "off" -> "No!";
            default -> throw new IllegalArgumentException();
        };
    }
}
