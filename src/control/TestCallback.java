/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo
 */
public class TestCallback implements AxisCallback {

    private String name = null;
    private String result;
    
    private boolean complete = false;

    public TestCallback (String name) 
    {
        this.name = name;
    }

    public void onError (Exception e) 
    {
        e.printStackTrace();
    }

    public void onComplete() {
        System.out.println( "Message transmission complete") ;
        complete = true;
    }

    public boolean isComplete() {
        return complete;
    }

    public void onMessage(org.apache.axis2.context.MessageContext arg0) 
    {    
        result = arg0.getEnvelope().getBody().getFirstElement().getFirstElement().getText();        
        System.out.println(""+result);
    }
    
    public void onFault(org.apache.axis2.context.MessageContext arg0) 
    {
        System.out.println( "Call Back " + name + " got Fault: " + arg0.getEnvelope() ) ;
    }    
    
    
    public String getResult()
    {
        return this.result;
    }
}
