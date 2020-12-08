package Consumers.recv;

import Consumers.recv.model.NFe;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Alex
 */
public class Recv {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. Stop it manually");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            if (!message.isEmpty()) {
                breakMessage(message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
    
    public static void breakMessage(String msg) {
        String[] str = msg.split(";");
        
        NFe nfe;
        
        ArrayList<NFe> nfeArray = new ArrayList<>();
        ArrayList<String> geral = new ArrayList<>();
        ArrayList<String> destinatario = new ArrayList<>();
        ArrayList<String> fatura = new ArrayList<>();
        ArrayList<String> transportador = new ArrayList<>();
        
        for (int i = 0; i < str.length; i++){
            if (i < 4) {
                geral.add(str[i]);
                System.out.println("A - "+ i +": "+ str[i]);
            }
            else if (i < 12) {
                destinatario.add(str[i]);
                System.out.println("B - "+ i +": "+ str[i]);
            }
            else if (i < 15) {
                fatura.add(str[i]);
                System.out.println("C - "+ i +": "+ str[i]);
            }
            else {
                transportador.add(str[i]);
                System.out.println("D - "+ i +": "+ str[i]);
            }
        }
        
        
        
        nfe = new NFe(geral, destinatario, fatura, transportador);
        nfeArray.add(nfe);
        
        Map<String, String> map = new HashMap<String, String>();
        
        String sim = "nao";
        
        ManipulaXml manipulaXml = new ManipulaXml();
        manipulaXml.gerarArquivo(
                manipulaXml.arrayListParaXml(nfe)
        );
        
    }
    
}
