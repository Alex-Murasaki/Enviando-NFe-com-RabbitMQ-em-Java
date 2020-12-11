package Consumers.recv.control;

import Consumers.recv.model.NFe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManipulaXml {
        
    public String caminho = "C:\\Users\\Alex\\Desktop\\Teste01.xml";
    
    public String transformeEmStringXml(Object obj){

        // Instanciando XStream para gerar xml
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("NFe", NFe.class); // Trocando nome do campo na tabela xml

        // Gerando a tabela xml com o objeto passado
        String xml = xstream.toXML(obj);

        // Printando para teste
//        System.out.println(xml);
        
        // Toma aeh carai XMLZÃO BRABO
        return xml;

    }

    // Pega a string xml gerada e grava dentro de um arquivo no endereço setado
    public void gerarArquivo(String xml){
        PrintWriter print = null;
        
        // Tenta, cata e finalmente
        try{
        // Setando endereço, nome e extensão (.xml) do arquivo
            File file = new File(caminho);
            print = new PrintWriter(file);

            // Gravando de fato
            print.write(xml);
            print.flush();
            print.close();

        } catch (FileNotFoundException ex){
            Logger.getLogger(ManipulaXml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            print.close();
        }
    }
}