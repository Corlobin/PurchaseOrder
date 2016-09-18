/**
 * BancoProdutosCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package samples.quickstart2;


/**
 *  BancoProdutosCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class BancoProdutosCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public BancoProdutosCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public BancoProdutosCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for get method
     * override this method for handling normal response from get operation
     */
    public void receiveResultget(
        samples.quickstart2.BancoProdutosStub.GetResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from get operation
     */
    public void receiveErrorget(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for check method
     * override this method for handling normal response from check operation
     */
    public void receiveResultcheck(
        samples.quickstart2.BancoProdutosStub.CheckResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from check operation
     */
    public void receiveErrorcheck(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getall method
     * override this method for handling normal response from getall operation
     */
    public void receiveResultgetall(
        samples.quickstart2.BancoProdutosStub.GetallResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getall operation
     */
    public void receiveErrorgetall(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for add method
     * override this method for handling normal response from add operation
     */
    public void receiveResultadd(
        samples.quickstart2.BancoProdutosStub.AddResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from add operation
     */
    public void receiveErroradd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for buy method
     * override this method for handling normal response from buy operation
     */
    public void receiveResultbuy(
        samples.quickstart2.BancoProdutosStub.BuyResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from buy operation
     */
    public void receiveErrorbuy(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for buylista method
     * override this method for handling normal response from buylista operation
     */
    public void receiveResultbuylista(
        samples.quickstart2.BancoProdutosStub.BuylistaResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from buylista operation
     */
    public void receiveErrorbuylista(java.lang.Exception e) {
    }
}
