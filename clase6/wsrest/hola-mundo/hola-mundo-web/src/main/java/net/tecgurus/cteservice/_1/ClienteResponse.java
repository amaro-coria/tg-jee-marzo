
package net.tecgurus.cteservice._1;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="response_data" type="{http://www.tecgurus.net/cteService/1.0}cliente_data" maxOccurs="unbounded"/>
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
@XmlRootElement(name = "cliente_response")
public class ClienteResponse {

    @XmlElement(name = "response_data", required = true)
    protected List<ClienteData> responseData;

    /**
     * Gets the value of the responseData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the responseData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponseData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClienteData }
     * 
     * 
     */
    public List<ClienteData> getResponseData() {
        if (responseData == null) {
            responseData = new ArrayList<ClienteData>();
        }
        return this.responseData;
    }

}
