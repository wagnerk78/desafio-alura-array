import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {


        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual o valor do limite de seu cartão de crédito? ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        System.out.println("Digite 1 para fazer um lançamento ou 0 para sair:  ");
        int dado = leitura.nextInt();
        while (dado != 0) {
            System.out.println("Digite a descrição da compra");
            String gasto = leitura.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextInt();

            Compra compra = new Compra(gasto, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 1 para fazer um lançamento ou 0 para sair:  ");
                dado = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                dado = 0;
            }

        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " +c.getValor());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " +cartao.getSaldo());
    }
}
