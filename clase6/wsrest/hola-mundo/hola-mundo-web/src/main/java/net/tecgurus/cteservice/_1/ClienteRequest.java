
package net.tecgurus.cteservice._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request_data" type="{http://www.tecgurus.net/cteService/1.0}entrada_data"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestData"
})
@XmlRootElement(name = "cliente_request")
public class ClienteRequest {

    @XmlElement(name = "request_data", required = true)
    protected EntradaData requestData;

    /**
     * Obtiene el valor de la propiedad requestData.
     * 
     * @return
     *     possible object is
     *     {@link EntradaData }
     *     
     */
    public EntradaData getRequestData() {
        return requestData;
    }

    /**
     * Define el valor de la propiedad requestData.
     * 
     * @param value
     *     allowed object is
     *     {@link EntradaData }
     *     
     */
    public void setRequestData(EntradaData value) {
        this.requestData = value;
    }

}
