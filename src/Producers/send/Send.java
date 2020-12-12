package Producers.send;

import Consumers.recv.control.ManipulaXml;
import Consumers.recv.model.Destinatario;
import Consumers.recv.model.Fatura;
import Consumers.recv.model.Geral;
import Consumers.recv.model.NFe;
import Consumers.recv.model.Transportador;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 *
 * @author Alex
 */
public class Send {

    private final static String QUEUE_NAME = "fila_nota_fiscal";

    public static void main(String[] argv) throws Exception {
        // instancianco classes que serão necessárias psteriormente
        NFe nfe; // nota fiscal eletronica
        ManipulaXml manipulaXml = new ManipulaXml(); // formata e gera um xml
        // informações gerais da nfe
        Geral geral = new Geral(
                "000123", // numero
                "Venda de Mercadoria", // natureza
                "111.222.333-45" // cnpj
        );
        // informações de destinatario da nfe
        Destinatario destinatario = new Destinatario(
                "Aristóteles Phylosofo", // razao social
                "555.444.333-21", // cnpj
                "Rua Rio Verde", // endereco
                "Centro", // bairro
                "75.603-000", // cep
                "Porteirao", // municipio
                "GO" // uf
        );
        // informações de fatura da nfe
        Fatura fatura = new Fatura(
              "11/12/2020", // vencimento
              "999,90" // valor
        );
        // informações de transportador da nfe
        Transportador transportador = new Transportador(
                "777.666.555-01", // cpf/cnpj
                "ABC-0101", // placa
                "Rua Limoeiro Vermelho", // endereço
                "Christanópolis", // municipio
                "GO", // uf
                "2", // quantidade
                "10kg" // peso
        );
        // constói a nfe com suas dependencias
        nfe = new NFe(geral, destinatario, fatura, transportador);
        // transfoma a classe nfe em uma string com formato xml
        String menssagem = manipulaXml.transformeEmStringXml(nfe);
        // cria conexão utilizando a factory
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        // tenta conexão, envia mensagem, etc
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
            channel.basicPublish("", QUEUE_NAME, null, menssagem.getBytes());
            
            System.out.println("!! CONSEGUIUUUUU !!");
        }
    }
}