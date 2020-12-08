package Consumers.recv.model;
/**
 *
 * @author Alex
 */
public class Geral{
    
    private String numero;
    private String serie;
    private String natureza;
    private String cnpj;

    public Geral(String numero, String serie, String natureza, String cnpj) {
        this.numero = numero;
        this.serie = serie;
        this.natureza = natureza;
        this.cnpj = cnpj;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    
}
