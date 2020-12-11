package Consumers.recv.model;
/**
 *
 * @author Alex
 */
public class Fatura {

    private String vencimento;
    private String valor;

    public Fatura(String vencimento, String valor) {
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
