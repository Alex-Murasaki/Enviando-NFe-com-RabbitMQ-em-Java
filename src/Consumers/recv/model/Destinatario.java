package Consumers.recv.model;
/**
 *
 * @author Alex
 */
public class Destinatario{


    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cep;
    private String municipio;
    private String fone;
    private String uf;

    public Destinatario(String razaoSocial, String cnpj, String endereco, String bairro, String cep, String municipio, String fone, String uf) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.municipio = municipio;
        this.fone = fone;
        this.uf = uf;
    }
   
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    
}
