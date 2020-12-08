package Producers.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 *
 * @author Alex
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        
        String[] message = {
            "000111;"
            + "1;"
            + "Venda de Mercadorias;"
            + "111.111.111-11;"
            + "Alberto Almeida;"
            + "111.111.111-11;"
            + "Rua Rio Verde;"
            + "Centro;"
            + "75.603-000;"
            + "Porteirao;"
            + "3643-xxxx;"
            + "GO;"
            + "000175/1;"
            + "07/12/2020;"
            + "100,00;"
            + "Brenda Bernardes;"
            + "222.222.222-22;"
            + "AAA-0000;"
            + "Rua Corrego Azul;"
            + "Porteirao;"
            + "GO;"
            + "3;"
            + "Caixas;"
            + "60kg",
            // Outra
            "000222;"
            + "2;"
            + "Venda de Mercadorias;"
            + "222.222.222-22;"
            + "Celina Cunha;"
            + "222.222.222-22;"
            + "Rua Rio Verde;"
            + "Centro;"
            + "75.603-000;"
            + "Porteirao;"
            + "3643-xxxx;"
            + "GO;"
            + "000175/1;"
            + "07/12/2020;"
            + "100,00;"
            + "Drauzio Dornelles;"
            + "333.333.333-33;"
            + "AAA-0000;"
            + "Rua Corrego Azul;"
            + "Porteirao;"
            + "GO;"
            + "3;"
            + "Caixas;"
            + "60kg",
            // Outra
            
        };
        
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
            
            /*for (int i = 0; i < message.length; i++) {
                channel.basicPublish("", QUEUE_NAME, null, message[i].getBytes());
            }*/
            channel.basicPublish("", QUEUE_NAME, null, message[1].getBytes());
            
            System.out.println("!!SUCESSO!!");
        }
    }
}