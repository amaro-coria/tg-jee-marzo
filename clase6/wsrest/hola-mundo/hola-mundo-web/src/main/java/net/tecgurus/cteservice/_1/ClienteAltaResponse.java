
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
 *         &lt;element name="response_data" type="{http://www.tecgurus.net/cteService/1.0}salida_estatus"/>
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
    "responseData"
})
@XmlRootElement(name = "cliente_alta_response")
public class ClienteAltaResponse {

    @XmlElement(name = "response_data", required = true)
    protected SalidaEstatus responseData;

    /**
     * Obtiene el valor de la propiedad responseData.
     * 
     * @return
     *     possible object is
     *     {@link SalidaEstatus }
     *     
     */
    public SalidaEstatus getResponseData() {
        return responseData;
    }

    /**
     * Define el valor de la propiedad responseData.
     * 
     * @param value
     *     allowed object is
     *     {@link SalidaEstatus }
     *     
     */
    public void setResponseData(SalidaEstatus value) {
        this.responseData = value;
    }

}
