package demo.jdk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        scannetMethod();
        bufferedMethod();
        newestMethod();
    }

    private static void scannetMethod() {
        System.out.println("Digite seu nome:");

        Scanner scanner = new Scanner(System.in);
        String valorLido = scanner.nextLine();

        System.out.println("Bem vindo, " + valorLido + "!");
    }

    public static void bufferedMethod() {
        System.out.println("Digite seu nome:");

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String valorLido = bufferedReader.readLine();

            System.out.println("Bem vindo, " + valorLido + "!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void newestMethod() {
        String valorLido = IO.readln("Digite seu nome:\n");
        IO.println("Bem vindo, " + valorLido + "!");
    }
}