
package net.tecgurus.cteservice._1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "cteService", targetNamespace = "http://www.tecgurus.net/cteService/1.0", wsdlLocation = "file:/home/amaro/WORKSPACES_ECLIPSE/TEC_GURUS_JEE_MZO/tg-jee-marzo/clase1/hola-mundo/hola-mundo-web/src/main/webapp/wsdl/clientes.wsdl")
public class CteService
    extends Service
{

    private final static URL CTESERVICE_WSDL_LOCATION;
    private final static WebServiceException CTESERVICE_EXCEPTION;
    private final static QName CTESERVICE_QNAME = new QName("http://www.tecgurus.net/cteService/1.0", "cteService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/amaro/WORKSPACES_ECLIPSE/TEC_GURUS_JEE_MZO/tg-jee-marzo/clase1/hola-mundo/hola-mundo-web/src/main/webapp/wsdl/clientes.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTESERVICE_WSDL_LOCATION = url;
        CTESERVICE_EXCEPTION = e;
    }

    public CteService() {
        super(__getWsdlLocation(), CTESERVICE_QNAME);
    }

    public CteService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTESERVICE_QNAME, features);
    }

    public CteService(URL wsdlLocation) {
        super(wsdlLocation, CTESERVICE_QNAME);
    }

    public CteService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTESERVICE_QNAME, features);
    }

    public CteService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CteServicePortType
     */
    @WebEndpoint(name = "cteServicePort")
    public CteServicePortType getCteServicePort() {
        return super.getPort(new QName("http://www.tecgurus.net/cteService/1.0", "cteServicePort"), CteServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CteServicePortType
     */
    @WebEndpoint(name = "cteServicePort")
    public CteServicePortType getCteServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.tecgurus.net/cteService/1.0", "cteServicePort"), CteServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTESERVICE_EXCEPTION!= null) {
            throw CTESERVICE_EXCEPTION;
        }
        return CTESERVICE_WSDL_LOCATION;
    }

}
