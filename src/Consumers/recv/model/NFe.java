package Consumers.recv.model;
/**
 *
 * @author Alex
 */
public class NFe {
    
    Geral geral;
    Destinatario destinatario;
    Fatura fatura;
    Transportador transportador;

    public NFe(
            Geral geral,
            Destinatario destinatario,
            Fatura fatura,
            Transportador transportador
    ) {
        this.geral = geral;
        this.destinatario = destinatario;
        this.fatura = fatura;
        this.transportador = transportador;
    }
    
    public Geral getGeral() {
        return geral;
    }

    public void setGeral(Geral geral) {
        this.geral = geral;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Transportador getTansportador() {
        return transportador;
    }

    public void setTansportador(Transportador transportador) {
        this.transportador = transportador;
    }
    
    
    
}
