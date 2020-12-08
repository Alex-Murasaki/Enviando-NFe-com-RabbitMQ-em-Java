package Consumers.recv.model;
/**
 *
 * @author Alex
 */
public class Transportador {

    private String nome;
    private String cnpj;
    private String placa;
    private String endereco;
    private String municipio;
    private String uf;
    private String quantidade;
    private String especie;
    private String peso;

    public Transportador(String nome, String cnpj, String placa, String endereco, String municipio, String uf, String quantidade, String especie, String peso) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.placa = placa;
        this.endereco = endereco;
        this.municipio = municipio;
        this.uf = uf;
        this.quantidade = quantidade;
        this.especie = especie;
        this.peso = peso;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    
    
}
