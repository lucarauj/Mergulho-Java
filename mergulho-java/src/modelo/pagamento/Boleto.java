package modelo.pagamento;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {

    private Pessoa beneficiario;
    private double valor;
    private boolean estaPago;

    public Boleto(double valor, Pessoa beneficiario) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public double getValorTotal() {
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
