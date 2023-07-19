package modelo.pagamento;

public interface DocumentoPagavel {

    double getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo() {
        System.out.println("***** RECIBO *****");
        System.out.println("VALOR TOTAL: " + getValorTotal());
        System.out.println("PAGO: " + (estaPago() ? "SIM" : "NÃO"));
    }
}
