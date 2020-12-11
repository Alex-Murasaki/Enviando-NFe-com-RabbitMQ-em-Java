package Consumers.recv;

import Consumers.recv.control.ManipulaXml;
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
            // Quando algo for capturado eu chamo a função criaNFeXml,
            if (!message.isEmpty()) {
                criaNFeXml(message);
                System.out.println("!! RECEBEUUU !!");
            }
        };
        // não sei o que isso faz mas deixa ele aí mó bonitinho
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
    
    // Pega a string (já formatada para XML) e faz a criação do arquivo
    public static void criaNFeXml(String msg) {
        // Classe que usamos para manipular o XML
        ManipulaXml manipulaXml = new ManipulaXml();
        // gerar o XML da mensagem
        manipulaXml.gerarArquivo(msg);
        
        System.out.println("O XML FOI GERADO DÁ UMA OLHADA AÍ");
    }
}
