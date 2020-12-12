package Consumers.recv.model;
/**
 *
 * @author Alex
 */
public class Transportador {

    private String cnpj;
    private String placa;
    private String endereco;
    private String municipio;
    private String uf;
    private String quantidade;
    private String peso;

    public Transportador(String cnpj, String placa, String endereco, String municipio, String uf, String quantidade, String peso) {
        this.cnpj = cnpj;
        this.placa = placa;
        this.endereco = endereco;
        this.municipio = municipio;
        this.uf = uf;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    
    
}
