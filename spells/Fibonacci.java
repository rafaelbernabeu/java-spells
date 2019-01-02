package spells;

/**
 * @author Rafael Bernabeu
 */
public class Fibonacci {

    private static int ultimoValor;
    private static int valorAtual = 1;

    public static void main(String[] args) {
        fibonacci1();

        for (int i = 1; i < 100; i++) {
            System.out.println(fibonacci2(i));
        }

    }

    private static void fibonacci1() {
        System.out.println(valorAtual);
        while (valorAtual < 1000000000) {
            int proximoValor;
            System.out.println(proximoValor = ultimoValor + valorAtual);
            ultimoValor = valorAtual;
            valorAtual = proximoValor;
        }
    }

    public static int fibonacci2(int n) {
        return n < 2 ? n : fibonacci2(n - 1) + fibonacci2(n - 2);
    }
}
