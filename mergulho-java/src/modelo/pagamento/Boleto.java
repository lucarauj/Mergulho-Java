package modelo.pagamento;

import modelo.Pessoa;

import java.math.BigDecimal;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {

    private Pessoa beneficiario;
    private BigDecimal valor;
    private boolean estaPago;

    public Boleto(BigDecimal valor, Pessoa beneficiario) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public BigDecimal getValorTotal() {
        return this.valor;
    }

    @Override
    public boolean estaPago() {
        return this.estaPago;
    }

    @Override
    public void estornarPagamento() {
        estaPago = false;
    }

    @Override
    public void quitarPagamento() {
        this.estaPago = true;
    }

}
