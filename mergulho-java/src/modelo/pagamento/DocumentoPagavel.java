package modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo() {
        System.out.println("***** RECIBO *****");
        System.out.println("VALOR TOTAL: " + getValorTotal());
        System.out.println("PAGO: " + (estaPago() ? "SIM" : "NÃO"));
    }
}
