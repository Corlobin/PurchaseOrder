/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

/**
 *
 * @author Ricardo
 */
public class MainMiddle 
{
    public static OMElement getAll() 
    {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        //OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "StockQuoteService2");
        OMNamespace omNs = fac.createOMNamespace("http://quickstart2.samples/xsd","BancoProdutos");
        OMElement method = fac.createOMElement("getall", omNs);        
        return method;
    }
    
    public static OMElement buylista(String lista) 
    {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        //OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "StockQuoteService2");
        OMNamespace omNs = fac.createOMNamespace("http://quickstart2.samples/xsd","BancoProdutos");
        OMElement method = fac.createOMElement("buylista", omNs);
        
        //String produtos = "maca;10|pera;20|uva;30";
        
        OMElement value1 = fac.createOMElement("prods", omNs);
        value1.addChild(fac.createOMText(value1, lista ));
        method.addChild(value1);

        /*String[] compras = produtos.split("\\|");
        System.out.println(compras);
        for(int i = 0; i < compras.length; i++)
        {
            String[] produto = compras[i].split("\\;"); 
            System.out.println(produto[0] + " " + produto[1]);
        }*/
        
        return method;
    }
    
    public static OMElement check() 
    {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        //OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "StockQuoteService2");
        OMNamespace omNs = fac.createOMNamespace("http://quickstart2.samples/xsd","BancoProdutos");
        OMElement method = fac.createOMElement("check", omNs);
        return method;
    }
    public static OMElement aceitarOuNegarPedido(String resposta) 
    {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        //OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "StockQuoteService2");
        OMNamespace omNs = fac.createOMNamespace("http://quickstart2.samples/xsd","BancoProdutos");
        OMElement method = fac.createOMElement("aceitarPedido", omNs);

        OMElement value1 = fac.createOMElement("resposta", omNs);
        value1.addChild(fac.createOMText(value1, resposta));
        method.addChild(value1);
        return method;
    }


    public static OMElement add(String fruta, int preco)
    {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        //OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "StockQuoteService2");
        OMNamespace omNs = fac.createOMNamespace("http://quickstart2.samples/xsd","BancoProdutos");
        OMElement method = fac.createOMElement("add", omNs);
        
        OMElement value1 = fac.createOMElement("symbol", omNs);
        value1.addChild(fac.createOMText(value1, fruta));
        method.addChild(value1);
        OMElement value2 = fac.createOMElement("price", omNs);
        value2.addChild(fac.createOMText(value2, preco+""));
        method.addChild(value2);
        return method;
    }
    
    
}
