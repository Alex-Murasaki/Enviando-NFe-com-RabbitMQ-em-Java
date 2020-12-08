package Consumers.recv;

import Consumers.recv.model.Destinatario;
import Consumers.recv.model.Fatura;
import Consumers.recv.model.Geral;
import Consumers.recv.model.NFe;
import Consumers.recv.model.Transportador;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
/**
 *
 * @author Alex
 */
public class Recv {
    
    // A fila de mensagens do RabbitMQ
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        // Conecta com localhost usando a factory
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Delcara a fila e cria caso não existir
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. Stop it manually");

        // Só sei que isso fica ouvindo a fila e pega as mensagens que caem nela
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            // Captura a mensagem
            String message = new String(delivery.getBody(), "UTF-8");
            // Quando algo for capturado eu chamo a função BreakMessage passando
            // a própria mensagem como parâmetro
            if (!message.isEmpty()) {
                breakMessage(message);
            }
        };
        // não sei o que isso faz mas deixa ele aí mó bonitinho
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
    
    // Quebra a mensagem, a mensagem passada vem com um padrão
    // onde os campos são separados por ";", dou split() para separá-los
    //
    // TO-DO:
    // [ ] - Traze a string tratada, pronta pra gravar no XML
    public static void breakMessage(String msg) {
        String[] str = msg.split(";");
        // Classe que pega infos gerais da nota (um "cabeçalho")
        Geral geral = new Geral(
                str[0],
                str[1],
                str[2],
                str[3]
        );
        // Classe que pega infos do destinatario da NFe
        Destinatario destinatario = new Destinatario(
                str[4],
                str[5],
                str[6],
                str[7],
                str[8],
                str[9],
                str[10],
                str[11]
        );
        // Classe que pega infos da fatura da NFe
        Fatura fatura = new Fatura(
                str[12],
                str[13],
                str[14]
        );
        // Classe que pega infos do transportador da NFe
        Transportador transportador = new Transportador(
                str[15],
                str[15],
                str[15],
                str[15],
                str[15],
                str[15],
                str[15],
                str[15],
                str[15]
        );
        // Classe da NFe composta das classes anteriores
        NFe nfe = new NFe(geral, destinatario, fatura, transportador);
        
        // Classe que usamos para manipular o XML, transformando classes em
        // string e gerando o XML num caminho escolhidp
        ManipulaXml manipulaXml = new ManipulaXml();
        // gerar o XML passando como parametro
        manipulaXml.gerarArquivo(
                manipulaXml.transformeEmStringXml(nfe)
        );
    }
}
