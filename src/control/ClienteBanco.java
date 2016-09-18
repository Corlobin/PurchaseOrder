/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

/**
 *
 * @author Ricardo
 */
public class ClienteBanco {
    private EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2/services/BancoProdutos");
    private ServiceClient sender;
    private OMElement payload;
    private Options options;
    private TestCallback axisCallback;
    
    public ClienteBanco() throws Exception
    {        
        try 
        {
            sender = new ServiceClient();
            options = new Options();
        }
        catch(Exception ex)
        {
            throw ex;
        }        
    }
    
    
    
    public String buscarProdutos() throws Exception
    {
        try
        {
            OMElement payload = MainMiddle.getAll();
            Options options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:getall");
            TestCallback axisCallback = new TestCallback("CallBack1") ;

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                Thread.sleep(100);
            }        
            
            return axisCallback.getResult();
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
    }
    
    public String aceitarOuNegarPedido(String resposta) throws Exception
    {
        try
        {
            OMElement payload = MainMiddle.aceitarOuNegarPedido(resposta);
            Options options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:aceitarPedido");
            TestCallback axisCallback = new TestCallback("Aceitando ou Negando o Pedido") ;

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                System.out.println("esperando rseposta");
                Thread.sleep(100);
            }        
            
            return axisCallback.getResult();
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
    }
    
    public void criarProdutos() throws Exception
    {
        try
        {
            
            OMElement payload = MainMiddle.add("pera", 50);
            Options options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:add");
            TestCallback axisCallback = new TestCallback("CallBack1") ;

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                Thread.sleep(100);
            }        
            
            payload = MainMiddle.add("maca", 50);
            options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:add");
            axisCallback = new TestCallback("CallBack1") ;

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                Thread.sleep(100);
            }        

        }
        
        catch(Exception ex)
        {
            throw ex;
        }
        
    }
    public void adicionarProduto(String nome, String preco) throws Exception
    {
        try
        {
            OMElement payload = MainMiddle.add(nome, Integer.parseInt(preco));
            Options options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:add");
            TestCallback axisCallback = new TestCallback("CallBack1") ;

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                Thread.sleep(100);
            }        
            System.out.println("Fruta criada: " + nome);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
    }
    
    public String realizarCompra(String compras) throws Exception
    {
        
        try 
        {
            payload = MainMiddle.buylista(compras);
            System.out.println(""+compras);
            options = new Options();
            axisCallback = new TestCallback("Callback realizar pedido de compra") ;

            options.setTo(targetEPR);
            options.setAction("urn:buylista");

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                System.out.println("Aguardando o pedido ser aceito..");
                Thread.sleep(1000);
                System.out.println("Aceitando o pedido ..");
                this.aceitarOuNegarPedido("1");
            }
            
            return axisCallback.getResult();
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    public String check() throws Exception
    {
        
        try 
        {
            payload = MainMiddle.check();
            options = new Options();
            axisCallback = new TestCallback("Callback Analisar Pedido de Compra:") ;

            options.setTo(targetEPR);
            options.setAction("urn:check");

            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);
            
            while ( ! axisCallback.isComplete( ) ) 
            {
                System.out.println("Esperando o cliente fazer um pedido..");
                Thread.sleep(1000);

            }
            
            return axisCallback.getResult();
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    /*public static void main(String[] args) 
    {

        try 
        {
            System.out.println("Adicionando a maca...");
            
            OMElement payload = MainMiddle.add("maca", 50);
            Options options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:add");
            TestCallback axisCallback = new TestCallback("CallBack1") ;
            
            sender = new ServiceClient();
            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                System.out.println("waiting..");
                Thread.sleep(100);
            }

            System.out.println("Dando update na maca...");
            
            payload = MainMiddle.buy("maca");
            options = new Options();
            options.setTo(targetEPR);
            options.setAction("urn:buy");
            axisCallback = new TestCallback("CallBack1") ;
            sender = new ServiceClient();
            sender.setOptions(options);
            sender.sendReceiveNonBlocking(payload, axisCallback);

            while ( ! axisCallback.isComplete( ) ) 
            {
                System.out.println("waiting..");
                Thread.sleep(1000);
      
            }
            System.out.println("finish");

        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        } finally {
            try {
                sender.cleanup();
            } catch (AxisFault axisFault) {
                axisFault.printStackTrace();
            }
        }
        System.out.print("cabo");
    }*/

}
