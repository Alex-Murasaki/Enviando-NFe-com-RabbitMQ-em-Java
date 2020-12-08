package Consumers.recv.model;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class NFe {
    
    private ArrayList<String> geral = new ArrayList<>();
    private ArrayList<String> destinatario = new ArrayList<>();
    private ArrayList<String> fatura = new ArrayList<>();
    private ArrayList<String> transportador = new ArrayList<>();

    public NFe(
            ArrayList<String> geral, 
            ArrayList<String> destinatario, 
            ArrayList<String> fatura, 
            ArrayList<String> transportador
    ) {
        this.geral = geral;
        this.destinatario= destinatario;
        this.fatura = fatura;
        this.transportador = transportador;
    }

    public ArrayList<String> getGeral() {
        return geral;
    }

    public void setGeral(ArrayList<String> geral) {
        this.geral = geral;
    }

    public ArrayList<String> getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(ArrayList<String> destinatario) {
        this.destinatario = destinatario;
    }

    public ArrayList<String> getFatura() {
        return fatura;
    }

    public void setFatura(ArrayList<String> fatura) {
        this.fatura = fatura;
    }

    public ArrayList<String> getTransportador() {
        return transportador;
    }

    public void setTransportador(ArrayList<String> transportador) {
        this.transportador = transportador;
    }
    
    
    
}
